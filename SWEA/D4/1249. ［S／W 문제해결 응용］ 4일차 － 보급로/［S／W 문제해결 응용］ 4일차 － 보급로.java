import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
import javax.print.attribute.standard.RequestingUserName;
 
public class Solution {
     
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
     
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int T = Integer.parseInt(st.nextToken());
        for(int tc = 1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
             
            map = new int[n][n];
             
            for(int i = 0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                String temp = st.nextToken();
                for(int j = 0;j<n;j++) {
                    map[i][j]=temp.charAt(j)-'0';
                }
            }
             
            //입력 끝
             
            dist = new int[n][n];
            for(int i = 0;i<n;i++) {
                for(int j = 0;j<n;j++) {
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
             
            visited = new boolean[n][n];
             
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
             
            dist[0][0]=0;
            int[] now = {0,0,dist[0][0]};
            pq.add(now);
             
            while(!pq.isEmpty()) {
                int[] temp = pq.poll();
                 
                int r = temp[0];
                int c = temp[1];
                int cost = temp[2];
                 
                if(r == n-1 && c == n-1) break;
                 
                if(visited[r][c]) continue;
                 
                visited[r][c]=true;
                 
                for(int i = 0;i<4;i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                     
                    if(nr<0 || nc<0 || nr>=n|| nc>=n) continue;
                     
                    if(!visited[nr][nc] && dist[nr][nc]>cost+map[nr][nc]) {
                        dist[nr][nc] = cost+map[nr][nc];
                        int[] next = {nr,nc,dist[nr][nc]};
                        pq.add(next);
                    }
                     
                }
                 
            }
             
            System.out.println("#"+tc+" "+dist[n-1][n-1]);
             
        }
         
    }
}