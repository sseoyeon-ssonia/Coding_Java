import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, w, h, ans;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 구슬 수
			w = Integer.parseInt(st.nextToken()); // 열
			h = Integer.parseInt(st.nextToken()); // 행

			int[][] map = new int[h][w];
			int remain = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						remain++;
				}
			}
			// 입력 완

			ans = remain;
			dfs(0, map, remain);

			System.out.println("#" + tc + " " + ans);

		} // tc 끝

	}// main 끝

	static void dfs(int depth, int[][] map, int remain) {
		if (ans == 0)
			return;

		ans = Math.min(ans, remain);

		if (depth == n || remain == 0)
			return;

		for (int c = 0; c < w; c++) {
			int r = findTop(map, c);

			if (r == -1) {
				dfs(depth + 1, map, remain);
				continue;
			}

			int[][] next = copyMap(map);

			int broken = explode(next, r, c);
			gravity(next);

			dfs(depth + 1, next, remain - broken);
		}
	}

	static int findTop(int[][] map, int col) {
		for (int r = 0; r < h; r++) {
			if (map[r][col] != 0)
				return r;
		}
		return -1;
	}

	static int explode(int[][] map, int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();

		int broken = 1;
		q.offer(new int[] { sr, sc, map[sr][sc] });
		map[sr][sc] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int power = cur[2];

			for (int d = 0; d < 4; d++) {
				for (int dist = 1; dist < power; dist++) {
					int nr = r + dr[d] * dist;
					int nc = c + dc[d] * dist;

					if (nr < 0 || nr >= h || nc < 0 || nc >= w)
						break;
					if (map[nr][nc] == 0)
						continue;

					if (map[nr][nc] > 1)
						q.offer(new int[] { nr, nc, map[nr][nc] });

					map[nr][nc] = 0;
					broken++;
				}

			}

		}
		return broken;
	}

	static void gravity(int[][] map) {
		for (int c = 0; c < w; c++) {
			int[] temp = new int[h];
			int idx = h - 1;

			for (int r = h - 1; r >= 0; r--) {
				if (map[r][c] != 0) {
					temp[idx--] = map[r][c];
				}
			}

			for (int r = 0; r < h; r++) {
				map[r][c] = temp[r];
			}
		}
	}

	static int[][] copyMap(int[][] map) {
		int[][] copy = new int[h][w];
		for (int r = 0; r < h; r++) {
			copy[r] = map[r].clone();
		}
		return copy;
	}

}
