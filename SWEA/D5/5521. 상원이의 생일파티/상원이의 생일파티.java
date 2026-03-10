import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {

			int n = sc.nextInt(); // 학생 수 . 정점 수
			int m = sc.nextInt(); // 친한관계 수 . 간선 수

			List<Integer>[] friendList = new ArrayList[n + 1];

			for (int i = 0; i < n + 1; i++) {
				friendList[i] = new ArrayList<>();
			}

			// 친한관계 받음
			for (int i = 1; i < m + 1; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				friendList[a].add(b);
				friendList[b].add(a);
			}

			boolean[] invitation = new boolean[n + 1]; // 초대할 리스트

			for (int i = 0; i < friendList[1].size(); i++) {
				int temp = friendList[1].get(i);
				invitation[temp] = true;
				for (int j = 0; j < friendList[temp].size(); j++) {
					int temp2 = friendList[temp].get(j);
					invitation[temp2] = true;
				}
			}

			int invitationCnt = 0;
			for (int i = 2; i < n + 1; i++) {
				if (invitation[i] == true)
					invitationCnt++;
			}

			System.out.println("#" + t + " " + invitationCnt);

		} // 테스트케이스 수
	}
}