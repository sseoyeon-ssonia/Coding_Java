

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//여러 번 방문 가능 = 같은 그래프에 속해있으면 연결 가능

public class Main {
	static int[] parent;
//	static int[] origin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
//		origin = new int[n];
		parent = new int[n];
		for (int i = 0; i < n; i++) {
//			origin[i]=i;
			parent[i] = i;
		}

		int m = Integer.parseInt(br.readLine()); // 도시 수

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				int info = Integer.parseInt(st.nextToken());

				if (info == 1) {
					union2(i, j);
				}
			}

		}

		st = new StringTokenizer(br.readLine());
		int[] plan = new int[m];
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			plan[i] = num - 1;
		}

		String ans = "YES";

		for (int i = 1; i < m; i++) {
			if (parent[plan[i]] != parent[plan[i - 1]]) {
				ans = "NO";
				break;
			}
		}

		System.out.println(ans);

	}

	static int find(int x) {

		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	
	//처음 union -> 
	/*
7
5
0 1 0 0 1 1 0
1 0 1 0 0 0 0
0 1 0 0 1 1 0
0 0 0 0 1 0 1
1 0 1 1 0 1 0
1 0 1 0 1 0 1
0 0 0 1 0 1 0
2 3 4 1 4

와 같을 때 (3,4)가 이어진다면, 부모 세팅이 제대로 되지 않음
	 */
//	static void union(int x, int y) {
//		int rootX = find(x);
//		int rootY = find(y);
//
//		if (rootX != rootY) {
//			parent[rootY] = rootX;
//		}
//
//	}

	static void union2(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		
		if (rootX != rootY) {
			if(rootX>rootY) {
				int temp = rootY;
				rootY=rootX;
				rootX=temp;
			}
			parent[rootY] = rootX;
		}

	}

	public boolean isConnected(int x, int y) {
		return find(x) == find(y);
	}

}
