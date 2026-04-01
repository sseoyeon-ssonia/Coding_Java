

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class  Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		
		
		for(int i = 0;i<n;i++) {
			Queue<Character> q = new LinkedList<>();
			String ans = "YES";
			
			st = new StringTokenizer(br.readLine());
			String now = st.nextToken();
			int num = 0;
			while(ans.equals("YES")&&num<now.length()) {
				char temp = now.charAt(num++);
				if(temp=='(') {
					q.add(temp);
				}else {
					if(q.isEmpty()) {
						ans = "NO";
						break;
					}else {
						q.poll();
					}
				}
			}
			
			if(ans.equals("YES")&&q.isEmpty()) {
				ans="YES";
			}else {
				ans="NO";
			}
			
			System.out.println(ans);
			
		}
		
	}
}
