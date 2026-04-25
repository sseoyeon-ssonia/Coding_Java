import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	static int n, ans, day; // 치즈 크기 n , 정답 ans, 필요 날(=최고 숫자) day
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			ans = 1;
			day = 0;
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > day)
						day = map[i][j];
				}
			}

			// 입력 끝
			for (int x = 1; x <= day; x++) {
				visited = new boolean[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] == x)
							visited[i][j] = true;
					}
				}

				int nowGroup = 0;

				Queue<int[]> q = new ArrayDeque<>();

				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						if (visited[r][c] || map[r][c]<=x)
							continue;

						q.add(new int[] { r, c });

						visited[r][c]=true;
						nowGroup++;
						
						while (!q.isEmpty()) {
							int[] start = q.poll();
							int startR = start[0];
							int startC = start[1];

							visited[startR][startC] = true;

							for (int d = 0; d < 4; d++) {
								int nr = startR + dr[d];
								int nc = startC + dc[d];

								if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc] || map[nr][nc]<=x)
									continue;

								visited[nr][nc] = true;
								q.add(new int[] { nr, nc });

							}

						}
						
					}
				}

				ans = Math.max(ans, nowGroup);

			}

			System.out.println("#" + tc + " " + ans);

		} // tc 끝

	}// main 끝

	// 시작점은 없고, 몇 개의 덩어리인지 알아내기

}
