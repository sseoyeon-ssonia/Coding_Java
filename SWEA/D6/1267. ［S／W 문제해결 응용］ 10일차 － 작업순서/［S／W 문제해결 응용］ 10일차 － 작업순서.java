import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int tc = 1;tc<=10;tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
//			int[][] adjList = new int[v+1][v+1];
			List<Integer>[] adjList = new ArrayList[v+1];

			
			for(int i = 1;i<=v;i++) {
				adjList[i]=new ArrayList<>();
			}
			
			int[] inDegree = new int[v+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<e;i++) {
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				adjList[start].add(end);
				inDegree[end]++;
				
			}
			
			//입력 끝
			
			StringBuilder ans = new StringBuilder();
			
			Queue<Integer> q = new ArrayDeque<>();
			
			for(int i = 1;i<=v;i++) {
				if(inDegree[i]==0) {
					q.add(i);
				}
			}
			
			while(!q.isEmpty()) {
				int temp = q.poll();
				ans.append(" ").append(temp);
				
				for(int now : adjList[temp]) {
					
					inDegree[now]--;
					if(inDegree[now]==0) {
						q.add(now);
					}
				}
				
			}
			
			System.out.println("#"+tc+ans);
			
			
		}//tc 끝
		
	}//main 끝
}	







