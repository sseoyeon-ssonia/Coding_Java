


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m; //도시 수
    static List<Integer>[] graph;
    static boolean[] visited;
    static Queue<Integer> q;
    static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());

        graph=new ArrayList[n];
        for(int i = 0;i<n;i++){
            graph[i]=new ArrayList<>();
        }//초기화

        visited=new boolean[n];
        StringTokenizer st;
        for(int i = 0;i<n;i++){
            st =new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                int info = Integer.parseInt(st.nextToken());

                if(info==1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        plan = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++){
            plan[i]=Integer.parseInt(st.nextToken())-1;
        }

        dfs(plan[0]);

        String ans = "YES";
        for(int i = 0;i<m;i++){
            if(!visited[plan[i]]){
                ans="NO";
                break;
            }
        }

        System.out.println(ans);

    }//main 끝

    public static void dfs(int v){
       
    	visited[v]=true;
    	
    	for(int curr:graph[v]) {
    		if(!visited[curr]) {
    			dfs(curr);
    		}
    	}

    }
}



















