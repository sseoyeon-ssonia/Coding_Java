import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h, ans;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {

			st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j <w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						ans++;
					}
				}
			}

			System.out.println(ans);

		}

	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int tempR = temp[0];
			int tempC = temp[1];


			for (int d = 0; d < 8; d++) {
				int nr = tempR + dr[d];
				int nc = tempC + dc[d];

				if (nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == 0 || visited[nr][nc])
					continue;
				
				visited[nr][nc]=true;
				q.add(new int[] { nr, nc });
			}
		}

	}
}
