import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, min, max;
	static int[] nums; // 숫자
	static int[] opers = new int[4]; // + - * / 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			nums = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				opers[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			// 입력 끝
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			calc(1, nums[0]);

			int ans = max - min;

			System.out.println("#" + tc + " " + ans);

		} // tc 끝

	}// main 끝

	private static void calc(int cnt, int nowResult) {

		if (cnt == n) {
			max = Math.max(max, nowResult);
			min = Math.min(min, nowResult);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (opers[i] > 0) {
				opers[i]--;

				switch (i) {
				case 0:
					calc(cnt + 1, nowResult + nums[cnt]);
					break;
				case 1:
					calc(cnt + 1, nowResult - nums[cnt]);
					break;
				case 2:
					calc(cnt + 1, nowResult * nums[cnt]);
					break;
				case 3:
					calc(cnt + 1, nowResult / nums[cnt]);
					break;
				}

				opers[i]++;
			}
		}

	}

}
