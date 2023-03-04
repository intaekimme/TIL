package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 2206 벽 부수고 이동하기 1
 * timeout
 * 
 * n이 1000이고, m이 1000이기 때문에
 * 가능한 벽의 갯수는 최대 1e6(10^6)이 된다.
 * 
 * 벽 하나하나를 부시는 경우를 모두 탐색하면
 * 1e6 * 1e6으로 총 1e12의 경우를 탐색해야 한다.
 * 이렇게 탐색하면 시간초과 발생
 * 
 */

public class Main_2206 {

    static final int MAX = (int) 1e6 + 1;

    static int n, m;
    static char[][] map, copy;
    static ArrayList<int[]> walls = new ArrayList<>();

    static int ans = MAX;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '1')
                    walls.add(new int[] { i, j });
            }
        }

    }// end ofo init

    public static char[][] copyMap(int n, int m, char[][] map) {
        char[][] res = new char[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, res[i], 0, m);
        }

        return res;
    }// end of copyMap

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }// end of outOfRange

    public static boolean canGo(int x, int y, char[][] map, int[][] res) {
        if (outOfRange(x, y))
            return false;
        if (res[x][y] != MAX || map[x][y] == '1')
            return false;
        return true;
    }// end of canGo

    public static int bfs(char[][] copy) {
        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(res[i], MAX);

        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[] { 0, 0 });
        res[0][0] = 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny, copy, res))
                    continue;

                res[nx][ny] = res[x][y] + 1;
                que.offer(new int[] { nx, ny });
            }
        } // end of while

        printMap(res);

        return res[n - 1][m - 1];
    }// end of bfs

    public static void sol() {

        // 벽이 없는 경우
        ans = Math.min(ans, bfs(map));

        // 벽이 있는 경우
        for (int i = 0; i < walls.size(); i++) {
            // copy = copyMap(n, m, map);

            int[] broke_pos = walls.get(i);
            int x = broke_pos[0];
            int y = broke_pos[1];

            // copy[x][y] = '0';
            map[x][y] = '0';

            ans = Math.min(ans, bfs(map));

            map[x][y] = '1';

        }

        System.out.println(ans == MAX ? -1 : ans);
    }// end of sol

    public static void printMap(int[][] map) {
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(map[i]));
    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main
}// end of class
