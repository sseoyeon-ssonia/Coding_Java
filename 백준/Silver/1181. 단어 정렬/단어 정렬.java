

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[n];
		
		for(int i = 0;i<n;i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) return o1.compareTo(o2);
				else return o1.length()-o2.length();
			}
			
		});
		
		System.out.println(arr[0]);
		for(int i = 1;i<n;i++) {
			if(arr[i].equals(arr[i-1])) continue;
			else System.out.println(arr[i]);
		}
		
		
	}//main 끝
}
