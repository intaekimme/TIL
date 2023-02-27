package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 안전 영역
 * 
 */
public class Main_2468 {

    static int ans = 0;

    static int n;
    static int max_h = 0;

    static int[][] origin, map;
    static boolean[][] visited;
    static Queue<int[]> que;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        origin = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
                max_h = Math.max(max_h, origin[i][j]);
            }
        }
    }// end of init

    public static int[][] copyMap() {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++)
            System.arraycopy(origin[i], 0, res[i], 0, n);
        return res;
    }// end of copyMap

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    public static boolean canGo(int x, int y, int h) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x][y] <= h)
            return false;
        return true;
    }// end of canGo

    public static void bfs(int sx, int sy, int h) {
        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        que = new ArrayDeque<>();

        visited[sx][sy] = true;
        que.offer(new int[] { sx, sy });

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny, h))
                    continue;
                visited[nx][ny] = true;
                que.offer(new int[] { nx, ny });
            }
        }
    }// end of bfs

    public static int simulate(int h) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || map[i][j] <= h)
                    continue;
                bfs(i, j, h);
                cnt++;
            }
        }

        return cnt;
    }// end of simulate

    public static void sol() {
        for (int h = 0; h <= max_h; h++) {
            map = copyMap();
            visited = new boolean[n][n];

            ans = Math.max(ans, simulate(h));
        }

        System.out.println(ans);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main
}// end of class
