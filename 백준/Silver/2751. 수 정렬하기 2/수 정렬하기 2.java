

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		List<Integer> nums = new ArrayList<>();
		
		for(int i = 0;i<n;i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(nums);
		
		StringBuilder ans = new StringBuilder();
		for(int i = 0;i<n;i++) {
			ans.append(nums.get(i)).append("\n");
		}
		
		System.out.print(ans);
		
	}
}
