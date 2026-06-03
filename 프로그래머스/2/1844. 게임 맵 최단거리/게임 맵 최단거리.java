import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int solution(int[][] maps) {


        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited=new boolean[n][m];



        Queue<int[]> queue = new LinkedList<>();
        //위치 r,c, 현재까지 거리 dist

        queue.offer(new int[] {0,0,1});
        visited[0][0]=true;


        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int nowR = now[0];
            int nowC = now[1];
            int dist = now[2];


            for(int i = 0;i<4;i++){
                int nr = nowR+dr[i];
                int nc = nowC+dc[i];

                if(nr<0 || nc<0 || nr>=n || nc>=m || visited[nr][nc] || maps[nr][nc]==0) continue;


                maps[nr][nc]=dist+1;
                visited[nr][nc]=true;

                queue.offer(new int[] {nr,nc,dist+1});


            }

            if(visited[n-1][m-1]) return maps[n-1][m-1];

        }

        return -1;
    }
}