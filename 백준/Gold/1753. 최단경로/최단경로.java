
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int end, weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

public class Main {
	static int INF = Integer.MAX_VALUE;
	static List<Node>[] adj;
	static int[] dist;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());

		adj = new ArrayList[V + 1];
		dist = new int[V + 1];

		for (int i = 1; i < V + 1; i++) {
			adj[i] = new ArrayList<>();
			dist[i] = INF;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[u].add(new Node(v, w));

		}

		// input 끝
		
		dijkstra(start);
		
		StringBuilder ans = new StringBuilder();
		for(int i = 1;i<V+1;i++) {
			if(dist[i]==INF) {
				ans.append("INF\n");
			}else {
				ans.append(dist[i]).append("\n");
			}
		}
		
		System.out.println(ans);
	}// main 끝

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int cur = now.end;
			int weight = now.weight;

			if (dist[cur] < weight)
				continue;

			for (Node next : adj[cur]) {
				if (dist[next.end] > dist[cur] + next.weight) {
					dist[next.end] = dist[cur] + next.weight;
					pq.add(new Node(next.end, dist[next.end]));
				}
			}

		}
	}

}
