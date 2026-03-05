
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
			int m = sc.nextInt();

			int[] a;
			int[] b;

			// 항상 a가 b보다 같거나 짧도록 설정
			if (n <= m) {
				a = new int[n];
				b = new int[m];

				for (int i = 0; i < n; i++) {
					a[i] = sc.nextInt();
				}
				for (int i = 0; i < m; i++) {
					b[i] = sc.nextInt();
				}
			} else {
				a = new int[m];
				b = new int[n];

				for (int i = 0; i < n; i++) {
					b[i] = sc.nextInt();
				}
				for (int i = 0; i < m; i++) {
					a[i] = sc.nextInt();
				}
			}

			// 구할 최댓값
			int maxMulti = Integer.MIN_VALUE;

			for (int i = 0; i <= b.length - a.length; i++) {
				// 해당 경우에서의 결과값
				int temp = 0;

				for (int j = 0; j < a.length; j++) {
					// 시작점 설정

					temp += a[j] * b[i + j];

				}

				maxMulti = Math.max(maxMulti, temp);
			}

			System.out.printf("#%d %d%n", t, maxMulti);

		} // 테스트케이스 끝
	}
}