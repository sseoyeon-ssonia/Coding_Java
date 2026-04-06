import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long A, B, C, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        ans = cal(A,B);

        System.out.println(ans);

    }
    static long cal(long a,long b){
        if(b==1) return a % C;

        long temp = cal(a,b/2);

        if(b%2==0){
            return (temp*temp)%C;
        }else{
            return (((temp*temp)%C)*a)%C;
        }

    }
}
