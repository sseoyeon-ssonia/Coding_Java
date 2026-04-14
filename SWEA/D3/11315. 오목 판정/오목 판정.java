import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			char[][] map = new char[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			// input 끝
			String ans = "NO";

			// 가로 판정

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 'o') {
						boolean flag = true;
						for (int k = 0; k < 5; k++) {
							if (j + k < 0 || j + k >= n) {
								flag = false;
								break;
							}
							if (map[i][j + k] == 'o')
								continue;
							else
								flag = false;
						}
						if (flag) {
							ans = "YES";
							break;
						}
					}
				}
				if (ans == "YES")
					break;
			}

			// 세로 판정
			if (ans == "NO") {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] == 'o') {
							boolean flag = true;
							for (int k = 0; k < 5; k++) {
								if (i + k < 0 || i + k >= n) {
									flag = false;
									break;
								}
								if (map[i + k][j] == 'o')
									continue;
								else
									flag = false;
							}
							if (flag) {
								ans = "YES";
								break;
							}
						}
					}
					if (ans == "YES")
						break;
				}
			}

			// 좌상->우하 대각선 판정
			if (ans == "NO") {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] == 'o') {
							boolean flag = true;
							for (int k = 0; k < 5; k++) {
								if (i + k < 0 || i + k >= n || j + k < 0 || j + k >= n) {
									flag = false;
									break;
								}
								if (map[i + k][j + k] == 'o')
									continue;
								else
									flag = false;
							}
							if (flag) {
								ans = "YES";
								break;
							}
						}
					}
					if (ans == "YES")
						break;
				}
			}

			// 우상->좌하 대각선 판정
			if (ans == "NO") {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] == 'o') {
							boolean flag = true;
							for (int k = 0; k < 5; k++) {
								if (i + k < 0 || i + k >= n || j - k < 0 || j - k >= n) {
									flag = false;
									break;
								}
								if (map[i + k][j - k] == 'o')
									continue;
								else
									flag = false;
							}
							if (flag) {
								ans = "YES";
								break;
							}
						}
					}
					if (ans == "YES")
						break;
				}
			}

			System.out.println("#" + tc + " " + ans);

		} // tc 끝

	}// main 끝
}
