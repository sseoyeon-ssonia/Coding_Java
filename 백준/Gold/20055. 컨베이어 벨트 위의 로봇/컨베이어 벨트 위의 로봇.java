

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int k;
	static int[] belt; // 컨베이어 벨트 내구도
	static boolean[] robot; // 현재 로봇 위치
	static int cnt; // 내구도 0인 칸 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		belt = new int[2 * n];
		robot = new boolean[n];
		cnt = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 2 * n; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
			if (belt[i] == 0)
				cnt++;
		}

		// 입력 끝

		// 메서드 실행
		// 실행 조건
		// 내구도가 0인 칸의 개수가 K개 이상이라면 종료
		// == 내구도가 0인 칸 개수가 K개보다 작다면 종료 (while문)

		int ans = 0;

		while (cnt < k) {
			ans++;

			rotation();

			// 로봇이 있다면 로봇 이동
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (robot[i]) {
					flag = true;
					break;
				}
			}
			if (flag)
				robotMove();

			if (belt[0] > 0)
				robotNew();

			cnt = search();

		}

		System.out.println(ans);

	}

	// 메서드 구현

	// 벨트 회전(로봇과 함께)
	private static void rotation() {
//		int tempup = 0; //올라가는 칸의 값 
//		int tempdown = 0; //내려가는 칸의 값
//		
//		tempdown = belt[n-1];
		int tempup = belt[2 * n - 1]; // 마지막 칸 값

		for (int i = 2 * n - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}

		belt[0] = tempup;

		// 로봇도 이동
		robot[n - 1] = false;
		for (int i = n - 2; i > 0; i--) {
			robot[i] = robot[i - 1];
		}
		robot[0] = false;
	}

	// 로봇 이동
	// 로봇 이동 조건
	// 1. 이동하려는 칸 = 현재위치+1 에 로봇이 없을 것
	// 2. 이동하려는 칸 내구도 >0
	private static void robotMove() {

		// 내리는 위치 로봇 검사
		if (robot[n - 1])
			robot[n - 1] = false;

		// n-2 로봇 n-1 이동 가능한지 확인 ()
		if (robot[n - 2]) {
			if (!robot[n - 1] && belt[n - 1] > 0) {
				robot[n - 2] = false;
				belt[n - 1]--;
			}
		}
		int idx;
		for (int i = n - 3; i >= 0; i--) {
			if (robot[i]) {
				idx = i;
				if (!robot[idx + 1] && belt[idx + 1] > 0) {// 다음 칸 이동 가능한지 검사
					robot[idx + 1] = true;
					belt[idx + 1]--;
					robot[idx] = false;
				} else
					continue;

			} else
				continue;
		}

	}

	// 올리는 위치에 로봇 올림
	// 올리는 조건
	// 올리는위치([0] 내구도 >0
	private static void robotNew() {
		robot[0] = true;
		belt[0]--;
	}

	// 내구도 0 조회
	private static int search() {
		int tempCnt = 0;
		for (int i = 0; i < 2 * n; i++) {
			if (belt[i] == 0)
				tempCnt++;
			if (tempCnt >= k)
				break;
		}
		return tempCnt;
	}

}
