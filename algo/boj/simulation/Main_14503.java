package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 14503 로봇청소기_fail
 * simulation
 */

public class Main_14503 {

    static int n, m, sr, sc, dir;
    static int ans = 0;
    static int[][] map; // 0 : 청소 안한 칸, 1: 벽, 2 : 청소한 칸
    static boolean[][] visited;

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x][y] == 1 || map[x][y] == 2)
            return false;
        return true;
    }// end of canGo

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (!canGo(nx, ny))
                continue;

            visited[nx][ny] = true;
            map[nx][ny] = 2;
            dfs(nx, ny);
        }

    }// end of dfs

    public static void sol() {
        visited[sr][sc] = true;
        map[sr][sc] = 2;
        ans++;

        dfs(sr, sc);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
