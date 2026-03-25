

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,r,c,ans=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, n);
		
//		int[][] map = new int[size][size];
//		
		cut(0,0,size);
		
	}
	
	static void cut(int row, int col, int size) {
		if(size==1) {
			System.out.println(ans);
			return;
		}
		
		int newSize = size/2;
		if(r<row+newSize && c<col+newSize) {
			cut(row,col,newSize);
		}
		if(r<row+newSize && c>=col+newSize) {
			ans+=(size*size)/4;
			cut(row,col+newSize,newSize);
		}
		if(r>=row+newSize&&c<col+newSize) {
			ans+=((size*size)/4)*2;
			cut(row+newSize,col,newSize);
		}
		if(r>=row+newSize&&c>=col+newSize) {
			ans+=((size*size)/4)*3;
			cut(row+newSize, col+newSize,newSize);
		}
	}
}
