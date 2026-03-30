
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int houseCnt = Integer.parseInt(st.nextToken());
		int minCost = Integer.MAX_VALUE;

		int[][] RGBCost = new int[houseCnt + 1][3];

		for (int i = 1; i < houseCnt + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				RGBCost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// input 끝

		int[][] dp = new int[houseCnt + 1][3];

		dp[1][0] = RGBCost[1][0];
		dp[1][1] = RGBCost[1][1];
		dp[1][2] = RGBCost[1][2];

		for (int i = 2; i < houseCnt + 1; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + RGBCost[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + RGBCost[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + RGBCost[i][2];
		}

		minCost = Math.min(dp[houseCnt][0], Math.min(dp[houseCnt][1], dp[houseCnt][2]));

		System.out.println(minCost);

	}
}
