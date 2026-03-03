
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    static int n;// 고객 수 n
	static int[] customerR;// 고객 R 위치 담는 customerR
	static int[] customerC; // 고객 C위치 담는 customerC
	static boolean[] visited; // 방문 기록 담기
	static int[] locationR; // 순열 R 저장
	static int[] locationC; // 순열 C 저장
	static int minRoute; // 최단경로. 구해야하는 값
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			n = sc.nextInt();

			customerR = new int[n + 2];
			customerC = new int[n + 2];
			visited = new boolean[n + 2];
			locationR = new int[n + 2];
			locationC = new int[n + 2];

			for (int i = 0; i < n + 2; i++) {
				customerR[i] = sc.nextInt();
				customerC[i] = sc.nextInt();
			} // 위치 초기화 완

			locationR[0] = customerR[0];
			locationC[0] = customerC[0];
			locationR[n + 1] = customerR[1];
			locationC[n + 1] = customerC[1];
			visited[0] = true;
			visited[1] = true;

			minRoute = Integer.MAX_VALUE;
			perm(1);

			System.out.printf("#%d %d%n", t, minRoute);

		} // tc 끝
	}// main 끝

	public static void perm(int idx) {
		// 종료 조건
		if (idx == n + 1) {

			// 거리 구하기
			int nowRoute = 0;
			int nowR = 0;
			int nowC = 0;
			for (int i = 0; i < n + 1; i++) {
				nowR += Math.abs(locationR[i] - locationR[i + 1]);
				nowC += Math.abs(locationC[i] - locationC[i + 1]);
			}

			nowRoute = nowR + nowC;

			minRoute = Math.min(nowRoute, minRoute);

		}

		// 재귀
		for (int i = 2; i < n + 2; i++) {
			if (visited[i])
				continue;

			locationR[idx] = customerR[i];
			locationC[idx] = customerC[i];
			visited[i] = true;

			perm(idx + 1);

			visited[i] = false;

		}

	}
}
