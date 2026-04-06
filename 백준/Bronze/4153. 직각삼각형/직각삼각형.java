import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x,y,z;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;

        while(flag){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            if(x==0 && y==0 && z==0) {
                flag=false;
                break;
            }

            int longest = Integer.max(x, Integer.max(y,z));
            int shortest = Integer.min(x,Integer.min(y,z));
            int mid = x+y+z-longest-shortest;

            if(Math.pow(longest,2)==Math.pow(shortest,2)+Math.pow(mid,2)){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }

        }

    }
}
