

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] nums;
	static int[] sel;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		sel = new int[m];
		visited = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		numsCnt(0,0);
		
	}
	
	static void numsCnt(int idx, int sidx) {
		if(sidx==m) {
			for(int i = 0;i<m;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i= 0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				sel[sidx]=nums[i];
				numsCnt(idx+1,sidx+1);
				visited[i]=false;
			}
			
		}
	}
	
}
