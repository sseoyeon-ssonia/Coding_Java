/*
SWEA D3 - 26837. DNA 수열
https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AZ5ipX4ahvPHBITl&categoryId=AZ5ipX4ahvPHBITl&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=JAVA&select-1=3&pageSize=10&pageIndex=1

# 풀이 1
[풀이 흐름]
- 반전 관계 존재의 조건은 다음과 같음
    1. 잘라진 구간 문자열의 길이가 짝수일 것.
    2. A-T / C-G 각각 개수가 서로 같을 것.

- for문 조건을 잘라낼 문자열 길이로 하며 조건 탐색한다.

[정리]
- 이 방식대로 진행하면 시간초과 남.
- 다른 방법 필요
- 그럼 DP로 풀자.

# 풀이 2
[풀이 흐름]
- 결국 A-T ==0 && C-G==0이 되면 됨
- 누적합 !
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int tc = 1;tc<=t;tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int ans = 0;

            int[] aCnt = new int[n+1];
            int[] tCnt = new int[n+1];
            int[] cCnt = new int[n+1];
            int[] gCnt = new int[n+1];

            for(int i = 0;i<n;i++){
                aCnt[i+1]=aCnt[i];
                tCnt[i+1]=tCnt[i];
                cCnt[i+1]=cCnt[i];
                gCnt[i+1]=gCnt[i];

                if(s.charAt(i)=='A') aCnt[i+1]++;
                else if(s.charAt(i)=='T') tCnt[i+1]++;
                else if(s.charAt(i)=='C') cCnt[i+1]++;
                else if(s.charAt(i)=='G') gCnt[i+1]++;
            } //위치별 누적 개수 저장

            for(int i = 0;i<n;i++){ //시작점
                for(int j = i;j<n;j++){ //끝점
                    int aNow = aCnt[j+1]-aCnt[i];
                    int tNow = tCnt[j+1]-tCnt[i];
                    int cNow = cCnt[j+1]-cCnt[i];
                    int gNow = gCnt[j+1]-gCnt[i];

                    if(aNow==tNow && cNow==gNow) ans++;
                }
            }

            System.out.println(ans);

        }//tc 끝
    } //main 끝
}



//풀이 1 -> 시간초과
/*

public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int tc = 1;tc<=t;tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            int ans = 0;

            for(int i = 2;i<=n;i+=2){ //잘라낼 문자열 길이
                for(int j = 0;j<=n-i;j++){ //시작점
                    int aCnt = 0;
                    int tCnt = 0;
                    int cCnt = 0;
                    int gCnt = 0;

                    for(int x=j;x<j+i;x++){
                        switch (s.charAt(x)){
                            case 'A':
                                aCnt++;
                                break;
                            case 'T':
                                tCnt++;
                                break;
                            case 'C':
                                cCnt++;
                                break;
                            case 'G':
                                gCnt++;
                                break;
                        }
                    }

                    if(aCnt==tCnt && cCnt==gCnt) ans++;

                }//시작점 for문 끝
            } //문자열 길이 끝

            System.out.println(ans);

        } //tc 끝
    } //main 끝
 */