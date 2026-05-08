import java.util.HashSet;
import java.util.Set;

class Solution {
	static boolean[] visited;
	static int answer;
	static Set<Set<Integer>> lists; // 후보 인덱스 담아두는 set

	public int solution(String[] user_id, String[] banned_id) {
		answer = 0;

		int bannedLen = banned_id.length;

		visited = new boolean[user_id.length];

		lists = new HashSet<>();

		dfs(user_id, banned_id, 0);

		answer = lists.size();

		return answer;
	}

	private static void dfs(String[] user_id, String[] banned_id, int idx) {
		if (idx == banned_id.length) {
			Set<Integer> temp = new HashSet<>();
			for (int i = 0; i < user_id.length; i++) {
				if (visited[i])
					temp.add(i);
			}
			lists.add(temp);
			return;
		}

		String nowBanned_id = banned_id[idx];

		for (int i = 0; i < user_id.length; i++) { // 하나씩 돌아가면서 조회
			if (visited[i])
				continue; // 이미 방문했으면 아님
			String temp_id = user_id[i];

			if (temp_id.length() != nowBanned_id.length())
				continue; // 길이 다르면 아님

			boolean flag = true;
			for (int j = 0; j < temp_id.length(); j++) {
				if (nowBanned_id.charAt(j) == '*')
					continue; // *이라면 넘어감
				if (nowBanned_id.charAt(j) != temp_id.charAt(j)) {
					flag = false;
					break;
				}
			}
			if (!flag)
				continue;

			visited[i] = true;

			dfs(user_id, banned_id, idx + 1);

			visited[i] = false;

		}

	}

}
