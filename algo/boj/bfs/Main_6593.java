package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 6593 상범 빌딩, g5
 * bfs
 * 1시간
 */

public class Main_6593 {

    static int L, R, C;
    static char[][][] map;
    static int[][][] dist;

    static int[] start;
    static int[] end;

    static int[] dr = new int[] { -1, 0, 1, 0, 0, 0 };
    static int[] dc = new int[] { 0, 1, 0, -1, 0, 0 };
    static int[] dl = new int[] { 0, 0, 0, 0, 1, -1 };

    static StringBuilder sb = new StringBuilder();

    public static boolean outOfRange(int l, int r, int c) {
        return l < 0 || l >= L || r < 0 || r >= R || c < 0 || c >= C;
    }// end of outOfRange

    public static boolean canGo(int l, int r, int c) {
        if (outOfRange(l, r, c))
            return false;
        if (dist[l][r][c] > -1 || map[l][r][c] == '#')
            return false;
        return true;
    }// end of canGo

    public static void simulation() {
        dist = new int[L][R][C];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++)
                Arrays.fill(dist[i][j], -1);
        }

        Queue<int[]> que = new ArrayDeque<>();

        dist[start[0]][start[1]][start[2]] = 0;

        que.offer(start);

        int time = 0;
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int l = cur[0];
            int r = cur[1];
            int c = cur[2];

            for (int i = 0; i < 6; i++) {
                int nl = l + dl[i];
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (!canGo(nl, nr, nc))
                    continue;

                dist[nl][nr][nc] = dist[l][r][c] + 1;
                que.offer(new int[] { nl, nr, nc });
            }
        } // end of while

        // printMap();

        if (dist[end[0]][end[1]][end[2]] == -1)
            sb.append("Trapped!").append("\n");
        else
            sb.append("Escaped in ").append(dist[end[0]][end[1]][end[2]]).append(" minute(s).").append("\n");

    }// end of simulation

    public static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0)
                break;

            map = new char[L][R][C];

            for (int i = L - 1; i >= 0; i--) {
                for (int j = 0; j < R; j++) {
                    map[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < C; k++) {
                        if (map[i][j][k] == 'S')
                            start = new int[] { i, j, k };
                        if (map[i][j][k] == 'E')
                            end = new int[] { i, j, k };
                    }
                }
                br.readLine();
            }

            simulation();
        } // end of while

        System.out.println(sb.toString());

    }// end of sol

    public static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    sb.append(dist[i][j][k]);
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }// end of printMap

    public static void main(String[] args) throws IOException {
        sol();
    }// end of main
}// end of class
