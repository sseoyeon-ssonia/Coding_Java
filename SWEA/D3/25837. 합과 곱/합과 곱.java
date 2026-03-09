
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 1;t<=tc;t++) {
			
			long s = sc.nextLong();
			long p = sc.nextLong();
			
			String ans = "No";
			
			for(long i = 1; i<=Math.sqrt(p);i++) {
				if(Math.pow(i, 2)+Math.pow(s-i, 2)==Math.pow(s, 2)-2*p) {
					ans="Yes";
					break;
				}
			}
			
			System.out.println(ans);
		
		}
	}
}