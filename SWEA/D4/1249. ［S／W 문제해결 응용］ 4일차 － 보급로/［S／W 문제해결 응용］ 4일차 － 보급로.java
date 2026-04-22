import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] map;
	static int[][] dist;
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
			map = new int[n][n];
			dist = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String temp = st.nextToken();
				for (int j = 0; j < n; j++) {
					map[i][j] = temp.charAt(j) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			dist[0][0] = 0;

			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

			pq.add(new int[] { 0, 0, 0 }); // 시작점

			while (!pq.isEmpty()) {
				int[] temp = pq.poll();

				int r = temp[0];
				int c = temp[1];
				int cost = temp[2];

				if (r == n - 1 && c == n - 1)
					break;

				if (visited[r][c])
					continue;

				visited[r][c] = true;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc])
						continue;

					if (dist[nr][nc] > map[nr][nc] + cost) {
						dist[nr][nc] = map[nr][nc] + cost;
						pq.add(new int[] { nr, nc, dist[nr][nc] });
					}
				}

			}

			System.out.println("#" + tc + " " + dist[n - 1][n - 1]);

		} // tc 끝

	}// main 끝
}
