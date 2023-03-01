package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 7569 토마토
 * bfs
 */

public class Main_7569 {

    static int m, n, h;
    static int[][][] map;

    static int[][][] visited;

    static ArrayList<int[]> tomato = new ArrayList<>(); // x, y, h
    static ArrayList<int[]> blank = new ArrayList<>();

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];

        visited = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++)
                Arrays.fill(visited[i][j], -1);
        }

        for (int i = 0; i < h; i++) { // z
            for (int j = 0; j < n; j++) { // x
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) { // y
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1)
                        tomato.add(new int[] { j, k, i });
                    if (map[i][j][k] == -1)
                        visited[i][j][k] = 0;
                }
            }
        }

        // 정상 입력 확인
        // for (int i = 0; i < h; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.println(Arrays.toString(map[i][j]));
        // }
        // }

    }// end of init

    public static boolean outOfRange(int x, int y, int height) {
        return x < 0 || x >= n || y < 0 || y >= m || height < 0 || height >= h;
    }// end of outOfRange

    public static boolean canGo(int x, int y, int height) {
        // 범위를 벗어나면 방문하지 않음
        if (outOfRange(x, y, height))
            return false;
        // 이미 방문했거나, 방문하는 곳이 빈 칸이거나, 이미 익은 토마토이면 방문하지 않음
        if (visited[height][x][y] != -1 || map[height][x][y] == -1 || map[height][x][y] == 1)
            return false;
        return true;
    }// end of canGo

    public static void sol() {
        int[] dx = new int[] { 0, 1, 0, -1, 0, 0 };
        int[] dy = new int[] { 1, 0, -1, 0, 0, 0 };
        int[] dh = new int[] { 0, 0, 0, 0, 1, -1 };

        Queue<int[]> que = new ArrayDeque<>();

        for (int i = 0; i < tomato.size(); i++) {
            int[] loc = tomato.get(i);

            int x = loc[0];
            int y = loc[1];
            int height = loc[2];

            visited[height][x][y] = 0;
            que.offer(loc);
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];
            int height = cur[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nh = height + dh[i];

                if (!canGo(nx, ny, nh))
                    continue;

                visited[nh][nx][ny] = visited[height][x][y] + 1;
                que.offer(new int[] { nx, ny, nh });
            }
        }

        // for (int i = 0; i < h; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.println(Arrays.toString(visited[i][j]));
        // }
        // }

        int ans = -1;
        here: for (int i = 0; i < h; i++) { // z
            for (int j = 0; j < n; j++) { // x
                for (int k = 0; k < m; k++) { // y
                    if (visited[i][j][k] == -1) {
                        ans = -1;
                        break here;
                    }
                    ans = Math.max(ans, visited[i][j][k]);
                }
            }
        }

        System.out.println(ans);

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main
}
