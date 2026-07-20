import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<Character,Integer> map = new HashMap<>();

        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);


        for(int i = 0 ;i<survey.length;i++){
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int nowChoice = choices[i];

            switch (nowChoice){
                case 1,2,3:
                    map.put(first,map.get(first)+(4-nowChoice));
                    break;
                case 4:
                    break;
                case 5,6,7:
                    map.put(second,map.get(second)+(nowChoice-4));
                    break;
            }
        }

        if(map.get('R')>=map.get('T')){
            answer="R";
        }else{
            answer="T";
        }

        if(map.get('C')>=map.get('F')){
            answer=answer+"C";
        }else{
            answer=answer+"F";
        }

        if(map.get('J')>=map.get('M')){
            answer=answer+"J";
        }else{
            answer=answer+"M";
        }

        if(map.get('A')>=map.get('N')){
            answer=answer+"A";
        }else{
            answer=answer+"N";
        }

        return answer;
    }
}