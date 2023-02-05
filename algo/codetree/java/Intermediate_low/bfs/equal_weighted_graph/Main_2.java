package Intermediate_low.bfs.equal_weighted_graph;

import java.io.*;
import java.util.*;

/**
 * 가중치가 동일한 그래프에서의 bfs
 * 나이트
 */

public class Main_2 {

    static final int MAX_N = 100;

    static int n, r1, c1, r2, c2;
    static int[][] step = new int[MAX_N + 1][MAX_N + 1];
    static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];

    static Queue<int[]> que = new ArrayDeque<>();

    public static void push(int x, int y, int dist) {
        step[x][y] = dist;
        visited[x][y] = true;
        que.offer(new int[] { x, y });
    }// end of push

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= MAX_N; i++)
            Arrays.fill(step[i], -1);

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y])
            return false;
        return true;
    }// end of canGo

    public static void bfs() {
        int[] dx = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] dy = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny))
                    continue;
                push(nx, ny, step[x][y] + 1);
            }
        }
    }// end of bfs

    public static void sol() {
        push(r1, c1, 0);
        bfs();

        for (int[] r : step) {
            for (int c : r)
                System.out.print(c + " ");
            System.out.println();
        }

        System.out.println(step[r2][c2]);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }
}
