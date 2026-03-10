import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

			int n = sc.nextInt(); // 나무 개수
			int[] trees = new int[n]; // 초기 나무 높이

			for (int i = 0; i < n; i++) {
				trees[i] = sc.nextInt();
			}

			Arrays.sort(trees); // 오름차순으로 정렬

			int maxTree = trees[n - 1]; // 가장 높은 나무의 높이
			int maxCnt = 1;
			for (int i = n - 2; i >= 0; i--) {
				if (trees[i] == maxTree) {
					maxCnt++;
				} else if (trees[i] < maxTree) {
					break;
				}
			}
			int treeCnt = n - maxCnt;
			int dayCnt = 0; // 필요한 날짜 수
			int[] needWater = new int[treeCnt]; // 나무별 더 줘야하는 물 양
			int waterCnt = 0; // 물 줘야하는 나무 개수

			for (int i = 0; i < treeCnt; i++) {
				needWater[i] = maxTree - trees[i];
			} // 나무별 줘야하는 물 양

			for (int i = 0; i < treeCnt; i++) {
				if (needWater[i] != 0)
					waterCnt++;
			} // 문 줘야하는 나무 개수

			while (waterCnt > 0) { // 물 줘야하는 나무가 있다면
				dayCnt++;
				int temp = Integer.MIN_VALUE; // 이번에 물 줄 나무의 높이
				if (dayCnt % 2 == 0) { // 짝수일일 때
					for (int i = 0; i < treeCnt; i++) {
						if (needWater[i] >= 2) {
							needWater[i] -= 2;
							temp = needWater[i];
							break;
						}
					}

				} else { // 홀수일일 때

					boolean oddFlag = false; // 줘야하는 물 양이 홀수가 있는지 체크
					int oddLoc = 0; // 줘야하는 물 양이 홀수인 나무 위치
					for (int i = 0; i < treeCnt; i++) {
						if (needWater[i] % 2 == 1) {
							oddFlag = true;
							oddLoc = i;
							break;
						}
					}
					// 줘야하는 물 양이 홀수인 경우가 있다면 물 주기
					if (oddFlag == true) {
						needWater[oddLoc] -= 1;
						temp = needWater[oddLoc];
					} else {// 줘야하는 물 양이 홀수인 경우가 없다면
							// 남은 나무 수가 2개 이상 -> 물 주기
						int total = 0;
						for(int h : needWater) total+=h;
						if (total > 2) {
							for (int i = 0; i < treeCnt; i++) {
								if (needWater[i] >= 1) {
									needWater[i] -= 1;
									temp = needWater[i];
									break;
								}
							}
						}else {
							continue;
						}
					}
					// 남은 나무 수가 1개 -> 건너뛰기

				}

				if (temp == 0) {
					waterCnt--;
				}
			}

			System.out.println("#" + tc + " " + dayCnt);

		} // 테스트케이스 끝
	}
}