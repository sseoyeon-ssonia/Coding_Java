import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int tc = 1;tc<=t;tc++){

            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            Stack<Character> stack = new Stack<>();

            int ans = 0;

            for(int i = 0;i<s.length();i++){
                if(s.charAt(i)=='('){
                    stack.push('(');
                    ans++;
                }else if (s.charAt(i)==')'){
                    if(stack.peek()!='('){
                        stack.push('(');
                        ans++;
                    }else continue;
                }else{
                    stack.push(s.charAt(i));
                }
            }

            System.out.println("#"+tc+" "+ans);

        }//tc 끝
    }//main 끝
}
