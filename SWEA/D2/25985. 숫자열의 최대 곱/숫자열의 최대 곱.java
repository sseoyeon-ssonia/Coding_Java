
import java.util.Scanner;


class Solution
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {

			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] A;
			int[] B;

			if (n <= m) {
				A = new int[n];
				B = new int[m + n + n - 2];

				for (int i = 0; i < n; i++) {
					A[i] = sc.nextInt();
				}
				for (int i = n - 1; i < m + n - 1; i++) {
					B[i] = sc.nextInt();
				}
			} else {
				B = new int[n + m + m - 2];
				A = new int[m];

				for (int i = m - 1; i < m + n - 1; i++) {
					B[i] = sc.nextInt();
				}
				for (int i = 0; i < m; i++) {
					A[i] = sc.nextInt();
				}
			} // 항상 A가 B보다 짧도록 설정

			// 숫자들의 곱이 합이 최대일 때의 값. 구해야하는 값
			int maxSum = Integer.MIN_VALUE;

			for (int i = 0; i < B.length - A.length + 1; i++) {
				int tempSum = 0;
				for (int j = 0; j < A.length; j++) {
					tempSum += A[j] * B[i + j];
				}
				if(maxSum<tempSum) {
					maxSum=tempSum;
				}
			}

			System.out.printf("#%d %d%n", t, maxSum);

		} // 테스트케이스 끝

	}
}