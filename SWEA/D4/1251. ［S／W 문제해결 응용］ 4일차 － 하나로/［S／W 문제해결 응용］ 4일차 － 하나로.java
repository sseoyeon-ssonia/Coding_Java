import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    static int n;
    static double ans;
    static long[] x, y;
    static double rate;
    static int[] parent;
 
    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        double cost;
 
        public Edge(int start, int end) {
            super();
            this.start = start;
            this.end = end;
            this.cost = distance(start, end);
        }
 
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
 
    }
 
    static LinkedList<Edge> list;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
 
            st = new StringTokenizer(br.readLine());
 
            n = Integer.parseInt(st.nextToken());
 
            x = new long[n]; // x좌표 배열
            y = new long[n]; // y좌표 배열
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                x[i] = Long.parseLong(st.nextToken());
            }
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                y[i] = Long.parseLong(st.nextToken());
            }
 
            // x,y 좌표 입력
 
            st = new StringTokenizer(br.readLine());
            rate = Double.parseDouble(st.nextToken());
 
            // 세율 입력
 
            // 입력 끝
 
            parent = new int[n]; // 부모 인덱스 저장
 
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            } // 초기화
 
            list = new LinkedList<>();
 
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    list.add(new Edge(i, j));
                }
            }
 
            Collections.sort(list);
 
            ans = 0;
 
            for (int i = 0, pick = 0; i < list.size() && pick < n - 1; i++) {
                Edge temp = list.get(i);
                if (find(temp.start) != find(temp.end)) {
                    union(temp.start,temp.end);
                    ans += temp.cost;
                    pick++;
                }
            }
 
            System.out.println("#" + tc + " " + Math.round(ans));
 
        }
 
    }
 
    static void union(int a, int b) {
        parent[find(b)] = find(a);
    }
 
    static int find(int a) {
        if (a != parent[a])
            parent[a] = find(parent[a]);
        return parent[a];
    }
 
    static double distance(int start, int end) {
        long dist = (long) (Math.pow(Math.abs(x[start] - x[end]), 2) + Math.pow(Math.abs(y[start] - y[end]), 2));
 
        return rate * dist;
    }
}