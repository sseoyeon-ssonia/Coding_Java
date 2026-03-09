
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    static int n;
	static int[] col;
	static int cnt;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

			n = sc.nextInt();
			col = new int[n];
			cnt = 0;
			cal(0);

			System.out.println("#" + tc + " " + cnt);

		} // tc 끝

	}// main 끝

	static void cal(int row) {
		// 종료
		if (row == n) {
			cnt++;
			return;
		}

		// 재귀
		for (int c = 0; c < n; c++) {
			col[row] = c;

			if (isPossible(row)) {
				cal(row + 1);
			}
		}
	}

	static boolean isPossible(int row) {
		for (int i = 0; i < row; i++) {
			// 같은 열이면 불가능
			if (col[i] == col[row]) {
				return false;
			}
			// 대각선에 있으면 불가능
			if (Math.abs(row - i) == Math.abs(col[row] - col[i])) {
				return false;
			}

		}
		return true;
	}
}