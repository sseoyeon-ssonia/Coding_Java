
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
	
	int t = sc.nextInt();
	
	for(int i=0; i<t; i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int cnt = 0;
		
		
		
		while(a<=n && b<=n) {
			if(a>=b) {
				b+=a;
				cnt++;
			}else if(a<b) {
				a+=b;
				cnt++;
			}
		}
		

		System.out.println(cnt);
		
	}
	}
}