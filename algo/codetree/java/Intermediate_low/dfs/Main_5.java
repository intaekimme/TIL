package Intermediate_low.dfs;

import java.io.*;
import java.util.*;

/**
 * 뿌요뿌요
 */
public class Main_5 {
    static final int MAX_N = 100;

    static int n;
    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static boolean[][] visited;
    static int cnt;
    static int explosion = 0;
    static int max_size = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[MAX_N + 1][MAX_N + 1];
    }// end of sol

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }// end of outOfRange

    public static boolean canGo(int x, int y, int before, int next) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || before != next)
            return false;
        return true;
    }// end of canGo

    public static void dfs(int x, int y, int before) {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny, before, map[nx][ny])) {
                visited[nx][ny] = true;
                cnt++;
                dfs(nx, ny, before);
            }
        }
    }// end of dfs

    public static void sol() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (canGo(i, j, map[i][j], map[i][j])) {
                    visited[i][j] = true;
                    cnt = 1;
                    dfs(i, j, map[i][j]);

                    max_size = Math.max(max_size, cnt);
                    if (cnt >= 4) {
                        explosion++;
                    }
                }
            }
        }

        System.out.println(explosion + " " + max_size);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }
}