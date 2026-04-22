import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			int[] inDegree = new int[v + 1];

			List<Integer>[] list = new ArrayList[v + 1];

			for (int i = 1; i <= v; i++) {
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				list[start].add(end);
				inDegree[end]++;
			}

			Queue<Integer> q = new ArrayDeque<>();

			for (int i = 1; i <= v; i++) {
				if (inDegree[i] == 0)
					q.add(i);
			}

			StringBuilder ans = new StringBuilder();

			while (!q.isEmpty()) {
				int temp = q.poll();
				ans.append(" ").append(temp);

				for (int now : list[temp]) {
					inDegree[now]--;
					if (inDegree[now] == 0)
						q.add(now);
				}
			}

			System.out.println("#" + tc + ans);

		}

	}
}
