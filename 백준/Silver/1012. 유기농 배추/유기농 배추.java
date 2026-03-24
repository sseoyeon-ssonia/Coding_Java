
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//상하좌우로 연결도니 그래프 개수

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] map;
	static int m, n;

//	static LinkedList<int[]> connectMap;
	static Queue<int[]> q;
//	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < t; tc++) {

			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			visited = new boolean[n][m];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
			}

			// 입력 끝

			int ansCnt = 0;
//			q = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {

					int x = i;
					int y = j;

					if (map[x][y] == 1 && visited[x][y] == false) {
						bfs(x,y);
						ansCnt++;

					}

				}
			}

			System.out.println(ansCnt);

		} // tc 끝

	}// main 끝

	static void bfs(int r, int c) {
		q= new LinkedList<>();
		q.offer(new int[] {r,c});
		visited[r][c]=true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d= 0;d<4;d++) {
				int nr = curr[0]+dr[d];
				int nc = curr[1]+dc[d];
				
				if(nr>=0 && nc>=0 && nr<n && nc<m && map[nr][nc]==1 && visited[nr][nc]==false) {
					visited[nr][nc]=true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		

	}

}