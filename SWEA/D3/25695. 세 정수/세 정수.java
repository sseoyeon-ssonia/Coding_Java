
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {

			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();

			int a = 0;
			int b = 0;
			int c = 0;

			StringBuilder ans = new StringBuilder();
			if (x != y && y != z && x != z) {
				ans.append("-1 -1 -1");
			} else {
				int max = Math.max(z, Math.max(x, y));
				if (x == y && x == max) {

					b = max;
					a = z;
					c = z;
					ans.append(a + " " + b + " " + c);

				} else if (y == z && y == max) {

					c = max;
					a = x;
					b = x;
					ans.append(a + " " + b + " " + c);

				} else if (z == x && z == max) {

					a = max;
					b = y;
					c = y;
					ans.append(a + " " + b + " " + c);

				} else {
					ans.append("-1 -1 -1");
				}

			}

			System.out.println(ans);
        }
	}
}