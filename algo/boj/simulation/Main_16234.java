package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 16234, 인구이동, g5
 * 푸는중
 */

public class Main_16234 {

    static int N, L, R;
    static int[][] map;
    static int[][] visited;

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }// end of outOfRange

    public static boolean canGo(int sx, int sy, int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] > 0 || Math.abs(map[sx][sy] - map[x][y]) < L || Math.abs(map[sx][sy] - map[x][y]) > R)
            return false;
        return true;
    }// end of canGo

    public static void bfs(int r, int c, int id) {
        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[] { r, c });
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(x, y, nx, ny))
                    continue;

                visited[nx][ny] = id;
                que.offer(new int[] { nx, ny });
            }
        }
    }// end of bfs

    public static void simulation() {
        while (true) {
            visited = new int[N][N];

            int id = 1;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    // 이미 표시한 곳이면 pass
                    if (visited[x][y] > 0) {
                        visited[x][y] = ++id;
                        continue;
                    }
                    visited[x][y] = id;
                    bfs(x, y, id);
                }
            }

            if (id == N * N)
                break;
        }
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main
}// end of class
