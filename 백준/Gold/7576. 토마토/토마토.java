import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		ans = -1;

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Queue<int[]> tempQ = new LinkedList<>();
			int nowSize = q.size();
			for (int i = 0; i < nowSize; i++) {
				tempQ.add(q.poll());
			}

			while (!tempQ.isEmpty()) {
				int[] temp = tempQ.poll();
				int tempR = temp[0];
				int tempC = temp[1];
				visited[tempR][tempC]=true;

				for (int d = 0; d < 4; d++) {
					int nr = tempR + dr[d];
					int nc = tempC + dc[d];

					if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == -1 || visited[nr][nc])
						continue;

					visited[nr][nc] = true;
					map[nr][nc]++;
					q.add(new int[] { nr, nc });
				}
			}
			ans++;
		}

		// 남아있는 0이 있다면 -1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j]==0&&!visited[i][j]) {
					ans = -1;
					break;
				}
			}
			if (ans == -1)
				break;
		}

		System.out.println(ans);

	}

}
