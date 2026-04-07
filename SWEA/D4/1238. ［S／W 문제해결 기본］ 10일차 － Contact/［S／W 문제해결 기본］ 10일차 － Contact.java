import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        for(int tc = 1;tc<=10;tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //입력받는 데이터 개수
            int startPoint = Integer.parseInt(st.nextToken()); //시작점
             
            List<Integer>[] adjList = new ArrayList[101];
             
            for(int i = 1;i<101;i++) {
                adjList[i]=new ArrayList<>();
            }
             
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n/2;i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                 
                adjList[from].add(to);
            }
             
            int[] time = new int[101]; //각 인덱스 방문 시간
             
            Arrays.fill(time, -1);
             
            Queue<Integer> q = new LinkedList<>();
             
            time[startPoint]=0;
             
            q.add(startPoint);
             
            int maxTime = 0;
             
            while(!q.isEmpty()) {
                 
                int temp = q.poll();
                 
                for(int next : adjList[temp]) {
                    if(time[next]!=-1) continue;
                     
                    time[next]=time[temp]+1;
                    maxTime = Math.max(maxTime, time[next]);
                    q.add(next);
                }
                 
                 
            }
             
            int ans = 0;
            for(int i = 100;i>=0;i--) {
                if(time[i]==maxTime) {
                    ans = i;
                    break;
                }
                 
            }
             
            System.out.println("#"+tc+" "+ans);
             
        }
         
    }
}