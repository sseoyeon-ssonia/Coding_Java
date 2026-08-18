

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        Map<String, Integer> giftsMap = new HashMap<>(); //두 사람 간 선물 주고받은 기록
        Map<String, Integer> giftPoints = new HashMap<>(); //선물지수

        for(String s:gifts){ //모든 gifts 다 돌아봄
            giftsMap.put(s,giftsMap.getOrDefault(s,0)+1); //map에 값 넣기

            StringTokenizer st = new StringTokenizer(s);

            String a = st.nextToken();
            String b = st.nextToken();

            giftPoints.put(a,giftPoints.getOrDefault(a,0)+1);
            giftPoints.put(b,giftPoints.getOrDefault(b,0)-1);
        }

        int[] getGifts = new int[friends.length]; //다음 달 받는 선물 수

        for(int i = 0;i< friends.length-1;i++){
            for(int j = i+1;j< friends.length;j++){

                String a = friends[i];
                String b = friends[j];

                int aToB = giftsMap.getOrDefault(a + " " + b, 0);
                int bToA = giftsMap.getOrDefault(b + " " + a, 0);

                //  서로 주고받은 선물 수가 다르면
                if(aToB > bToA){
                    getGifts[i]++;
                }
                else if(aToB < bToA){
                    getGifts[j]++;
                }

                // 서로 주고받은 선물 수가 같으면 선물 지수 비교
                else {
                    int aPoint = giftPoints.getOrDefault(a, 0);
                    int bPoint = giftPoints.getOrDefault(b, 0);

                    if(aPoint > bPoint){
                        getGifts[i]++;
                    }
                    else if(aPoint < bPoint){
                        getGifts[j]++;
                    }
                }

            }
        }

        for(int i = 0;i<getGifts.length;i++){
            answer = Math.max(answer,getGifts[i]);
        }

        return answer;
    }
}