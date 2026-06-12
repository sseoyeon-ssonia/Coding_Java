import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int len = order.length;

        Stack<Integer> stack = new Stack<>();

        int boxNum = 1; //다음에 나올 박스 번호

        for(int now : order){
            while (boxNum<=len && boxNum <= now){
                stack.push(boxNum);
                boxNum++;
            }

            if(!stack.isEmpty() && stack.peek()==now){
                stack.pop();
                answer++;
            }else{
                return answer;
            }

        }

        return answer;
    }
}