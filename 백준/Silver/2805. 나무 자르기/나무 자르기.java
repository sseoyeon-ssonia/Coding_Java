
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());

		long[] trees = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees);

		long min = 0;
		long max = trees[n-1];

		while (min<=max) {
			long temp = 0;
			long mid = (min+max)/2;
			for(int i = 0;i<n;i++) {
				if(trees[i]>mid) {
					temp+=trees[i]-mid;
				}
			}
			
			if(temp>=m) {
				min=mid+1;
			}else{
				max=mid-1;
			}
			
		}

		System.out.println(max);

	}

}
