

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k, ans;
	static boolean[] visited;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		// 이동해야하는 거리

		ans = 0;
		visited = new boolean[100001];


		bfs(n);


	}

	static void bfs(int nowN) {
		Queue<Integer> q = new LinkedList<>();
		q.add(nowN);
		visited[nowN] = true;
		int time = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int now = q.poll();
				if (now == k) {
					System.out.println(time);
					return;
				}

				int[] next = { now - 1, now + 1, now * 2 };
				for (int nextN : next) {
					if (nextN >= 0 && nextN <= 100000 && !visited[nextN]) {
						visited[nextN] = true;
						q.add(nextN);
					}
				}
			}
			time++;
		}
	}

}
