import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution
{
    static int dayPrice; // 1일 이용권
    static int monthPrice; // 1달 이용권. 매달 1일부터 시작
    static int threePrice; // 3달 이용권. 매달 1일부터 시작
    static int yearPrice; // 1년 이용권. 1월 1일부터 시작
    static int[] plan = new int[13]; // 1년 계획
    static int minPrice;
    static int[] accumPrice = new int[13];
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
 
            dayPrice = sc.nextInt();
            monthPrice = sc.nextInt();
            threePrice = sc.nextInt();
            yearPrice = sc.nextInt();
 
            for (int i = 1; i <= 12; i++) {
                plan[i] = sc.nextInt();
            }
 
            // 인풋 받음
 
            minPrice = yearPrice;
             
            //매달 가장 저렴한 가격 조회해서 저장
            for(int i = 1;i<=12;i++) {
                int nowPrice = Math.min(dayPrice*plan[i], monthPrice);
                accumPrice[i]=accumPrice[i-1]+nowPrice;
                 
                if(i>=3) {
                    if(threePrice<accumPrice[i]) {
                        accumPrice[i] = Math.min(accumPrice[i-3]+threePrice, accumPrice[i]);
                    }
                }
            }
            minPrice=Math.min(yearPrice, accumPrice[12]);
            System.out.println("#" + tc + " " + minPrice);
 
        } // tc 끝
    } // main 끝
}