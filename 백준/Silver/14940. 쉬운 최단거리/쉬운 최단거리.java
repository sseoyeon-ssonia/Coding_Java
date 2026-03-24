

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> tempQ = new LinkedList<>();
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					tempQ.add(new int[] {i,j});
					map[i][j]=0;
					visited[i][j]=true;
				}
			}
		}
		
		//입력 끝
		int cnt = 0;
		
		while(!tempQ.isEmpty()) {
			cnt++;
			
			int tempSize = tempQ.size();
			for(int i = 0;i<tempSize;i++) {
				q.add(tempQ.poll());
			}
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				
				for(int d = 0; d<4;d++) {
					int dx = x+dr[d];
					int dy = y + dc[d];
					
					if(dx>=0 && dy>=0 && dx<n && dy < m && !visited[dx][dy]) {
						if(map[dx][dy]!=0) {
							map[dx][dy]=cnt;
							visited[dx][dy]=true;
							tempQ.add(new int[] {dx,dy});
						}else {
							visited[dx][dy]=true;
						}
					}
					
				}
			}
			
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(!visited[i][j]&&map[i][j]==1) {
					map[i][j]=-1;
				}
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}//main 끝
	
	
}
