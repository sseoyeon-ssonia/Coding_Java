
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
			int[] dp = new int[12];
			
			dp[1]=1;
			dp[2]=2;
			dp[3]=4;
			
			for(int i = 4;i<12;i++) {
				dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
				
			}
			
			int t = Integer.parseInt(st.nextToken());
			for(int tc = 0;tc<t;tc++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				System.out.println(dp[n]);
			}//tc 끝
		
	}//main 끝
	
	
}
