package Intermediate_low.bfs.traversal;

import java.io.*;
import java.util.*;

/**
 * 갈 수 있는 곳들
 */

public class Main_2 {

    static final int MAX_N = 100;

    static int n, k;
    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static int[] s_r = new int[MAX_N * MAX_N];
    static int[] s_c = new int[MAX_N * MAX_N];
    static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            s_r[i] = Integer.parseInt(st.nextToken());
            s_c[i] = Integer.parseInt(st.nextToken());
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x][y] == 1 || map[x][y] == 2)
            return false;
        return true;
    }// end of canGo

    public static void bfs(int x, int y) {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        Queue<int[]> que = new ArrayDeque<>();

        visited[x][y] = true;
        map[x][y] = 2;
        que.offer(new int[] { x, y });

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int c_x = cur[0];
            int c_y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = c_x + dx[i];
                int ny = c_y + dy[i];

                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    map[nx][ny] = 2;
                    que.offer(new int[] { nx, ny });
                }
            }
        } // end of while

    }// end of bfs

    public static int countVisited() {
        int cnt = 0;
        for (int x = 1; x <= n; x++)
            for (int y = 1; y <= n; y++)
                if (map[x][y] == 2)
                    cnt++;
        return cnt;
    }// end of countVisited

    public static void sol() {
        for (int i = 0; i < k; i++) {
            if (canGo(s_r[i], s_c[i])) {
                bfs(s_r[i], s_c[i]);
            }
        }

        int ans = countVisited();
        System.out.println(ans);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class