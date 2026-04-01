

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] A, B;
	static StringBuilder ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		A = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		B = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<m;i++) {
			B[i]=Integer.parseInt(st.nextToken());
		}
		
		
		
		ans = new StringBuilder();
		
		for(int i = 0;i<m;i++) {
			if(cal(i,0,n-1)) {
				ans.append("1\n");
			}else {
				ans.append("0\n");
			}
		}
		
		System.out.println(ans);
		
		
	}
	
	static boolean cal(int idx, int left, int right) {
		
		if(left>right) {
			
			return false;
		}
		
		int mid = (left+right)/2;
		
		if(A[mid]==B[idx]) {
			
			return true;
		}else if(A[mid]>B[idx]) {
			return cal(idx,left,mid-1);
		}else {
			return cal(idx,mid+1,right);
		}
		
	}
}
