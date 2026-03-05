
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {

			// 원래 값
			String originStr = sc.next();

			// 원래 값 배열에 넣기
			int[] origin = new int[originStr.length()];

			for (int i = 0; i < origin.length; i++) {
				origin[i] = originStr.charAt(i) - '0';
			}

			// 현재 메모리 값
			int[] now = new int[origin.length];

			for (int i = 0; i < now.length; i++) {
				now[i] = 0;
			} // 현재 메모리 초기화

			// 수정 횟수
			int cnt = 0;

			for (int i = 0; i < origin.length; i++) {
				if (origin[i] != now[i]) {
					for (int j = i; j < now.length; j++) {
						now[j] = 1 - now[j];
					}
					cnt++;
				}

			}

			System.out.printf("#%d %d%n", t, cnt);

		} // 테스트케이스 끝

	}
}