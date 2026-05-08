import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = {};

        int[][] map = new int[m][n]; // 전체 맵 세팅
        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            map[r][c] = i+1; //빗방울 순서 1부터 저장
        }

        int INF = Integer.MAX_VALUE;
        // 가로 슬라이싱. 구역 내 최솟값 저장
        int[][] rowSlicing = new int[m][n-w+1];

        for(int i=0;i<m;i++){
            Deque<Integer> deque = new ArrayDeque<>(); //앞쪽 값이 항상 최솟값
            //이 deque은 값이 아니라 인덱스가 저장됨

            for(int j=0;j<n;j++){
                int now = map[i][j]==0 ? INF : map[i][j]; //비 안 맞았다면 INF.(번째 순서 비교 위함)

                while(!deque.isEmpty()){
                    int last = deque.peekLast(); //덱의 맨 뒤 인덱스
                    int lastVal = map[i][last]==0 ? INF : map[i][last]; //해당 칸이 비 안 맞는다면 INF, 아니면 순서

                    if(lastVal>=now) deque.pollLast(); //현재값보다 크거나 같으면 제거
                    else break; //현재보다 작으면 중단

                }
                deque.offerLast(j); //현재 인덱스 덱 뒤에 추가
                if(deque.peekFirst()<=j-w) deque.pollFirst(); //윈도우 범위 벗어남 = 맨 왼쪽 인덱스보다 작다면 제거
                if(j>=w-1){ //윈도우가 w칸 채워진 경우에만 저장
                    rowSlicing[i][j-w+1]=map[i][deque.peekFirst()]; //해당 윈도우 내 최솟값
                }
            }
        }

        // 세로 슬라이싱
        int[][] colSlicing = new int[m - h+1][n - w+1];
        for (int j = 0; j < n-w+1; j++) {
            Deque<Integer> deque = new ArrayDeque<>();//앞쪽 값이 항상 최솟값
            //이 deque은 값이 아니라 인덱스가 저장됨
            for (int i = 0; i < m; i++) {
                int now = rowSlicing[i][j]==0 ? INF : rowSlicing[i][j];
                while(!deque.isEmpty()){
                    int last = deque.peekLast(); //덱 마지막 인덱스
                    int  lastVal = rowSlicing[last][j]==0 ? INF : rowSlicing[last][j]; //덱 마지막 인덱스가 0이면 값은 무한
                    if(lastVal>=now) deque.pollLast(); //현재 값보다 크거나 같으면 제거
                    else break; //덱 마지막 값이 현재보다 작으면 중단
                }
                deque.offerLast(i); //현재 인덱스 덱 뒤에 추가
                if(deque.peekFirst()<i-h+1)  deque.pollFirst(); //윈도우 범위 벗ㅇ어남 = 맨 왼쪽 인덱스보다 작다면 제거
                if(i>=h-1){
                    colSlicing[i-h+1][j]=rowSlicing[deque.peekFirst()][j]; //해당 윈도우 내 최솟값
                }
            }
        }

        //결과 계산
        int bestTiming = Integer.MIN_VALUE;

        for (int i = 0; i < m - h+1; i++) {
            for (int j = 0; j < n - w+1; j++) {
                int tempTiming = colSlicing[i][j];
                if(tempTiming==0){
                    answer= new int[]{i,j};
                    return answer;

                }else if(tempTiming>bestTiming){
                    bestTiming = tempTiming;
                    answer= new int[]{i,j};
                }


            }
        }

        return answer;
    }
}