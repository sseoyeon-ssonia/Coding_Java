
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

			int x = sc.nextInt();

			StringBuilder ans = new StringBuilder();

			if (x == 1) {
				ans.append("0");
			} else if (x % 2 == 0) { // 짝수라면
				int cnt = x / 2;
				while (cnt != 0) {
					ans.append("8");
					cnt -= 1;
				}
			} else { // 홀수일 때
				int cnt = x / 2 + 1;
				ans.append("4");
				cnt--;
				while (cnt != 0) {
					ans.append("8");
					cnt--;
				}

			}

			System.out.println(ans);
			
		}
	}
}