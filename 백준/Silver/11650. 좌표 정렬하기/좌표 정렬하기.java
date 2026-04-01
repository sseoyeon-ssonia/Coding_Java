

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
		
		int n= Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][2];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0]=Integer.parseInt(st.nextToken());
			map[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}else return o1[0]-o2[0];
			}

		});
		
		for(int i = 0;i<n;i++) {
			System.out.println(map[i][0]+" "+map[i][1]);
		}
		
	}
}
