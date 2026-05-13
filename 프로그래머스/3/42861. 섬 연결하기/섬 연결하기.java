import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        }); //그래프 정렬

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        } //본인으로 부모 배열 초기화

        for (int i = 0, pick = 0; i < costs.length && pick < n-1; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int pStart = findSet(costs[i][0]);
            int pEnd = findSet(costs[i][1]);

            if (pStart != pEnd) {
                union(start,end);
                pick++;
                answer += costs[i][2];
            }
        }


        return answer;
    }

    //조상 찾는 메서드
    private static int findSet(int idx) {
        if (parent[idx] != idx) {
            parent[idx]=findSet(parent[idx]);
        }

        return parent[idx];
    }

    //조상 합치는 메서드
    private static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }
}