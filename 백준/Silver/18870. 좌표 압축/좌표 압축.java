

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] nums = new int[n];
		int[] sortedNums = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0,j=0;i<n;i++) {
			sortedNums[i]=nums[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sortedNums);
		
		Map<Integer, Integer> map = new HashMap<>();
		int nowCnt=0;
		for(int i = 0;i<n;i++) {
			if(!map.containsKey(sortedNums[i])) {
				map.put(sortedNums[i], nowCnt++);
			}
		}
		
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0;i<n;i++) {

			ans.append(map.get(nums[i])).append(" ");
			
		}
		
		System.out.print(ans);
		
	}
}
