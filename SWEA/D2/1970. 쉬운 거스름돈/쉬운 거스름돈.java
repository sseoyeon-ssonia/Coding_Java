
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] units = {5000, 1000,500, 100, 50, 10, 5, 1};
		
		int t = sc.nextInt();
		for(int tc = 1;tc<=t;tc++) {
			int n = sc.nextInt()/10;
			
			int[] moneyDP = new int[n+1];
			int[] path = new int[n+1];
			
			Arrays.fill(moneyDP, Integer.MAX_VALUE);
			moneyDP[0]=0;
			
			
			for(int i = 1;i<=n;i++) {
				for(int j = 0;j<units.length;j++) {
					if(i>=units[j]&&moneyDP[i-units[j]]+1<moneyDP[i]){
						moneyDP[i]=moneyDP[i-units[j]]+1;
						path[i]=j;
					}
				}
			}
			
			int[] counts = new int[8];
			int tempN = n;
			while(tempN>0) {
				int coinIdx = path[tempN];
				counts[coinIdx]++;
				tempN-=units[coinIdx];
			}
			
			System.out.println("#"+tc);
			for(int i = 0;i<8;i++) {
				System.out.print(counts[i]+" ");
			}
			System.out.println();
			
		}
		
	}
}