
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		

		int[] time = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i<n;i++) {
			time[i]=Integer.parseInt(st.nextToken());
		}
		
		
		//걸리는 시간에 따라 sort
		Arrays.sort(time);
		
		//누적합
		int[] waitingSum = new int[n];
		int ans=time[0];
		
		waitingSum[0]=time[0];
		for(int i = 1;i<n;i++) {
			waitingSum[i]+=waitingSum[i-1]+time[i];
			ans+=waitingSum[i];
		}
		
		
		
		System.out.println(ans);
		
	}
}
