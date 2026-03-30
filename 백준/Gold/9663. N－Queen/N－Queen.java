

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
//	static int[][] map;
	static int ans;
	static boolean[] usedCol, usedDiag1, usedDiag2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		usedCol = new boolean[n];
		usedDiag1 = new boolean[2*n-1];
		usedDiag2 = new boolean[2*n-1];
		
		ans = 0;
		
		make(0);
		
		System.out.println(ans);
		
	}//main 끝
	
	static void make(int row) {
		if(row == n) {
			ans++;
			return;
		}
		
		for(int col = 0;col<n;col++) {
			int d1 = row + col;
			int d2 = row - col+n-1;
			
			if(usedCol[col]||usedDiag1[d1]||usedDiag2[d2]) {
				continue;
			}
			
			usedCol[col]=true;
			usedDiag1[d1]=true;
			usedDiag2[d2]=true;
			
			make(row+1);
			
			usedCol[col]=false;
			usedDiag1[d1]=false;
			usedDiag2[d2]=false;
		}
		
	}
}
