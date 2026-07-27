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
    ArrayList<node>[] graph;
    int N, K,answer;

    public int solution(int n, int infection, int[][] edges, int k) {
        answer = 1;
        N=n;
        K=k;

        graph = new ArrayList[n+1];

        for(int i = 1;i<=n;i++){
            graph[i] = new ArrayList<>();
        } // 그래프 작성 위한 초기화

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int type = edge[2];

            graph[from].add(new node(to,type));
            graph[to].add(new node(from,type));
        } //그래프 표현

        boolean[] infected = new boolean[n+1];
        infected[infection] = true;

        dfs(0,infected);

        return answer;
    }
    void dfs(int depth, boolean[] infected){
        if(depth>=K){
            answer = Math.max(answer, count(infected));
            return;
        }

        for(int t = 1; t<=3; t++){
            boolean[] visited = infected.clone();

            bfs(t,visited);
            dfs(depth+1,visited);
        }


    }
    void bfs(int selectedType, boolean[] nowInfected){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<nowInfected.length;i++){
            if(nowInfected[i]){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(node n : graph[current]){
                if(n.type != selectedType){
                    continue;
                }

                if(nowInfected[n.target]){
                    continue;
                }
                nowInfected[n.target] = true;
                queue.offer(n.target);
            }
        }

    }
    int count(boolean[] nowInfected){
        int now = 0;
        for(int i = 1;i<nowInfected.length;i++){
            if(nowInfected[i]) now++;
        }
        return now;
    }

}