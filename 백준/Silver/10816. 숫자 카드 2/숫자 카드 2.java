import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        HashMap<Long,Integer> First = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long now = Long.parseLong(st.nextToken());
            First.put(now,First.getOrDefault(now,0)+1);
        }

        StringBuilder ans = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++){
            long now = Long.parseLong(st.nextToken());
            ans.append(String.valueOf(First.getOrDefault(now,0))).append(" ");
        }
        System.out.println(ans);
    }
}
