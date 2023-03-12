package programmers.algorithm_practice_kit.graph;

import java.util.*;

/**
 * 가장 먼 노드, lv 3
 * 간선 가중치 1 -> bfs + dist 배열 사용
 * 노드 갯수 max 20_000 -> 인접 리스트로 구현
 */

class Solution_1 {

    int N;

    int[] dist; // 거리 배열
    boolean[] visited; // 방문 배열
    ArrayList<Integer>[] list; // 인접 리스트
    Queue<Integer> que; // bfs 큐

    public void makeGraph(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            int from = edge[0];
            int to = edge[1];

            list[from].add(to);
            list[to].add(from);
        }
    }// end of makeGraph

    public void init(int n, int[][] edges) {
        N = n;

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        que = new ArrayDeque<>();

        makeGraph(edges);
    }// end of init

    public void bfs(int start) {
        visited[start] = true;
        dist[start] = 0;
        que.offer(start);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < list[cur].size(); i++) {
                int to = list[cur].get(i);
                if (visited[to] || dist[to] != 0)
                    continue;
                visited[to] = true;
                dist[to] = dist[cur] + 1;
                que.offer(to);
            }
        } // end of while

    }// end of bfs

    public int getMaxCnt() {
        int cnt = 0;

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (max == dist[i])
                cnt++;
        }

        return cnt;
    }// end of getMaxCnt

    public int solution(int n, int[][] edge) {
        int answer = 0;

        init(n, edge);

        bfs(1);

        answer = getMaxCnt();

        return answer;
    }
}
