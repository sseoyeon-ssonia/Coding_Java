import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int startR, startC, endR, endC;
    static Queue<int[]> q;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for(int tc = 1;tc<=10;tc++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            map = new int[16][16];

            visited = new boolean[16][16];

            for (int i = 0; i < 16; i++) {
                st = new StringTokenizer(br.readLine());
                String temp = st.nextToken();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = temp.charAt(j) - '0';
                    if (map[i][j] == 2) {
                        startR = i;
                        startC = j;
                    } else if (map[i][j] == 3) {
                        endR = i;
                        endC = j;
                    }
                }
            }

            //입력 끝

            q = new ArrayDeque<>();

            bfs(startR,startC);

            if(visited[endR][endC]) System.out.println("#"+tc+" "+1);
            else System.out.println("#"+tc+" "+0);


        }

    }

    private static void bfs(int r, int c){
        visited[r][c]=true;
        q.add(new int[] {r,c});

        while (!q.isEmpty()){
            int[] temp = q.poll();
            int tempR = temp[0];
            int tempC = temp[1];

            for(int d=0;d<4;d++){
                int nr = tempR+dr[d];
                int nc = tempC+dc[d];

                if(nr<0 || nc<0 || nr>=16 || nc>=16) continue;

                if(map[nr][nc]!=1 && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    q.add(new int[] {nr,nc});
                }

            }

        }

    }

}
