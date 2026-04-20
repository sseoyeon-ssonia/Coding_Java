import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    static int n, k, maxRoute;
    static int[][] map;
    static boolean[][] visited;
    static LinkedList<int[]> startList;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());


            map = new int[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //입력 끝

            //시작점 저장
            startList = new LinkedList<>();
            int maxNum = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > maxNum) {
                        maxNum = map[i][j];
                        startList.clear();
                        startList.add(new int[]{i, j});
                    } else if (map[i][j] == maxNum) {
                        startList.add(new int[]{i, j});
                    }
                }
            }

            maxRoute = 0;

            for (int[] temp : startList) {
                int tempR = temp[0];
                int tempC = temp[1];

                visited = new boolean[n][n];
                visited[tempR][tempC] = true;
                dfs(tempR, tempC, 1);
                visited[tempR][tempC] = false;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int original = map[i][j];

                    for (int c = 1; c <= k; c++) {
                        map[i][j] = original - c;

                        for (int[] temp : startList) {
                            int tempR = temp[0];
                            int tempC = temp[1];

                            visited = new boolean[n][n];
                            visited[tempR][tempC] = true;
                            dfs(tempR, tempC, 1);
                        }
                    }

                    map[i][j] = original;

                }
            }

            System.out.println("#" + tc + " " + maxRoute);

        }//tc 끝

    }//main 끝

    private static void dfs(int r, int c, int route) {
        maxRoute = Math.max(maxRoute, route);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
            if (map[nr][nc] >= map[r][c]) continue;

            visited[nr][nc] = true;
            dfs(nr, nc, route + 1);
            visited[nr][nc] = false;
        }
    }

}


