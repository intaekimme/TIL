package programmers.algorithm_practice_kit.dfs_bfs;

import java.util.*;

/**
 * 네트워크, lv3
 */

class Solution_2 {

    boolean[] visited;
    Queue<Integer> que = new ArrayDeque<>();

    public void bfs(int node, int n, int[][] computers) {
        visited[node] = true;
        que.offer(node);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < n; i++) {
                if (cur == i)
                    continue;
                if (!visited[i] && computers[cur][i] == 1) {
                    visited[i] = true;
                    que.offer(i);
                }
            }
        }
    }// end of bfs

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            bfs(i, n, computers);
            answer++;
        }

        return answer;
    }
}

// 1 2 3
// 1 1 1 0
// 2 1 1 1
// 3 0 1 1
