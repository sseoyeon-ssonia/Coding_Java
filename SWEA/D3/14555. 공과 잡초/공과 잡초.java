
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {

			String str = sc.next();

			char[] groundMap = new char[str.length()];

			for (int i = 0; i < str.length(); i++) {
				groundMap[i] = str.charAt(i);
			} // 배열에 하나씩 담음

			// 공의 개수 최솟값. 구해야 하는 값
			int minCount = 0;

			for (int i = 0; i < groundMap.length; i++) {
				if (groundMap[i] == '(') {
					minCount++;
				} else if (groundMap[i] == ')') {
					if (groundMap[i - 1] != '(') {
						minCount++;
					}
				}
			} // for문. 공 개수 조회

			System.out.printf("#%d %d%n", t, minCount);

		} // 테스트케이스 끝

	}
}