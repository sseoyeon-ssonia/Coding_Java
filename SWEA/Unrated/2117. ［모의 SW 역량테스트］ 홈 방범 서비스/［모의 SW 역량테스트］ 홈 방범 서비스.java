
//운영 비용 = K*K+(K-1)*(K-1)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] map = new int[n][n];
			List<int[]> house = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						house.add(new int[] { i, j });
				}
			}

			// 입력 끝

			int maxCnt = Integer.MIN_VALUE;

			for (int k = 1; k < n + n; k++) { // 중심점으로부터 거리

				int cost = k * k + (k - 1) * (k - 1); // 영역에 대한 운영비용

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) { // i,j : 중심점

						int houseCnt = 0;// 해당 점으로부터 영역 내에 있는 집 수
						
						for (int h = 0; h < house.size(); h++) {
							int[] loc = house.get(h);
							int locR = loc[0];
							int locC = loc[1];

							// 거리 계산
							int dist = Math.abs(locR - i) + Math.abs(locC - j);
							if (dist < k)
								houseCnt++;

						}

						if (houseCnt * m >= cost)
							maxCnt = Math.max(maxCnt, houseCnt);

					}
				}
			}

			System.out.println("#" + tc + " " + maxCnt);

		} // tc 끝

	}// main 끝
}
