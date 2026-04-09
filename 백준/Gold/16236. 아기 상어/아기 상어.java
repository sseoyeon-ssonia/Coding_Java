import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int sharkR;
	static int sharkC; // 상어 위치
	static int sharkSize = 2; // 상어 현재 크기
	static int eatNow = 0; // 현재 먹은 물고기 수
	static int time = 0;
	static int canEatFish = 0;

	static int[][] map;

	private static class Fish {
		int fishR, fishC, dist;

		public Fish(int fishR, int fishC, int dist) {
			this.fishR = fishR;
			this.fishC = fishC;
			this.dist = dist;
		}

	}

	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };// 상좌우하

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 9) {
					sharkR = i;
					sharkC = j; // 상어 위치 저장
					map[i][j] = 0;
				}
			}
		} // 입력 끝

		while (true) {
			Fish target = bfs(n);

			if (target == null)
				break;

			sharkR = target.fishR;
			sharkC = target.fishC;
			map[sharkR][sharkC] = 0;
			time += target.dist;
			eatNow++;

			if (eatNow == sharkSize) {
				sharkSize++;
				eatNow = 0;
			}
		}

		System.out.println(time);

	}

	private static Fish bfs(int n) {
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new ArrayDeque<>();

		PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {

			@Override
			public int compare(Fish o1, Fish o2) {
				if (o1.dist != o2.dist)
					return o1.dist - o2.dist;
				else {
					if (o1.fishR != o2.fishR)
						return o1.fishR - o2.fishR;
					else
						return o1.fishC - o2.fishC;
				}
			}

		});

		q.offer(new int[] { sharkR, sharkC, 0 });
		visited[sharkR][sharkC] = true;

		int minDist = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			int r = curr[0];
			int c = curr[1];
			int dist = curr[2];

			if (dist > minDist)
				continue;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				if (visited[nr][nc] == true)
					continue;

				if (map[nr][nc] > sharkSize)
					continue;

				visited[nr][nc] = true;
				int nextDist = dist + 1;

				if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
					pq.offer(new Fish(nr, nc, nextDist));
					minDist = nextDist;
				}

				q.offer(new int[] { nr, nc, nextDist });
			}
		}

		if (pq.isEmpty())
			return null;
		return pq.poll();

	}

}
