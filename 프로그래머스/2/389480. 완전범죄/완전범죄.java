class Solution {

    //결국 0-1 knapsack 문제에서 가져갈 수 있는 최대 무게 = b의 m.
    //최대화해야하는 가치 v를 a의 흔적이라고 치고 최소화하기.
    //요점은 해당 물건을 가져가느냐 마느냐 = a가 가져가느냐 b가 가져가느냐


    public int solution(int[][] info, int n, int m) {
        int answer = 0;

        int[][] dp = new int[info.length+1][m]; //인덱스 b, 값 a.
        //물건 i번을 가지고 얘기할 때, b의 흔적이 j개라면 그 때의 a 최솟값은?
        //i++로 누적이 됨
        //이전 물건까지는 [i-1][j]에 쌓였기 때문에 그거랑 현재랑 비교해야 함

        for(int i = 1;i<info.length+1;i++){
            for(int j = 0;j<m;j++){
                dp[i][j]=100000; //덧셈뺄셈 해야하니까 최최댓값 말고.. 적당히 크게
            }
        }

        dp[0][0]=0; //초기값 설정 : 0번 물건에 대해 b흔적이 0일 때

        //경우의 수 : i번째 물건을 a가 가져가거나 b가 가져가거나.
        //내부 값은 최솟값으로 가져가야 함

        for(int i = 1;i<info.length+1;i++){
            int a = info[i-1][0];
            int b = info[i-1][1]; //물건 i에 대해 a,b 각각 흔적 수

            //이제 b의 흔적이 0,1,2,3,...,m일 때 하나씩 돌려야겠다
            for(int j = 0;j<m;j++){

                //점화식
                //a가 선택
                //해당 물건을 포함하는 경우(a)나 포함하지 않는 경우(b)를 비교해야 함

                //a가 선택되었을 때 해당 물건은 b가 가져가지 못했음.
                //결국 최대한 b가 가져가야 함.

                //우선 a가 가져가는 것으로 채워넣기
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+a);

                if(j+b<m){ //b가 가져가는 경우 = 즉, 현재 b흔적 + 이번 물건에 대한 b의 흔적 < m이라면 b가 가져갈 수 있음
                    dp[i][j+b]=Math.min(dp[i][j+b],dp[i-1][j]); //a가 가져가는 것은 없음. b가 가져갈 것.
                }

            }

        }

        //a의 최솟값을 구했을 때 n보다 크다면 불가능한 경우.
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<m;i++){
            min = Math.min(dp[info.length][i],min); //물건을 전부 다 훔쳤을 때 최솟값 비교
        }

        if(min>=n) answer = -1;
        else answer=min;

        return answer;
    }
}