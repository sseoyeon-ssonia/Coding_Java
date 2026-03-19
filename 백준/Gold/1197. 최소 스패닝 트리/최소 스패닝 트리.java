
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] parents;
	
	static void union(int a, int b) { // 서로소 집합 합치기
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return;
		parents[bRoot] = aRoot;
	}
	
	static int find(int a) { // 서로소 집합의 대표자 찾기
		if (a == parents[a]) return a;
		else return parents[a] = find(parents[a]); // 경로 압축
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		
		
		PriorityQueue<int[]> edges = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		int answer = 0;
		int connect = 0;
		
		for (int i = 0; i <= V; i++) {
			parents[i] = i; // 대표자 초기화
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edges.add(new int[] {w, u, v}); // (가중치, 시작노드, 도착노드 순으로 입력)
		}
		
		while (connect < V-1) { // 간선-1개의 간선이 연결되면 최소 스패닝 트리 완성
			int[] cur = edges.poll();
			
			// 같은 서로소 집합에 속한지 파악해서 이미 트리에 연결되어 있는 노드끼리의 간선이면 무시한다
			if (find(cur[1]) == find(cur[2])) {
				continue;
			}
			
			// 정답 가중치 증가, 이어진 간선 개수 증가, 같은 서로소 지합으로 만든다
			answer += cur[0];
			connect++;
			union(cur[1], cur[2]);
		}
		
		System.out.println(answer);
	}
}