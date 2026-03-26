

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int r, c, t;
	static int[][] map;
	static int cleanerTop = -1, cleanerBottom = -1;
	
	static int[] dr= {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map = new int[r][c];
		for(int i = 0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<c;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					if(cleanerTop ==-1)cleanerTop = i;
					else cleanerBottom = i;
				}
			}
		}
		
		for(int T = 0;T<t;T++) {
			spread();
			cleaner();
		}
		
		int ans = 0;
		for(int i = 0;i<r;i++) {
			for(int j = 0;j<c;j++) {
				if(map[i][j]>0) ans+=map[i][j];
			}
		}
		
		System.out.println(ans);
	}
	
	
	//미세먼지 확산
	static void spread() {
		int[][] tempMap = new int[r][c];
		
		for(int R=0;R<r;R++) {
			for(int C=0;C<c;C++) {
				if(map[R][C]>0) {
					int amount = map[R][C]/5;
					int cnt = 0;
					
					for(int i = 0; i<4;i++) {
						int nr = R+dr[i];
						int nc = C+dc[i];
						
						if(nr>=0 && nr <r && nc >=0 && nc <c && map[nr][nc]!=-1) {
							tempMap[nr][nc]+=amount;
							cnt++;
						}
					}
					
					tempMap[R][C]+=(map[R][C]-(amount*cnt));
				}else if (map[R][C]==-1) {
					tempMap[R][C]=-1;
				}
			}
		}
		map=tempMap;
	}
	
	
	
	//공기청정기 가동
	static void cleaner() {
		for(int i = cleanerTop-1;i>0;i--) map[i][0]=map[i-1][0];
		for(int i = 0;i<c-1;i++) map[0][i]=map[0][i+1];
		for(int i = 0;i<cleanerTop;i++) map[i][c-1]=map[i+1][c-1];
		for(int i = c-1;i>1;i--) map[cleanerTop][i]=map[cleanerTop][i-1];
		map[cleanerTop][1]=0;
		
		for (int i = cleanerBottom + 1; i < r - 1; i++) map[i][0] = map[i + 1][0];
        // 왼쪽으로 당기기 (밑변)
        for (int i = 0; i < c - 1; i++) map[r - 1][i] = map[r - 1][i + 1];
        // 아래로 당기기 (오른쪽 변)
        for (int i = r - 1; i > cleanerBottom; i--) map[i][c - 1] = map[i - 1][c - 1];
        // 오른쪽으로 당기기 (윗변 - 공기청정기 라인)
        for (int i = c - 1; i > 1; i--) map[cleanerBottom][i] = map[cleanerBottom][i - 1];
        map[cleanerBottom][1] = 0;
	}
	
	
	
}
