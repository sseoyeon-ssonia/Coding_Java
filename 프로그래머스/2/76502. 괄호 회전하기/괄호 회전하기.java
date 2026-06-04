
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;


        for(int i = 0;i<s.length();i++){
            Stack<Character> stack = new Stack<>();

            String splited = s.substring(0,i);
            String str = s.substring(i).concat(splited);

            boolean flag=true;

            for(int j = 0;j<str.length();j++){
                char temp = str.charAt(j);

                if(temp=='[' || temp=='('|| temp=='{'){
                    stack.push(temp);
                }else{
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }

                    char top = stack.peek();

                    if (temp == ']' && top == '[') {
                        stack.pop();
                    } else if (temp == ')' && top == '(') {
                        stack.pop();
                    } else if (temp == '}' && top == '{') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }

                }
            }
            if(flag && stack.isEmpty()) answer++;



        }



        return answer;
    }
}