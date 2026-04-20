import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int bestStart, bestCnt; // 결과
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 입력 끝
			bestStart = 1;
			bestCnt = 1;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int r = i;
					int c = j;

					int nowResult = map[i][j];
					int nowCnt = 1;

					while (true) {
						boolean flag = false;
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];

							if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == map[r][c] + 1) {
								nowCnt++;
								r = nr;
								c = nc;
								flag = true;
								break;
							}

						}
						if (!flag)
							break;
					}

					if (nowCnt > bestCnt) {
						bestCnt = nowCnt;
						bestStart = map[i][j];
					} else if (nowCnt == bestCnt) {
						bestStart = Math.min(bestStart, map[i][j]);
					}

				}
			}

			System.out.println("#" + tc + " " + bestStart + " " + bestCnt);
		} // tc 끝

	}// main 끝

}
