
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt(); // 테스트케이스
		for (int t = 1; t <= test; t++) {

			int n = sc.nextInt(); // 거슬러줄 금액 n
			int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
			int[] ans = new int[8]; // 각 종류별로 필요 개수 담을 배열

			for (int i = 0; i < 8; i++) {
				ans[i] = n / money[i];
				n %= money[i];
			}

			System.out.println("#" + t);
			for (int i = 0; i < 8; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();

		} // 테스트케이스 끝
	}
}