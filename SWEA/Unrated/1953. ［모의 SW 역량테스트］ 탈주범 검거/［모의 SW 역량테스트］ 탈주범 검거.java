import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n,m,r,c,l, ans; //지도 세로크기 n 가로 m 맨홀 장소 세로 r 가로 c 탈출 후 시간 l 탈주범 위치 장소 개수 ans
	static int[][] map;
	static boolean[][] visited;
	
	//우하좌상
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	static int[][] tunnel = { {},
			{0,1,2,3},
			{1,3},
			{0,2},
			{0,3},
			{0,1},
			{1,2},
			{2,3}
	};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			visited = new boolean[n][m];
			for(int i = 0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<m;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			//input 끝
			
			ans = 1;
			bfs();
			
			System.out.println("#"+tc+" "+ans);
			
		}//tc 끝
		
	}//main 끝
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c,1});
		visited[r][c]=true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int tempR = temp[0];
			int tempL = temp[1];
			int tempTime = temp[2];
			
			if(tempTime==l) {
				continue;
			}
			
			int type = map[tempR][tempL];
			
			for(int dir : tunnel[type]) {
				int nr = tempR+dr[dir];
				int nc = tempL + dc[dir];
				
				if(nr<0 || nr>=n || nc<0 || nc>=m || visited[nr][nc]) continue;
				
				if(map[nr][nc]==0) continue;
				
				int nextType = map[nr][nc];
				int dir2 = (dir+2)%4;
				
				if(!canMove(nextType,dir2)) continue;
				
				visited[nr][nc] = true;
				ans++;
				q.offer(new int[] {nr,nc,tempTime+1});
			}
					
		}
		
		
	}//bfs 끝
	
	static boolean canMove(int type, int dir) {
		for(int d : tunnel[type]) {
			if(d==dir) return true;
		}
		return false;
	}
	
}
