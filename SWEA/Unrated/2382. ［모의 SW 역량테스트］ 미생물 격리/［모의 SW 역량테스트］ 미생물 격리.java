import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= T; test++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			Map<Integer, int[]> micro = new HashMap<>(); // int[] : 미생물 위치 r,c, 미생물 수, 이동방향

			for (int i = 1; i <= k; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;

				micro.put(i, new int[] { r, c, cnt, dir });
			}

			// 입력 끝

			while (m-- > 0) {

				// 한 시간 이동 후, 같은 칸 기준으로 합치기 위한 map
				// key : "r,c"
				// value : {r, c, totalCnt, dir, maxCnt}
				// totalCnt = 현재 칸 총 미생물 수
				// dir = 최종 방향(가장 큰 군집의 방향)
				// maxCnt = 이 칸에 온 군집들 중 가장 큰 군집 수
				Map<String, int[]> merged = new HashMap<>();

				for (int[] now : micro.values()) {
					int r = now[0];
					int c = now[1];
					int cnt = now[2];
					int dir = now[3];

					// 1칸 이동
					int nr = r + dr[dir];
					int nc = c + dc[dir];

					// 약품 칸 도착
					if (nr == 0 || nr == n - 1 || nc == 0 || nc == n - 1) {
						cnt /= 2;

						// 0이면 소멸
						if (cnt == 0)
							continue;

						// 방향 반전
						switch (dir) {
						case 0:
							dir = 1;
							break;
						case 1:
							dir = 0;
							break;
						case 2:
							dir = 3;
							break;
						case 3:
							dir = 2;
							break;
						}
					}

					String key = nr + "," + nc;

					if (!merged.containsKey(key)) {
						merged.put(key, new int[] { nr, nc, cnt, dir, cnt });
					} else {
						int[] temp = merged.get(key);

						// 총 미생물 수 누적
						temp[2] += cnt;

						// 더 큰 군집이 들어오면 그 군집의 방향을 최종 방향으로
						if (cnt > temp[4]) {
							temp[4] = cnt;
							temp[3] = dir;
						}
					}
				}

				// 다음 시간 상태로 micro 재구성
				micro = new HashMap<>();
				int id = 1;
				for (int[] cell : merged.values()) {
					micro.put(id++, new int[] { cell[0], cell[1], cell[2], cell[3] });
				}
			}

			int ans = 0;
			for (int[] now : micro.values()) {
				ans += now[2];
			}

			System.out.println("#" + test + " " + ans);
		}
	}
}

//1시간동안 (이걸 m번 반복)
//1. 모든 군집 다음 셀로 이동
//2-1. 이동한 셀이 약품에 도달했다면 
//		미생물 수 절반으로 줄어듦 : 0 이하로 떨어지는 순간 사라짐
//		이동 방향 반대로 0->1 1->0 2->3 3->2
//2-2.같은 칸에 다른 군집이 있다면
//		군집이 합쳐짐
