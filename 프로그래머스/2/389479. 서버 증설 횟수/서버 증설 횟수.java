public class Solution {

        public int solution(int[] players, int m, int k) {
            int answer = 0;

            int[] nowServers = new int[players.length]; //특정 시간 운영 중 서버 수
            int cnt = 0; // 증설된 서버 수

            for(int i = 0;i<players.length;i++){
                if(players[i]<m){
                    continue;
                }//특정 시간 이용자가 m명 미만이라면 서버 증설 필요 없음
                else{
                    if(nowServers[i]<players[i]/m){
                        int needServer = players[i]/m-nowServers[i]; //이번에 증설하는 서버 수
                        cnt+=needServer;
                        for(int j=i;j<players.length && j<i+k;j++){
                            nowServers[j]+=needServer;
                        }
                    }
                }//특정 시간 이용자가 m명 이상이라면 서버 개수 확인 필요
            }
            answer=cnt;

            return answer;
        }
}
