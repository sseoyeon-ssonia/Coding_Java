
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		// 10개의 테스트 케이스
		for (int t = 1; t <= 10; t++) {

			// 한 변의 길이 . 항상 100임
			int l = sc.nextInt();

			// 정사각형 테이블 map 선언
			int[][] map = new int[100][100];

			// map 초기화
			// 이 때 1로 들어오는 것 : N극 성질. S극이 끌려서 밑으로 내려가
			// 2 : S극 성질. N에 끌려서 위로 올라가
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 교착상태 count
			int cnt = 0;
			// 줄별로 확인할거야. [i][j]에서 j는 고정. 큰 사이클
			for (int j = 0; j < 100; j++) {
				// flag 통해 값 확인
				int flag = 0;
				for (int i = 0; i < 100; i++) {

					// 1이 먼저 나왔으면 플래그 1로 업데이트
					// 이후에 2가 나왔을 때 플래스가 세워져있다면 나 위에 1이 있다는 뜻이니까 교착이야
					if (map[i][j] == 1) {
						flag = 1;
					} else if (map[i][j] == 2) {
						if (flag == 1) {
							cnt++;
							flag = 0;
						}
					}
				}
			}

			System.out.print("#" + t + " " + cnt);
			System.out.println();
		}
	}
}