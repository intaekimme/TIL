package Intermediate_low.bfs.equal_weighted_graph;

import java.io.*;
import java.util.*;

/**
 * 상한 귤
 * 일반 bfs 문제
 */

public class Main_6 {

    static int n, k;

    static int[][] map, dist;

    static int[] sx;
    static int[] sy;

    static ArrayList<int[]> orange = new ArrayList<>();

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    static boolean[][] visited;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        sx = new int[k];
        sy = new int[k];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    sx[idx] = i;
                    sy[idx++] = j;
                }
                if (map[i][j] == 1)
                    orange.add(new int[] { i, j });
            }
        }

        visited = new boolean[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x][y] != 1)
            return false;
        return true;
    }// end of canGo

    public static void sol() {
        Queue<int[]> que = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            int x = sx[i];
            int y = sy[i];

            visited[x][y] = true;
            dist[x][y] = 0;
            que.offer(new int[] { x, y });
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny))
                    continue;

                map[nx][ny] = 2;
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                que.offer(new int[] { nx, ny });
            }

        } // end of while

        for (int i = 0; i < orange.size(); i++) {
            int[] pos = orange.get(i);
            int x = pos[0];
            int y = pos[1];
            if (map[x][y] == 1)
                dist[x][y] = -2;

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                sb.append(dist[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
