
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> names = new HashSet<>();
		
		
//		StringBuilder ans = new StringBuilder();
		ArrayList<String> ans = new ArrayList<>();
		int ansCnt=0;
		
		//듣도 못한 사람
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String hearName = st.nextToken();
			names.add(hearName);
		}
		
		for(int i = 0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			String seeName = st.nextToken();
			if(names.contains(seeName)) {
//				ans.append(seeName).append("\n");
				ans.add(seeName);
				ansCnt++;
			}
			
		}
		
		Collections.sort(ans);
		
		System.out.println(ansCnt);
		for(int i = 0;i<ansCnt;i++) {
			System.out.println(ans.get(i));
		}
		
	}
}
