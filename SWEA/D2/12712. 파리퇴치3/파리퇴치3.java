import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution
{
    static int[] dr1 = { -1, 1, 0, 0 };
    static int[] dc1 = { 0, 0, -1, 1 };
    static int[] dr2 = { -1, -1, 1, 1 };
    static int[] dc2 = { -1, 1, -1, 1 };
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
 
            int[][] map = new int[n + m + m][n + m + m];
            for (int i = m; i < n + m; i++) {
                for (int j = m; j < n + m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
 
            // 십자
            int max = 0;
 
            for (int r = m; r < n + m; r++) {
                for (int c = m; c < n + m; c++) {
                    int sum = map[r][c];
 
                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k < m; k++) {
 
                            int dr = r + dr1[d] * k;
                            int dc = c + dc1[d] * k;
 
                            sum += map[dr][dc];
 
                        }
                    }
                    if (sum > max)
                        max = sum;
 
                }
            }
            // 대각선
 
            for (int r = m; r < n + m; r++) {
                for (int c = m; c < n + m; c++) {
                    int sum = map[r][c];
                    for (int d = 0; d < 4; d++) {
                        for (int k = 1; k < m; k++) {
 
                            int dr = r + dr2[d] * k;
                            int dc = c + dc2[d] * k;
 
                            sum += map[dr][dc];
 
                        }
                    }
                    if (sum > max)
                        max = sum;
 
                }
            }
 
            System.out.printf("#%d %d%n", t, max);
 
        }
    }
}