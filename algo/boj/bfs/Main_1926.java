package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 그림 s1, bfs
 */

public class Main_1926 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x][y] == 0)
            return false;
        return true;
    }// end of canGo

    public static int bfs(int sx, int sy) {
        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[] { sx, sy });
        visited[sx][sy] = true;
        int cnt = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            cnt++;

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny))
                    continue;

                visited[nx][ny] = true;
                que.offer(new int[] { nx, ny });
            }
        }

        return cnt;
    }// end of bfs

    public static void sol() {
        int cnt = 0;
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || map[i][j] == 0)
                    continue;
                cnt++;
                maxSize = Math.max(maxSize, bfs(i, j));
            }
        }

        System.out.println(cnt);
        System.out.println(maxSize);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class