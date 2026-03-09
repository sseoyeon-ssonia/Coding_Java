
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    static int dayPrice; // 1일 이용권
	static int monthPrice; // 1달 이용권. 매달 1일부터 시작
	static int threePrice; // 3달 이용권. 매달 1일부터 시작
	static int yearPrice; // 1년 이용권. 1월 1일부터 시작
	static int[] plan = new int[12]; // 1년 계획
	static int minPrice;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {

			dayPrice = sc.nextInt();
			monthPrice = sc.nextInt();
			threePrice = sc.nextInt();
			yearPrice = sc.nextInt();

			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}

			// 인풋 받음

			minPrice = yearPrice;
			priceCal(0, 0);

			System.out.println("#" + tc + " " + minPrice);

		} // tc 끝
	} // main 끝

	static void priceCal(int month, int nowPrice) {

		// 가지치기
		if (nowPrice >= minPrice || month > 12) {
			return;
		}

		// 종료조건
		if (month == 12) {
			minPrice = Math.min(nowPrice, minPrice);
			return;
		}

		// 재귀

		// 1일 이용권
		priceCal(month + 1, nowPrice + dayPrice * plan[month]);

		// 1달 이용권
		priceCal(month + 1, nowPrice + monthPrice);

		// 3달 이용권
		priceCal(month + 3, nowPrice + threePrice);

	}
}