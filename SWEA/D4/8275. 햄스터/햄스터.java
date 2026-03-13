import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n; // 우리 수
	static int x; // 각 우리에 있을 수 있는 최대 햄스터 수
	static int m; // 기록 수

	// 기록 관련 변수
	static int l; // 카운트 시작 우리 번호
	static int r; // 카운트 끝 우리 번호
	static int s; // 카운트한 햄스터 수
	static int[][] cntDocu; // 기록한 결과

	static int maxHamster; // 가장 많은 햄스터 수
	static int[] hamsterTemp; // 케이스별 임시 저장 배열
	static StringBuilder ans; // 출력할 답안

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			hamsterTemp = new int[n];
			cntDocu = new int[m][3]; // 카운트 시작 인덱스, 카운트 끝 인덱스, 총 햄스터 수
			maxHamster = Integer.MIN_VALUE;

			ans = new StringBuilder();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				cntDocu[i][0] = Integer.parseInt(st.nextToken());
				cntDocu[i][1] = Integer.parseInt(st.nextToken());
				cntDocu[i][2] = Integer.parseInt(st.nextToken());
			}

			// 입력 끝
			hamsterCase(0);

			if (ans.length() == 0) {
				ans.append("-1");
			}

			System.out.println("#" + tc + " " + ans);

		} // tc 끝

	}// main 끝

	static void hamsterCase(int N) {

		// 종료조건
		if (N == n) {
			hamsterCal(N);
			return;
		}

		// 재귀조건
		for (int i = 0; i <= x; i++) {
			hamsterTemp[N] = i;
			hamsterCase(N + 1);
		}

	}

	static void hamsterCal(int a) {
		// 조건 탐색
		int nowHamster = 0; // 현재 조합의 햄스터 수
		for (int i = 0; i < n; i++) {
			nowHamster += hamsterTemp[i];
		}

		if (nowHamster > maxHamster) { // 기록 조건 검색
			boolean flag = false;

			for (int i = 0; i < m; i++) {
				int tempL = cntDocu[i][0];
				int tempR = cntDocu[i][1];
				int tempS = cntDocu[i][2];

				int tempCnt = 0;

				for (int j = tempL - 1; j <= tempR - 1; j++) {
					tempCnt += hamsterTemp[j];
				}
				if (tempCnt == tempS) {
					flag = true;
				} else {
					flag = false;
					break;
				}

			}
			if (flag) {
				maxHamster = nowHamster;
				ans.delete(0, ans.length());
				for (int i = 0; i < n; i++) {
					ans.append(hamsterTemp[i] + " ");
				}
			}

		}
		return;
	}

}
