import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class node{
        int target,type;

        node(int target, int type){
            this.target = target;
            this.type = type;
        }

    } //연결 정보(edges) 나타내는 클래스
    
    ArrayList<node>[] graph; //연결 정보 그래프
    int N, K,answer; //n,k,answer 변수

    public int solution(int n, int infection, int[][] edges, int k) {
        answer = 1; //최초 감염 무조건 = 1개
        N=n;
        K=k;

        graph = new ArrayList[n+1];

        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<>();
        } // 그래프 초기화

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int type = edge[2];

            graph[from].add(new node(to,type));
            graph[to].add(new node(from,type));
        } //그래프 표현. 무방향 가중(파이프 타입) 그래프

        boolean[] infected = new boolean[n+1];
        infected[infection] = true; //최초 감염 상태

        dfs(0,infected); //파이프 선택 순서 완전탐색

        return answer;
    }
    void dfs(int depth, boolean[] infected){
        if(depth>=K){ //k번 모두 수행했을 경우
            answer = Math.max(answer, count(infected));
            //answer 업데이트, 현재 케이스 감염체 수 카운트
            return;
        }

        for(int t = 1; t<=3; t++){ //이번 차례에 A,B,C 각각 선택
            boolean[] visited = infected.clone();
            //다른 DFS와 섞이지 않도록 복사 -> 이번 턴의 BFS 전달

            bfs(t,visited);
            
            dfs(depth+1,visited); //재귀
        }


    }
    void bfs(int selectedType, boolean[] nowInfected){ 
        //현재 열린 파이프 타입, 이번 턴의 방문 여부 기준으로 퍼짐
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<nowInfected.length;i++){
            if(nowInfected[i]){
                queue.offer(i);
            } //현재 감염된 값들 다 큐에 넣기
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(node n : graph[current]){
                if(n.type != selectedType){ //현재 열린 타입 아니라면 건너뜀
                    continue;
                }

                if(nowInfected[n.target]){ //이미 방문했다면 건너뜀
                    continue;
                }
                //새로운 감염된 배양체
                nowInfected[n.target] = true;
                queue.offer(n.target);
            }
        }

    }
    int count(boolean[] nowInfected){ //현재 감염된 배양체 수
        int now = 0;
        for(int i = 1;i<nowInfected.length;i++){
            if(nowInfected[i]) now++;
        }
        return now;
    }

}