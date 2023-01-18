package Intermediate_low.dfs;

import java.io.*;
import java.util.*;

/**
 * 두 방향 탈출 가능 여부 판별하기
 */
public class Main_2 {
    static final int MAX_LEN = 100;

    static int n, m;
    static int[][] map = new int[MAX_LEN + 1][MAX_LEN + 1];
    static boolean[][] visited = new boolean[MAX_LEN + 1][MAX_LEN + 1];
    static boolean canEscape = false;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of init

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= m;
    }// end of inRange

    public static boolean canGo(int x, int y) {
        if (inRange(x, y) && !visited[x][y] && map[x][y] != 0)
            return true;
        return false;
    }// end of canGo

    public static void dfs(int currX, int currY) {
        int[] dx = new int[] { 1, 0 };
        int[] dy = new int[] { 0, 1 };

        if (currX == n && currY == m)
            canEscape = true;

        for (int i = 0; i < 2; i++) {
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];

            if (canGo(nextX, nextY)) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }

    }// end of dfs

    public static void main(String[] args) throws IOException {

        init();

        dfs(1, 1);

        if (canEscape)
            System.out.println(1);
        else
            System.out.println(0);

    }// end of main

}// end of class
