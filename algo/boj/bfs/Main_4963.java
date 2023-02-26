package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 4963 섬의 개수, s2
 */

public class Main_4963 {

    static final int MAX_WH = 50;

    static int w, h;
    static int ans = 0;
    static int[][] map;
    static boolean[][] visited;

    static boolean next = true;

    static StringBuilder sb = new StringBuilder();

    public static void init(BufferedReader br, StringTokenizer st) throws IOException {

        map = new int[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= h || y < 0 || y >= w;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x][y] == 0)
            return false;
        return true;
    }// end of canGo

    public static void bfs(int sx, int sy) {

        int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };

        Queue<int[]> que = new ArrayDeque<>();

        visited[sx][sy] = true;
        que.offer(new int[] { sx, sy });

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny))
                    continue;
                visited[nx][ny] = true;
                que.offer(new int[] { nx, ny });
            }
        } // end of while

        ans++;
    }// end of bfs

    public static void sol() {
        ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j] || map[i][j] == 0)
                    continue;
                bfs(i, j);
            }
        }
        sb.append(ans).append("\n");
    }// end of sol

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            init(br, st);
            sol();
        }

        System.out.print(sb.toString());

    }// end of main

}// end of class
