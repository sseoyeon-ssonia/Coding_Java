

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m, n, h;
	static int[][][] map; // 각각 h, n, m
	static boolean[][][] visited;

	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 }; // 위아래

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][n][m];
		visited = new boolean[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		// 입력 끝

		int day = -1;

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 1) {
						visited[i][j][k] = true;
						q.add(new int[] { i, j, k });
					}
				}
			}
		}

		while (!q.isEmpty()) {
			int tempSize = q.size();
			day++;
			for (int i = 0; i < tempSize; i++) {
				int[] temp = q.poll();
				int z = temp[0];
				int x = temp[1];
				int y = temp[2];
				
				for (int d = 0; d < 6; d++) {
					int nz = z + dz[d];
					int nr = x + dr[d];
					int nc = y + dc[d];

					if (nz>=0 && nr >= 0 && nc >= 0 && nz<h&& nr < n && nc < m && !visited[nz][nr][nc] && map[nz][nr][nc] ==0) {
						visited[nz][nr][nc] = true;
						map[nz][nr][nc]=1;
						q.add(new int[] { nz, nr, nc });
					}
				}
			}
		}

		boolean flag = true;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (map[i][j][k] == 0) {
						flag = false;
						day = -1;
						break;
					}
				}
				if (!flag) {
					break;
				}
			}
			if (!flag) {
				break;
			}
		}

		System.out.println(day);

	}

}
