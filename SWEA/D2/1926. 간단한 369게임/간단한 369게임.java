
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		StringBuilder ans = new StringBuilder();
		for(int i = 1;i<=n;i++) {
			String temp = String.valueOf(i);
			
			if(temp.contains("3")||temp.contains("6")||temp.contains("9")) {
				for(int j = 0;j<temp.length();j++) {
					if(temp.charAt(j)=='3'||temp.charAt(j)=='6'||temp.charAt(j)=='9') {
						ans.append('-');
					}
				}
			}else {
				ans.append(temp);
			}
			
			
			ans.append(" ");
			
		}
		
		System.out.println(ans);
	}

	
}
