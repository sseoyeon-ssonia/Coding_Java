import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num;
        int count = 0;
        for(int i=0; i<N; i++){
            num = sc.nextInt();
            for(int j=2; j<=num; j++){
                if(j==num) {
                    count++;
                }
                if(num%j==0){
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
