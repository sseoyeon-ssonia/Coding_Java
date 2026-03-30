

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] dp;

	static Deque<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[100001];

		Arrays.fill(dp, -1);


		bfs();

	}// main

	static void bfs() {
		q = new ArrayDeque<>();
		q.add(n);
		dp[n] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == k) {
				System.out.println(dp[now]);
				return;
			}

			int[] next = { now * 2, now - 1, now + 1 };
			for (int x : next) {
				if (x == now * 2) {
					if (x >= 0 && x < 100001 && dp[x] == -1) {
						dp[x] = dp[now];
						q.addFirst(x);
					}
				} else {
					if (x >= 0 && x < 100001 && dp[x] == -1) {
						dp[x] = dp[now] + 1;
						q.addLast(x);
					}
				}

			}
		}

	}
}
