package programmers.algorithm_practice_kit.exhaustive_search;

import java.util.*;

/**
 * 전역망 둘로 나누기, lv2
 * wire를 하나씩 끊어 보면서 두 전력망의 송전탑 갯수 차이의 최솟값을 갱신한다.
 * n개의 송전탑, 1 <= n <= 100이므로 인접행렬로 표현
 *
 */

class Solution_6 {

    int N;
    int[][] adjMat;
    boolean[] visited;

    public void init(int[][] wires) {
        adjMat = new int[N + 1][N + 1];

        for (int i = 0; i < N - 1; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            adjMat[v1][v2] = 1;
            adjMat[v2][v1] = 1;
        }
    }// end of init

    public int bfs(int start, boolean[] visited) {
        int cnt = 0;

        Queue<Integer> que = new ArrayDeque<>();

        que.offer(start);
        visited[start] = true;
        while (!que.isEmpty()) {
            int from = que.poll();
            cnt++;

            for (int to = 1; to <= N; to++) {
                int node = adjMat[from][to];
                if (visited[to] || node == 0)
                    continue;
                visited[to] = true;
                que.offer(to);
            }
        } // end of while

        return cnt;
    }// end of bfs

    public int getDiff(int idx, int[][] wires) {
        int[] cutting = wires[idx];

        int v1 = cutting[0];
        int v2 = cutting[1];

        adjMat[v1][v2] = 0;
        adjMat[v2][v1] = 0;

        visited = new boolean[N + 1];

        int cnt1 = bfs(v1, visited);
        int cnt2 = bfs(v2, visited);

        // System.out.println(cnt1 + ", " + cnt2);

        adjMat[v1][v2] = 1;
        adjMat[v2][v1] = 1;

        return Math.abs(cnt1 - cnt2);
    }// end of getDiff

    public int solution(int n, int[][] wires) {

        N = n;
        init(wires);

        int answer = 101;

        for (int i = 0; i < N - 1; i++) {
            answer = Math.min(answer, getDiff(i, wires));
        }

        return answer;
    }
}
