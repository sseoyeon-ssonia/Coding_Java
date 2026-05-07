import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        
        Map<String, Integer> num = new HashMap<>();
        for(int i = 0;i<players.length;i++) {
        	num.put(players[i], i);
        }
        
        
        
        for(int i = 0;i<callings.length;i++) {
        	String nowPlayer=callings[i];
        	
        	int temp = num.get(nowPlayer);
        	
        	String changePlayer = players[temp-1];
        	players[temp-1]=players[temp];
        	players[temp]=changePlayer;
        	num.put(nowPlayer, temp-1);
        	num.put(changePlayer, temp);
        	
        	
        }
        
        answer=players;
        
        
        return answer;
    }
}