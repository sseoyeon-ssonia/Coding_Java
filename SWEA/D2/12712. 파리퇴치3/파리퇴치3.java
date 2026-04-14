import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] dr1 = { -1, 1, 0, 0 };
    static int[] dc1 = { 0, 0, -1, 1 };
    static int[] dr2 = { -1, -1, 1, 1 };
    static int[] dc2 = { -1, 1, -1, 1 };
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
 
            int[][] map = new int[n][n];
 
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            // input 끝
 
            int maxFly = 0; // 최대 파리 수
 
            // 십자
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
 
                    int tempFly = 0;
                    for (int k = 0; k < 4; k++) {
                        int r = i;
                        int c = j;
 
                        for (int a = 1; a < m; a++) {
                            int nr = r + dr1[k] * a;
                            int nc = c + dc1[k] * a;
 
                            if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                                tempFly += map[nr][nc];
                            }
                        }
                    }
                    tempFly+=map[i][j];
 
                    maxFly = Math.max(maxFly, tempFly);
                }
            }
 
            // 대각선
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
 
                    int tempFly = 0;
                    for (int k = 0; k < 4; k++) {
                        int r = i;
                        int c = j;
 
                        for (int a = 1; a < m; a++) {
                            int nr = r + dr2[k] * a;
                            int nc = c + dc2[k] * a;
 
                            if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                                tempFly += map[nr][nc];
                            }
                        }
                    }
                    tempFly+=map[i][j];
 
                    maxFly = Math.max(maxFly, tempFly);
                }
            }
 
            System.out.println("#" + tc + " " + maxFly);
 
        } // tc 끝
 
    }
}