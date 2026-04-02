

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		

		Deque<Integer> dq = new LinkedList<>();
		
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			
			switch (order) {
			case "push": {
				dq.add(Integer.parseInt(st.nextToken()));
				break;
			}
			case "pop": {
				if(dq.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(dq.poll());
				}
				break;
			}
			case "size" : {
				System.out.println(dq.size());
				break;
			}
			case "empty" : {
				if(dq.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
				break;
			}
			case "front":{
				if(dq.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(dq.peek());
				}
				break;
			}
			case "back":{
				if(dq.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(dq.peekLast());
				}
				break;
			}
			}
			
			
		}
		
	}
}
