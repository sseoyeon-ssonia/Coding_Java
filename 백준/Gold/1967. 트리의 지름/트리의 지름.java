
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int V;
	int weight;

	public Node(int V, int weight) {
		this.V = V;
		this.weight = weight;
	}

}

public class Main {
	static int n, max;
	static List<Node>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));

		}

		// input 끝

		max = 0;

		for (int i = 1; i < n + 1; i++) {
			Arrays.fill(visited, false);
			dfs(i, 0);
		}

		System.out.println(max);

	} // main 끝

	public static void dfs(int idx, int cnt) {
		visited[idx] = true;
		max = Math.max(cnt, max);

		for (Node n : list[idx]) {
			if (!visited[n.V]) {
				visited[n.V] = true;
				dfs(n.V, cnt + n.weight);
			}
		}
	}
}
