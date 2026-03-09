
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    static int[] cardGyu = new int[9]; // 규영 카드
	static int[] cardIn = new int[9]; // 인영 카드
	static int win;
	static int lose;

	static int[] permIn = new int[9]; // 인영 순열 완료된 카드
	static boolean[] visitedIn = new boolean[9];
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

            boolean[] cardCheck = new boolean[19];
            
			for (int i = 0; i < 9; i++) {
				cardGyu[i] = sc.nextInt();
				cardCheck[cardGyu[i]] = true;
			}
			for (int i = 1, idx = 0; i < 19; i++) {
				if (cardCheck[i] == false)
					cardIn[idx++] = i;
			}
			// 카드 덱 정리
			win = 0;
			lose = 0;
			game(0);

			System.out.println("#" + tc + " " + win + " " + lose);
		} // tc 끝
	}// main 끝

	static void game(int idx) {
		// 종료. 인영 모두 카드 정렬 완료했다면. 해당 경우가 이기는지 지는지 확인
		if (idx == 9) {
			// 해당 게임에서 규영, 인영 점수
			int scoreGyu = 0;
			int scoreIn = 0;
			for (int i = 0; i < 9; i++) {
				if (cardGyu[i] > permIn[i]) {
					scoreGyu += cardGyu[i] + permIn[i];
				} else {
					scoreIn += cardGyu[i] + permIn[i];
				}
			}
			if (scoreGyu > scoreIn) {
				win++;
				return;
			} else {
				lose++;
				return;
			}

		}

		// 재귀
		// 인영 카드 정렬 - 순열
		for (int i = 0; i < 9; i++) {
			if (visitedIn[i] == true)
				continue;
			permIn[idx] = cardIn[i];
			visitedIn[i] = true;

			game(idx + 1);

			visitedIn[i] = false;
		}
	}
}