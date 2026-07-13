import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int tc = 1;tc<=t;tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int ans = 0;

            int[] originSwitch = new int[n];
            int[] goalSwitch = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++){
                originSwitch[i]=Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++){
                goalSwitch[i]=Integer.parseInt(st.nextToken());
            }

            for(int i = 0;i<n;i++){
                if(originSwitch[i]==goalSwitch[i])continue;
                else{
                    ans++;
                    for(int j = i;j<n;j++){
                        originSwitch[j] = 1 - originSwitch[j];
                    }
                }
            }

            System.out.println("#"+tc+" "+ans);

        }
    }
}
