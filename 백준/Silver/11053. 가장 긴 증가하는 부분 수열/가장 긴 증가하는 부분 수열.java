import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[n];
		int[] dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
			dp[i]=1;
		}
		
		int maxCnt = 0;
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<i;j++) {
				if(nums[j]<nums[i] && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
				}
			}
			
			maxCnt = Math.max(maxCnt, dp[i]);
		}
		
		System.out.println(maxCnt);
	}
}
