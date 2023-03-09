package programmers.algorithm_practice_kit.dfs_bfs;

import java.util.*;

/**
 * 아이템 줍기, lv3
 * fail
 */

class Solution_5 {

    final int MAX_N = 101;

    int min_x, max_x, min_y, max_y;

    int[][] map;
    int[][] dist;
    // int[][] visited;

    int[] dx = new int[] { -1, 0, 1, 0 };
    int[] dy = new int[] { 0, 1, 0, -1 };

    public void init() {
        map = new int[MAX_N][MAX_N];
        dist = new int[MAX_N][MAX_N];
        // visited = new int[MAX_N][MAX_N];

        for (int i = 0; i < MAX_N; i++) {
            Arrays.fill(dist[i], -1);
            // Arrays.fill(visited[i], 2);
        }

    }// end of init

    public void paintRectangle(int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            int leftBottomX = rectangle[i][0] * 2;
            int leftBottomY = rectangle[i][1] * 2;
            int rightTopX = rectangle[i][2] * 2;
            int rightTopY = rectangle[i][3] * 2;

            min_x = Math.min(min_x, leftBottomX);
            max_x = Math.max(max_x, rightTopX);
            min_y = Math.min(min_y, leftBottomY);
            max_y = Math.max(max_y, rightTopY);

            for (int y = leftBottomY; y <= rightTopY; y++) {
                for (int x = leftBottomX; x <= rightTopX; x++) {
                    if (map[y][x] == 1)
                        continue;
                    map[y][x] = 1;
                    if (x == leftBottomX || x == rightTopX || y == leftBottomY || y == rightTopY)
                        map[y][x] = 2;
                }
            }
        }

        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                if (map[i][j] >= 2)
                    map[i][j] = 0;
            }
        }
    }// end of printRectangle

    public boolean outOfRange(int x, int y) {
        return x < 0 || x >= MAX_N || y < 0 || y >= MAX_N;
    }// end of outOfRange

    public boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (dist[x][y] != -1 || map[x][y] != 2)
            return false;
        return true;
    }// end of canGo

    public void bfs(int sx, int sy) {
        Queue<int[]> que = new ArrayDeque<>();

        dist[sx][sy] = 1;
        // visited[sx][sy]--;
        que.offer(new int[] { sx, sy });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny))
                    continue;
                dist[nx][ny] = dist[x][y] + 1;
                que.offer(new int[] { nx, ny });
            }
        }
    }// end of bfs

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        init();

        paintRectangle(rectangle);

        bfs(2 * characterX, 2 * characterY);

        printMap(map);
        // printMap(dist);

        answer = dist[2 * itemX][2 * itemY];

        return answer;
    }// end of solution

    public void printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int i = min_y; i <= max_y + 1; i++) {
            for (int j = min_x; j <= max_x + 1; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }// end of printMap

}// end of class
