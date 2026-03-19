

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n; // n개 구역
	static List<Integer>[] graph; // 연결 정보 저장
	static boolean[] visited; // bfs용 방문 처리
	static Queue<Integer> q; // bfs 통해 연결 정보 확인
	static int[] residents; // 구역별 인구 수
	static boolean[] electionGroup; // 구역 a,b 로 나눔
	static int minDiff; // 차이 최솟값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		residents = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			residents[i] = Integer.parseInt(st.nextToken());
		} // 인구 수 정렬

		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		visited = new boolean[n];
		electionGroup = new boolean[n];
		minDiff = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int connectCnt = Integer.parseInt(st.nextToken());

			for (int j = 0; j < connectCnt; j++) {
				int connectNum = Integer.parseInt(st.nextToken()) - 1;
				graph[i].add(connectNum);
			}
		}

		// 입력 끝

		electionTeam(0);

		if (minDiff == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minDiff);

	}

	// 2개로 나눔 집합
	public static void electionTeam(int idx) {

		if (idx == n) { // 모든 도시를 방문하고 팀을 골랐다면

			// 선거구 한 쪽에 몰렸는지 확인
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (electionGroup[i] == true)
					cnt++;
			}
			if (cnt == n || cnt == 0)
				return;

			// 1. 선거구 내 도시끼리 연결 확인
			// true 그룹 연결 확인

			Arrays.fill(visited, false);
			int startTrue = -1;
			for (int i = 0; i < n; i++) {
				if (electionGroup[i]) {
					startTrue = i;
					break;
				}
			}

			isConnected(startTrue, true);
			for (int i = 0; i < n; i++) {
				if (electionGroup[i] && !visited[i])
					return;
			}

			// false 그룹 연결 확인
			Arrays.fill(visited, false);
			int startFalse = -1;
			for (int i = 0; i < n; i++) {
				if (!electionGroup[i]) {
					startFalse = i;
					break;
				}
			}

			isConnected(startFalse, false);
			for (int i = 0; i < n; i++) {
				if (!electionGroup[i] && !visited[i])
					return;
			}

			// 2. 연결되어있다면 차이 구하고 최솟값 비교

			int sumTrue = 0;
			int sumFalse = 0;
			for (int i = 0; i < n; i++) {
				if (electionGroup[i])
					sumTrue += residents[i];
				else
					sumFalse += residents[i];
			}

			minDiff = Math.min(minDiff, Math.abs(sumTrue - sumFalse));
			return;

		}

		// T/F 둘 중 하나로 나눔 조합
		electionGroup[idx] = true;
		electionTeam(idx + 1);

		electionGroup[idx] = false;
		electionTeam(idx + 1);

	}

	public static void isConnected(int a, boolean teamCheck) {
		q = new LinkedList<>();

		q.add(a);
		visited[a] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int w : graph[curr]) {
				if (!visited[w] && electionGroup[w] == electionGroup[a]) {
					q.add(w);
					visited[w] = true;
				}
			}
		}

	}

}
