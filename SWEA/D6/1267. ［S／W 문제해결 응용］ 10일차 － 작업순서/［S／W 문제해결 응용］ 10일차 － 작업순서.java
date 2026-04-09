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
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<Integer>[] adjList = new ArrayList[V+1];
			int[] inDegree = new int[V+1];
			
			for(int i = 1;i<V+1;i++) {
				adjList[i]= new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<E;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from].add(to);
				inDegree[to]++;
			}//입력 끝
			
			Queue<Integer> q = new ArrayDeque<>();
			
			for(int i = 1;i<V+1;i++) {
				if(inDegree[i]==0) q.add(i);
			}
			
			StringBuilder ans = new StringBuilder();
			while(!q.isEmpty()) {
				int temp = q.poll();
				ans.append(temp+" ");
				for(int now : adjList[temp]) {
					inDegree[now]--;
					if(inDegree[now]==0) q.add(now);
					
				}
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
}
