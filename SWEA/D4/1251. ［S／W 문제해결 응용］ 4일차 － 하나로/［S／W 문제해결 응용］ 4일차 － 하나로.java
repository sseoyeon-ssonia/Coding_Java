import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static double ans;
	static long[] x, y;
	static double rate;
	static boolean[] visited;

	static class Edge implements Comparable<Edge> {
		int end;
		double cost;

		public Edge(int end, double cost) {
			super();
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());

			x = new long[n]; // x좌표 배열
			y = new long[n]; // y좌표 배열
			visited = new boolean[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				x[i] = Long.parseLong(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				y[i] = Long.parseLong(st.nextToken());
			}

			// x,y 좌표 입력

			st = new StringTokenizer(br.readLine());
			rate = Double.parseDouble(st.nextToken());

			// 세율 입력

			PriorityQueue<Edge> pq = new PriorityQueue<>();

			// 입력 끝

			LinkedList<Edge>[] list = new LinkedList[n];

			for (int i = 0; i < n; i++) {
				list[i] = new LinkedList<>();
			}

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					list[i].add(new Edge(j, distance(i, j)));
					list[j].add(new Edge(i, distance(j, i)));
				}
			}

			ans = 0;

			int pick = 0;

			pq.add(new Edge(0, 0));

			while (pick < n) {
				Edge now = pq.poll();

				if (visited[now.end])
					continue;

				visited[now.end] = true;
				ans += now.cost;
				pick++;
				pq.addAll(list[now.end]);
			}

			System.out.println("#" + tc + " " + Math.round(ans));

		}

	}

	static double distance(int start, int end) {
		long dist = (long) (Math.pow(Math.abs(x[start] - x[end]), 2) + Math.pow(Math.abs(y[start] - y[end]), 2));

		return rate * dist;
	}
}
