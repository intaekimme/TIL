package programmers.algorithm_practice_kit.dfs_bfs;

import java.util.*;

/**
 * 게임 내 최단거리. lv2
 */
class Solution_3 {

    int[] dx = new int[] { -1, 0, 1, 0 };
    int[] dy = new int[] { 0, 1, 0, -1 };

    public int solution(int[][] maps) {

        int[][] dist = new int[maps.length][maps[0].length];

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<int[]> que = new ArrayDeque<>();

        dist[0][0] = 1;
        que.offer(new int[] { 0, 0 });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= dist.length || ny < 0 || ny >= dist[0].length)
                    continue;
                if (dist[nx][ny] != -1 || maps[nx][ny] == 0)
                    continue;

                dist[nx][ny] = dist[x][y] + 1;
                que.offer(new int[] { nx, ny });
            }
        } // end of while

        return dist[dist.length - 1][dist[0].length - 1];
    }
}