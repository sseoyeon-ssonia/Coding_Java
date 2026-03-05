
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for (int test = 0; test < 10; test++) {
			int t = sc.nextInt();

			int n = sc.nextInt();
			int m = sc.nextInt();

			int result = square(n, m);

			System.out.printf("#%d %d%n", t, result);

		}
	}

	public static int square(int n, int m) {

		// 기저조건
		if (m == 1)
			return n;

		// 재귀조건
		return n * square(n, --m);

	}
	
}