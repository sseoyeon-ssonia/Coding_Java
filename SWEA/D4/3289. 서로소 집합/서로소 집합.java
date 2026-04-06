import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int n, m;
    static int[] parent;
    static StringBuilder ans;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
 
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
 
            parent = new int[n + 1];
 
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
 
            ans = new StringBuilder();
 
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int input = Integer.parseInt(st.nextToken());
 
                if (input == 0) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
 
                    if (x <= y)
                        union(x, y);
                    else
                        union(y, x);
 
                } else {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
 
                    int parentX = find(x);
                    int parentY = find(y);
                    if (parentX == parentY) {
                        ans.append(1);
                    } else
                        ans.append(0);
                }
            }
 
            System.out.println("#" + tc + " " + ans);
 
        } // tc 끝
 
    }// main 끝
 
    static int find(int a) {
        if (a != parent[a])
            parent[a] = find(parent[a]);
        return parent[a];
    }
 
    static void union(int a, int b) {
        parent[find(a)] = find(b);
    }
}