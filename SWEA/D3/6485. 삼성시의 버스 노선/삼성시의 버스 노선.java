import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int T = Integer.parseInt(st.nextToken());
        for(int tc = 1;tc<=T;tc++) {
             
            st = new StringTokenizer(br.readLine());
             
            int[] stops = new int[5001];
             
            int n = Integer.parseInt(st.nextToken());
             
            for(int i = 0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                 
                for(int j = a;j<=b;j++) {
                    stops[j]++;
                }
                 
            }
             
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            StringBuilder ans = new StringBuilder();
             
 
            for(int i = 0;i<p;i++) {
                st = new StringTokenizer(br.readLine());
                int now = Integer.parseInt(st.nextToken());
                 
                ans.append(" ").append(stops[now]);
                 
            }
             
            System.out.println("#"+tc+ans);
             
        }//tc 끝
         
    }
}