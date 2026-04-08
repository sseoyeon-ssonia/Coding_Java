import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        for(int tc = 1;tc<=T;tc++){
 
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
 
            int[][] dist = new int[n][n];
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(i!=j) dist[i][j]=Integer.MAX_VALUE;
                }
            }//dist 초기화
 
            for(int i = 0;i<m;i++){
                st = new StringTokenizer(br.readLine());
 
                int start = Integer.parseInt(st.nextToken())-1;
                int end = Integer.parseInt(st.nextToken())-1;
 
                dist[start][end] = 1;
            }
 
 
            for(int x = 0;x<n;x++){
                for(int from = 0;from<n;from++){
                    if(dist[from][x]==Integer.MAX_VALUE) continue;
                    for(int to = 0;to<n;to++){
                        if(dist[x][to]==Integer.MAX_VALUE) continue;
                        dist[from][to]=1;
                    }
                }
            }
 
            int ans = 0;
            for(int i = 0;i<n;i++){
                int cnt = 0;
                for(int j = 0;j<n;j++){
                    if(i==j) continue;
                    if(dist[i][j]!=Integer.MAX_VALUE || dist[j][i]!=Integer.MAX_VALUE) cnt++;
                }
                if(cnt==n-1) ans++;
            }
 
            System.out.println("#"+tc+" "+ans);
 
        }//tc 끝
 
    }//main 끝
}