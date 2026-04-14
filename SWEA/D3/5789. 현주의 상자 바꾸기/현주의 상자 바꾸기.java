import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
 
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
 
            int[] box = new int[n + 1];
 
            for (int i = 1; i <= q; i++) {
                st = new StringTokenizer(br.readLine());
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
 
                for (int j = L; j <= R; j++) {
                    box[j] = i;
                }
 
            }
 
            StringBuilder ans = new StringBuilder();
 
            for (int i = 1; i <= n; i++) {
                ans.append(" ").append(box[i]);
            }
 
            System.out.println("#" + tc + ans);
 
        } // tc 끝
 
    }
}