

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static List<Integer>[] graph;
	static int u;
	static int v;
	static int ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			graph[u - 1].add(v - 1);
			graph[v - 1].add(u - 1);
		}
		// 입력 끝

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			
			if(visited[i]==false) {
				ans++;
				q.add(i);
				visited[i] = true;

				while (!q.isEmpty()) {
					int curr = q.poll();
					for (int v : graph[curr]) {
						if (!visited[v]) {
							q.add(v);
							visited[v] = true;
						}
					}
				}
			}
			
		}

		System.out.println(ans);

	}

}
