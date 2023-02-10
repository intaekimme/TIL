package Intermediate_low.bfs.traversal;

import java.io.*;
import java.util.*;

/**
 * 우리는 하나
 */

public class Main_6 {

    static final int MAX_N = 8;

    static int n, k, u, d;
    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static boolean[][] visited;
    static int[][] selected = new int[MAX_N][];
    static boolean[][] s_visited = new boolean[MAX_N + 1][MAX_N + 1];

    static Queue<int[]> que = new ArrayDeque<>();

    static int ans = -1;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }// end of outOfRange

    public static boolean canGo(int x, int y, int from) {

        if (outOfRange(x, y))
            return false;
        int h = Math.abs(from - map[x][y]);
        if (visited[x][y] || h < u || h > d)
            return false;
        return true;
    }// end of canGo

    public static void bfs() {
        visited = new boolean[MAX_N + 1][MAX_N + 1];

        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        int cnt = 0; // 갈 수 있는 도시의 수

        // 시작도시
        for (int i = 0; i < k; i++) {
            int sx = selected[i][0];
            int sy = selected[i][1];

            que.offer(new int[] { sx, sy });
            visited[sx][sy] = true;
            cnt++;
        }

        // 시작도시에서 갈 수 있는 다른 도시
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny, map[x][y]))
                    continue;

                visited[nx][ny] = true;
                cnt++;
                que.offer(new int[] { nx, ny });
            }
        }

        ans = Math.max(ans, cnt);
    }// end of bfs

    public static void func(int depth) {
        if (depth == k) {
            bfs();
            return;
        }

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (s_visited[x][y])
                    continue;
                selected[depth] = new int[] { x, y };
                s_visited[x][y] = true;
                func(depth + 1);
                s_visited[x][y] = false;
            }
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        init();
        func(0);
        System.out.println(ans);
    }// end of main

}// end of class