import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r;
        int c;
        int g; // 시작점부터 현재까지 실제 거리
        int f; // g + h

        Node(int r, int c, int g, int f) {
            this.r = r;
            this.c = c;
            this.g = g;
            this.f = f;
        }
    }

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int targetR = n - 1;
        int targetC = m - 1;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.f - b.f);

        // 시작점도 지나간 칸에 포함하므로 거리 1부터 시작
        dist[0][0] = 1;

        int startH = heuristic(0, 0, targetR, targetC);
        pq.offer(new Node(0, 0, 1, 1 + startH));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            int nowR = now.r;
            int nowC = now.c;
            int nowG = now.g;

            // 이미 더 짧은 거리로 방문한 적 있으면 무시
            if (nowG > dist[nowR][nowC]) {
                continue;
            }

            // 도착지에 도착하면 최단거리 반환
            if (nowR == targetR && nowC == targetC) {
                return nowG;
            }

            for (int i = 0; i < 4; i++) {
                int nr = nowR + dr[i];
                int nc = nowC + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                if (maps[nr][nc] == 0) {
                    continue;
                }

                int nextG = nowG + 1;

                if (nextG < dist[nr][nc]) {
                    dist[nr][nc] = nextG;

                    int h = heuristic(nr, nc, targetR, targetC);
                    int f = nextG + h;

                    pq.offer(new Node(nr, nc, nextG, f));
                }
            }
        }

        return -1;
    }

    static int heuristic(int r, int c, int targetR, int targetC) {
        return Math.abs(r - targetR) + Math.abs(c - targetC);
    }
}