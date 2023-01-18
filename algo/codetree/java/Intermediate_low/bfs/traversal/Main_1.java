package Intermediate_low.bfs.traversal;

import java.io.*;
import java.util.*;

/**
 * 네 방향 탈출 가능 여부 판별하기
 */
public class Main_1 {

    static final int MAX_LEN = 100;

    static int n, m;
    static int[][] map = new int[MAX_LEN + 1][MAX_LEN + 1];
    static int[][] visited = new int[MAX_LEN + 1][MAX_LEN + 1];
    static Queue<int[]> que = new LinkedList<>();
    static int[] dx = new int[] { 0, 1, 0, -1 };
    static int[] dy = new int[] { 1, 0, -1, 0 };

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (map[x][y] == 0 || visited[x][y] == 1)
            return false;
        return true;
    }// end of canGo

    public static void bfs() {
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int currX = cur[0];
            int currY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (canGo(nextX, nextY)) {
                    visited[nextX][nextY] = 1;
                    que.add(new int[] { nextX, nextY });
                }
            }

        } // end of while

    }// end of bfs

    public static void main(String[] args) throws IOException {
        init();

        que.add(new int[] { 1, 1 });
        visited[1][1] = 1;
        bfs();

        System.out.println(visited[n][m]);

    }// end of main

}// end of class
