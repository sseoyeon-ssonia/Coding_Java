

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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken()); //가로 크기 = c 개수
		int n = Integer.parseInt(st.nextToken()); //세로 크기 = r 개수
		
		int day=-1;
		
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		Queue<int[]> tempQ = new LinkedList<>();
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(map[i][j]==1){
					tempQ.add(new int[]{i,j});
					visited[i][j]=true;
				}
			}
		}
		
		
		while(!tempQ.isEmpty()) {
			
			Queue<int[]> q = new LinkedList<>();
			int tempSize = tempQ.size();
			for(int i = 0;i<tempSize;i++) {
				q.add(tempQ.poll());
			}
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				visited[x][y]=true;
				
				for(int d = 0;d<4;d++) {
					int nr = x+ dr[d];
					int nc = y + dc[d];
					
					
					//현재 문제 : 같은 좌표가 큐에 자꾸 들어감
					
					if(nr>=0 && nc>=0 && nr<n && nc<m && visited[nr][nc]==false && map[nr][nc]!=-1) {
						visited[nr][nc]=true;
						map[nr][nc]++;
						tempQ.add(new int[] {nr,nc});	
					}
				}
			}
			
			day++;
			
		}
		
		//모두 익지 못하는 상황 : -1 출력
		boolean flag = true;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(map[i][j]==0) {
					flag=false;
					day=-1;
					break;
				}
			}
			if(flag==false) {
				day=-1;
				break;
			} 
		}

		
		
		System.out.println(day);
		
		
	}//main 끝
	
	
	
	
}


