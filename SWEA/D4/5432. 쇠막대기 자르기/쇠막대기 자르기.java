import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			Stack<Character> wood = new Stack<>();

			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			int nowCnt = 0;
			int totalCnt = 0;

			for (int i = 0; i < str.length(); i++) {
				char now = str.charAt(i);

				if (now == '(') {
					wood.add(now);
					nowCnt++;
				} else {
					if (wood.peek() == '(') {
						wood.add(now);
						nowCnt--;
						totalCnt += nowCnt;
					} else {
						wood.add(now);
						nowCnt--;
						totalCnt++;
					}
				}

			}

			System.out.println("#" + tc + " " + totalCnt);
		}

	}
}
