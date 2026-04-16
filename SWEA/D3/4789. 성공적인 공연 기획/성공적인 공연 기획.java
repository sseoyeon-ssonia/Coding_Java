import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();

			int[] need = new int[str.length()];

			int basicCnt = str.charAt(0) - '0';
			int nowPeople = basicCnt;
			int minNeed = 0;

			for (int i = 1; i < str.length(); i++) {
				need[i] = str.charAt(i) - '0';
				if(need[i]==0) continue;
				if (nowPeople < i) {
					int diff = i - nowPeople;
					minNeed+=diff;
					nowPeople += diff;
				}
				nowPeople += need[i];
			}

			System.out.println("#" + tc + " " + minNeed);

		}

	}
}
