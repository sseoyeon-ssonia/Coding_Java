import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, m, r, c, l, ans; // 지도 크기n,m 맨홀 위치 r,c 소요시간 l
	static int[][] map;
	static boolean[][] visited;

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 각 파이프별 이동 가능 방향
	static int[][] dir = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };

	static int[] opposite = { 1, 0, 3, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 입력 끝

			visited = new boolean[n][m];

			ans = 1;
			bfs();
			System.out.println("#" + tc + " " + ans);

		} // tc 끝

	}// main 끝

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c, 1 });

		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int tempR = temp[0];
			int tempC = temp[1];
			int tempTime = temp[2];

			visited[tempR][tempC] = true;
			if (tempTime == l)
				continue;

			int type = map[tempR][tempC];
			for (int x : dir[type]) {
				int nr = tempR + dr[x];
				int nc = tempC + dc[x];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc])
					continue;

				if (map[nr][nc] == 0)
					continue;

				// 연결되어있느지 확인
				if (!check(x, nr, nc))
					continue;

				visited[nr][nc] = true;
				ans++;
				q.add(new int[] { nr, nc, tempTime + 1 });

			}

		}

	}

	private static boolean check(int type, int nr, int nc) {
		int tempType = map[nr][nc];
		int checkDir = opposite[type];
		for (int x : dir[tempType]) {
			if (checkDir == x)
				return true;
		}
		return false;
	}
}
