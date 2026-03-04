
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
			char[][] map = new char[n][n];

			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
				}
			} // 오목 판 초기화

			// 출력할 정답. 판정하여 5개 연속 돌이 있으면 YES로 바꿈
			String ans = "NO";

			// 가로 검색
			if (ans.equals("NO")) {

				for (int i = 0; i < n; i++) {
					for (int j = 0; j <= n - 5; j++) {
						int oCnt = 0;
						for (int k = 0; k < 5; k++) {
							if (map[i][j + k] == 'o') {
								oCnt++;
							}
						}

						if (oCnt >= 5) {
							ans = "YES";
							break;
						}

					}
					if (ans.equals("YES")) {
						break;
					}
				}
			}

			// 세로 검색
			if (ans.equals("NO")) {

				for (int j = 0; j < n; j++) {
					for (int i = 0; i <= n - 5; i++) {
						int oCnt = 0;
						for (int k = 0; k < 5; k++) {
							if (map[i + k][j] == 'o') {
								oCnt++;
							}
						}

						if (oCnt >= 5) {
							ans = "YES";
							break;
						}

					}
					if (ans.equals("YES")) {
						break;
					}
				}
			}

			// 왼상->우하 대각선
			if (ans.equals("NO")) {

				for (int i = 0; i <= n - 5; i++) {
					for (int j = 0; j <= n - 5; j++) {
						int oCnt = 0;
						for (int k = 0; k < 5; k++) {
							if (map[i + k][j + k] == 'o') {
								oCnt++;
							}
						}

						if (oCnt >= 5) {
							ans = "YES";
							break;
						}

					}
					if (ans.equals("YES")) {
						break;
					}
				}
			}

			// 우상->왼하 대각선
			if (ans.equals("NO")) {

				for (int i = 0; i <= n - 5; i++) {
					for (int j = n - 1; j >= 4; j--) {
						int oCnt = 0;
						for (int k = 0, l = 0; k < 5; k++, l--) {
							if (map[i + k][j + l] == 'o') {
								oCnt++;
							}
						}

						if (oCnt >= 5) {
							ans = "YES";
							break;
						}

					}
					if (ans.equals("YES")) {
						break;
					}
				}
			}

			System.out.printf("#%d %s%n", t, ans);

		} // 테스트케이스 끝
	}
}