

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int S = 0;

		String order;
		Integer num;

		StringBuilder ans = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			order = st.nextToken();
			

			switch (order) {
			case "add":
				num=Integer.parseInt(st.nextToken());
				S|=(1<<(num-1));
				break;

			case "remove":
				num=Integer.parseInt(st.nextToken());
				S&=~(1<<(num-1));
				break;

			case "check":
				num=Integer.parseInt(st.nextToken());
				ans.append((S&(1<<(num-1)))!=0 ? 1 : 0).append("\n");
				break;
				
			case "toggle":
				num=Integer.parseInt(st.nextToken());
				S ^= (1<<(num-1));
				break;

			case "all":
				S=(1<<20)-1;
				break;

			case "empty":
				S=0;
				break;

			}

		}
		
		System.out.print(ans);

	}
}
