
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sel = new int[m];
        
        // sidx: 몇 번째 칸을 채우는지, start: 몇 번 숫자부터 뽑을 수 있는지
        generateCombination(0, 1);
    }

    static void generateCombination(int sidx, int start) {
        // M개를 다 뽑았다면 출력
        if (sidx == m) {
            StringBuilder sb = new StringBuilder();
            for (int val : sel) {
                sb.append(val).append(" ");
            }
            System.out.println(sb);
            return;
        }

        // i는 현재 선택할 수 있는 숫자의 시작값(start)부터 N까지
        for (int i = start; i <= n; i++) {
            sel[sidx] = i; // 현재 칸에 숫자 저장
            generateCombination(sidx + 1, i + 1); // 다음 칸은 지금 뽑은 숫자(i)보다 큰 것부터!
        }
    }
}