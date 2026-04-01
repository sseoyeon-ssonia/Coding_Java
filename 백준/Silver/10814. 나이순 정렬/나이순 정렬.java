
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
		
		String[][] list = new String[n][2];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			list[i][0]=st.nextToken();
			list[i][1]=st.nextToken();
		}
		
		Arrays.sort(list, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
			}
			
		});
		
		for(int i = 0;i<n;i++) {
			System.out.println(list[i][0]+" "+list[i][1]);
		}
		
	}
}
