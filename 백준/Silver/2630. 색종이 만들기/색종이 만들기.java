
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int whiteCnt;
	static int blueCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		whiteCnt = 0;
		blueCnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력 끝
		cut(0,0,n);
		
		System.out.println(whiteCnt);
		System.out.println(blueCnt);

	}// main 끝

	// 파고드는 재귀부
	static void cut(int x, int y, int size) {
		int sum = 0;
		for (int r = x; r < x + size; r++) {
			for (int c = y; c < y + size; c++) {
				sum += map[r][c];
			}
		}

		if (sum == 0) {
			whiteCnt++;
		} else if (sum == size * size) {
			blueCnt++;
		} else {
			int nowSize = size / 2;
			cut(x, y, nowSize);
			cut(x, y + nowSize, nowSize);
			cut(x + nowSize, y, nowSize);
			cut(x + nowSize, y + nowSize, nowSize);
		}
	}
}
