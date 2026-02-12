
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		// 테스트케이스
		int test = sc.nextInt();

		for (int t = 1; t <= test; t++) {

			// 버스 노선 개수
			int n = sc.nextInt();

			// 버스 정류장 배열
			int[] bus = new int[5001];

			// n번만큼 돌면서 각각 bus에 추가할 것
			// ex. 1 3 이라면 bus 배열 1 부터 3까지 하나씩 추가하면 됨
			for (int i = 1; i <= n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				for (int j = a; j <= b; j++) {
					bus[j]++;
				}

			}

			// p 받아. 몇 개 조회할지 정하는 p야
			int p = sc.nextInt();

			StringBuilder result = new StringBuilder();

			for (int i = 1; i <= p; i++) {
				int c = sc.nextInt();
				result.append(bus[c] + " ");
			}

			System.out.print("#" + t + " " + result);
			System.out.println();

		}
	}
}