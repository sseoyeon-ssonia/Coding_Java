
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {

			int n = sc.nextInt();
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			} // map 초기화

			int maxScore = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tempScore = 0;
					// 세로
					for (int k = 0; k < n; k++) {
						tempScore += map[i][k];
						tempScore += map[k][j];
					} // 점수 계산
					tempScore -= map[i][j];

					maxScore = Math.max(maxScore, tempScore);

				}
			}

			System.out.printf("#%d %d%n", t, maxScore);

		} // 테스트케이스
	}
}