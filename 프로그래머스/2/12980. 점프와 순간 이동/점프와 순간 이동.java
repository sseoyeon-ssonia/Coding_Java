//한 번에 k 칸 앞으로 점프 -> 건전지 -k
//현재까지 온 거리 * 2 위치로 순간이동 -> 건전지 사용량 그대ㅗㄹ


public class Solution {
    public int solution(int n) {
        int ans = 0;



        int nowLoc = n;

        while(nowLoc>0){
            if(nowLoc%2==0){ //짝수
                nowLoc/=2;

            }else{ //홀수
                nowLoc--;
                ans++;
            }
        }
        

        return ans;
    }
}