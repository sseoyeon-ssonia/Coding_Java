

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] graph = new LinkedList[n+1];
		for(int i = 1;i<n+1;i++) {
			graph[i]= new LinkedList<>();
		}
		
		int[] parent = new int[n+1];
		
		for(int i = 0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph[start].add(end);
			graph[end].add(start);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		parent[1]=0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int connect : graph[now]) {
				
				if(parent[connect]==0) {
					parent[connect]=now;
					q.add(connect);
				}
			}
		}
		
		for(int i = 2;i<=n;i++) {
			System.out.println(parent[i]);
		}
		
	}
}
