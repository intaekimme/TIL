package Intermediate_low.bfs.traversal;

import java.io.*;
import java.util.*;

/**
 * 빙하
 */

public class Main_5 {

    static int N, M;

    static int last = 0;
    static int time = 0;

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    static int[][] map, after;

    static boolean[][] visited;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of init

    public static int getCountIceberg() {
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 1)
                    cnt++;

        return cnt;
    }// end of getCountIceberg

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y])
            return false;
        return true;
    }// end of canGo

    public static boolean isPossible(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!canGo(nx, ny))
                continue;
            if (map[nx][ny] == 1)
                cnt++;
        }

        if (cnt == 4)
            return false;
        return true;
    }// end of isPossible

    public static void copyMap(int[][] from, int[][] to) {
        for (int i = 0; i < N; i++)
            System.arraycopy(from[i], 0, to[i], 0, M);
    }// end of copyMap

    public static void meltIceberg() {
        Queue<int[]> que = new ArrayDeque<>();

        visited = new boolean[N][M];

        after = new int[N][M];
        copyMap(map, after);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isPossible(i, j))
                    continue;
                visited[i][j] = true;
                que.offer(new int[] { i, j });
            }
        }

        visited = new boolean[N][M];

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny))
                    continue;
                if (map[nx][ny] == 0)
                    continue;
                visited[nx][ny] = true;
                after[nx][ny] = 0;
            }
        }

        copyMap(after, map);

        last = getCountIceberg();
    }// end of meltIceberg

    public static void sol() {
        while (getCountIceberg() > 0) {
            meltIceberg();
            time++;
        }

        System.out.println(time + " " + last);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
