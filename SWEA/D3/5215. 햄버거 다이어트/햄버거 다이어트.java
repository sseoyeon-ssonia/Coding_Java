import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T  =  Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //재료의 수
            int l = Integer.parseInt(st.nextToken()); //제한 칼로리

            int[][] dp = new int[n+1][l+1]; //칼로리별 최고 점수

            int[][] ingredients = new int[n+1][2]; //재료별 점수, 칼로리



            for(int i = 1; i <= n; i++){
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }

            //입력 끝
            //dp
            for(int i = 1; i <=n; i++){
                for(int j = 0; j <=l; j++){
                    if(j<ingredients[i][1]){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-ingredients[i][1]]+ingredients[i][0]);
                    }
                }
            }

            System.out.println("#"+tc+" "+dp[n][l]);


        }

    }
}
