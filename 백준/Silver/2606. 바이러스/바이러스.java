import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v; //컴퓨터 수
    static int e;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static Queue<Integer> q;
    static int ansCnt=-1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v=Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        e = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[v+1];

        for(int i = 1;i<=v;i++){
            adjList[i] = new ArrayList<>();
        }

        visited=new boolean[v+1];

        for(int i = 1;i<=e;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adjList[start].add(end);
            adjList[end].add(start);

        }

        bfs(1);

        System.out.println(ansCnt);
    }

    public static void bfs(int n){
        q = new LinkedList<>();

        q.add(n);
        visited[n]=true;

        while (!q.isEmpty()){
            int curr = q.poll();
            ansCnt++;

            for(int w:adjList[curr]){
                if(!visited[w]){
                    q.add(w);
                    visited[w]=true;
                }
            }
        }

    }

}
