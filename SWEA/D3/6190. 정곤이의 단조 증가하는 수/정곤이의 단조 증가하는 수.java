import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
 
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
 
            int[] nums = new int[n];
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
 
            Arrays.sort(nums);
 
            int ans = -1;
 
            boolean flag = true;
            for (int i = n - 1; i > 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    int tempNum = nums[i] * nums[j];
 
                    String num = String.valueOf(tempNum);
 
                    flag = true;
                    for (int k = 0; k < num.length() - 1; k++) {
                        if (num.charAt(k) - '0' > num.charAt(k + 1) - '0') {
                            flag = false;
                            break;
                        }
                    }
 
                    if (flag) {
                        ans = Math.max(ans, tempNum);
                    }
 
                }
            }
 
            System.out.println("#" + tc + " " + ans);
 
        }
 
    }
}