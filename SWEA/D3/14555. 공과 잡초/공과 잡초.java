

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			Stack<Character> stack = new Stack<>();
			int ans = 0;
			
			for(int i = 0;i<str.length();i++) {
				char now = str.charAt(i);
				
				if(now=='.') continue;
				else if(now == '(') {
					stack.add(now);
				}else if(now == '|') {
					if(!stack.isEmpty()) {
						if(stack.peek()=='(') {
							ans++;
							stack.pop();
						}else {
							stack.add(now);
						}
					}
					else {
						stack.add(now);
					}
				}else {
					if(!stack.isEmpty()) {
						ans++;
						stack.pop();
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}//tc 끝
				
	}
}
