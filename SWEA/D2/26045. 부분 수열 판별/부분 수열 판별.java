
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

			int[] aArr = new int[n];
			int[] bArr = new int[m];

			for (int i = 0; i < n; i++) {
				aArr[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				bArr[i] = sc.nextInt();
			}

			// 수열 세팅

			String ans = "NO";

			int b = 0;
			for (int i = 0; i < n; i++) {
				if (aArr[i] == bArr[b]) {
					b++;
				}
				if (b == m) {
					ans = "YES";
					break;
				}
			}

			System.out.printf("#%d %s%n", t, ans);

		}
	}
}