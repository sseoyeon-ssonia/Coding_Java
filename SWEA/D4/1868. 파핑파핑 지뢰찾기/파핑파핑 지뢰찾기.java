import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.FileInputStream;


class Solution
{
    static int n;
	static char[][] map;
	static int[][] cntMap; // 주변 지뢰 개수 저장해둔 맵
	static boolean[][] visited;
	static int ans;

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {

			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			cntMap = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {

				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '*') {
						visited[i][j] = true;
					}
				}
			}
			// 입력 끝

			// cntMap 처리
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int r = i;
					int c = j;

					if (map[r][c] == '*') {
						cntMap[r][c] = 10;
						continue;
					}

					int tempCnt = 0;
					for (int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (nr < 0 || nc < 0 || nr >= n || nc >= n || map[nr][nc] != '*')
							continue;

						tempCnt++;
					}

					cntMap[r][c] = tempCnt;
				}
			}

			ans = 0;

			// 값 0 처리
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int r = i;
					int c = j;

					if (cntMap[r][c] != 0 || visited[r][c])
						continue;

					zeroCnt(r, c);
				}
			}

			// 나머지 처리
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int r = i;
					int c = j;

					if (visited[r][c])
						continue;
					visited[r][c] = true;
					ans++;

				}
			}

			System.out.println("#" + tc + " " + ans);

		} // tc 끝

	}// main 끝

	// 8방향 값이 0인지 확인, 그렇다면 큐에 넣기
	// 큐에 넣은 것들 처리 = 클릭 1회
	static void zeroCnt(int r, int c) {
		// 하나씩 탐색하며 0인 것들 처리
		ans++;

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];

			for (int d = 0; d < 8; d++) {
				int nx = x + dr[d];
				int ny = y + dc[d];

				// 범위
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				// 이미 방문
				if (visited[nx][ny])
					continue;

				// 해당 좌표 값 0인 경우 -> 큐에 넣기
				if (cntMap[nx][ny] == 0) {
					q.add(new int[] { nx, ny });
				}

				// 방문처리
				visited[nx][ny] = true;

			}

		}

	}// zeroCnt 끝
}