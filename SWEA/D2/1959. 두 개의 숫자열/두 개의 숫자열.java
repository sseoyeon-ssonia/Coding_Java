

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=t;tc++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] a;
			int[] b;
			
			if(n<=m) {
				a= new int[n];
				b = new int[m];
				
				st = new StringTokenizer(br.readLine());
				
				for(int i= 0;i<n;i++) {
					a[i] = Integer.parseInt(st.nextToken());
				}
				
				st = new StringTokenizer(br.readLine());
				
				for(int i= 0;i<m;i++) {
					b[i] = Integer.parseInt(st.nextToken());
				}
			}else {
				b = new int[n];
				a = new int[m];
				
				st = new StringTokenizer(br.readLine());
				
				for(int i= 0;i<n;i++) {
					b[i] = Integer.parseInt(st.nextToken());
				}
				
				st = new StringTokenizer(br.readLine());
				
				for(int i= 0;i<m;i++) {
					a[i] = Integer.parseInt(st.nextToken());
				}
			}
			
			//input 끝
			
			//항상 a<b
			
			int max = Integer.MIN_VALUE;
			
			for(int i = 0;i<=b.length-a.length;i++) { //b 출발점
				int temp = 0;
				for(int j = i,k=0;j<i+a.length;j++,k++) {
					temp+=a[k]*b[j];
				}
				max=Math.max(temp, max);
			}
			
			System.out.println("#"+tc+" "+max);
			
			
		}
	}
}















