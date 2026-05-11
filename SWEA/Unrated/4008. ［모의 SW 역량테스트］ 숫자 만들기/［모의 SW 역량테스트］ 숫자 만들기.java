import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n,minValue,maxValue; //숫자 개수
    static int[] opers, nums; //연산자 개수 저장. + - * / , 숫자 저장


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int tc = 1;tc<=T;tc++){

        minValue=Integer.MAX_VALUE;
        maxValue=Integer.MIN_VALUE; //최솟값 최댓값

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //숫자 개수

        nums = new int[n];

        opers=new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<4;i++){
            opers[i]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }

        operations(1,nums[0]);

        int ans = maxValue-minValue;

        System.out.println("#"+tc+" "+ans);

        }//tc 끝

    }//main 끝

    private static void operations(int idx, int nowValue){
        if(idx==n){
            minValue=Math.min(minValue,nowValue);
            maxValue=Math.max(maxValue,nowValue);
            return;
        }

        for(int i = 0;i<4;i++){
            if(opers[i]==0) continue;
            opers[i]--;
            switch (i){
                case 0:
                    operations(idx+1,nowValue+nums[idx]);
                    break;
                case 1:
                    operations(idx+1,nowValue-nums[idx]);
                    break;
                case 2:
                    operations(idx+1,nowValue*nums[idx]);
                    break;
                case 3:
                    operations(idx+1,nowValue/nums[idx]);
                    break;
            }
            opers[i]++;
        }


    }
}
