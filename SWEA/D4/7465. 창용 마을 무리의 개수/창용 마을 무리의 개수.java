

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n,m;
	static LinkedList<Integer>[] graph;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			graph = new LinkedList[n+1];
			
			visited = new boolean[n+1];
			
			for(int i = 1;i<=n;i++) {
				graph[i]=new LinkedList<>();
			}
			
			for(int i = 0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				graph[start].add(end);
				graph[end].add(start);
			}
			
			ans = 0;

			Queue<Integer> q = new LinkedList<>();

			
			for(int i = 1;i<=n;i++) {
				if(visited[i]==false) {
					q.add(i);
					visited[i]=true;
				}else {
					continue;
				}
				
				while(!q.isEmpty()) {
					int temp = q.poll();
					
					for(int j = 0;j<graph[temp].size();j++) {
						int now = graph[temp].get(j);
						if(visited[now]==false) {
							q.add(now);
							visited[now]=true;
						}else {
							continue;
						}
					}
				}
				ans++;
					
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}//tc 끝
		
	}//main 끝
	
	
}







