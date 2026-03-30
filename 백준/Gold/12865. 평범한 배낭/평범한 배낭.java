

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int cnt = Integer.parseInt(st.nextToken()); //물건 수
		int maxWeight = Integer.parseInt(st.nextToken()); //준서 버틸 수 있는 무게
		
		int[] weight = new int[cnt+1];
		int[] value = new int[cnt+1];
		
		for(int i = 1;i<cnt+1;i++) {
			st = new StringTokenizer(br.readLine());
			weight[i]=Integer.parseInt(st.nextToken());
			value[i]=Integer.parseInt(st.nextToken());
		}
		//input 끝
		
		int[][] dp = new int[cnt+1][maxWeight+1];
		
		for(int i = 1;i<cnt+1;i++) {
			for(int j = 0;j<maxWeight+1;j++) {
				if(weight[i]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
				}
			}
		}
		
		System.out.println(dp[cnt][maxWeight]);
		
	}
}
