import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt(); // 테스트케이스 수
		for (int t = 1; t <= test; t++) {

			long n = sc.nextLong(); // 2이상의 어떤 정수 n

			long count = 0; // 조작횟수

			while (n != 2) {
				long root = (long) Math.sqrt(n);

				// 1. 현재 n이 딱 떨어지는 제곱수라면
				if (root * root == n) {
					n = root;
					count++;
				}
				// 2. 제곱수가 아니라면 다음 제곱수까지의 차이를 한 번에 더함
				else {
					long nextRoot = root + 1;
					long nextSquare = nextRoot * nextRoot;

					count += (nextSquare - n); // 다음 제곱수까지 가는데 필요한 +1 횟수
					n = nextSquare; // n을 다음 제곱수로 점프
				}
			}

			System.out.print("#"+t+" "+count);
            System.out.println();

		} // 테스트케이스 끝
	}
}