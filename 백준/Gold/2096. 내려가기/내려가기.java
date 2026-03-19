
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//현재 줄에서의 최댓값 저장
//그리고 나의 위치 저장
//다음 줄에서 얻을 수 있는 값 계산
//양옆으로 1개 / 현재 내 위치 로만 이동 가능 {-1,0,1}
//그 때 최댓값 저장

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][3];

		int[] minDP = new int[3];
		int[] maxDP = new int[3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// map 정렬 완료

		for (int i = 0; i < 3; i++) {
			minDP[i] = map[0][i];
			maxDP[i] = map[0][i];
		}

		for (int i = 1; i < n; i++) {
			int[] newMin = new int[3];
			int[] newMax = new int[3];
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					newMin[j] = Math.min(minDP[0], minDP[1]) + map[i][0];
					newMax[j] = Math.max(maxDP[0], maxDP[1]) + map[i][0];
				} else if (j == 1) {
					newMin[j] = Math.min(minDP[0], Math.min(minDP[1], minDP[2])) + map[i][1];
					newMax[j] = Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2])) + map[i][1];
				} else {
					newMin[j] = Math.min(minDP[1], minDP[2]) + map[i][2];
					newMax[j] = Math.max(maxDP[1], maxDP[2]) + map[i][2];
				}
			}
			minDP = newMin;
			maxDP = newMax;

		}

		int ansMin = Math.min(minDP[0], Math.min(minDP[1], minDP[2]));
		int ansMax = Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2]));

		System.out.println(ansMax + " " + ansMin);

	}
}
