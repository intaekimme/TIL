package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 미세먼지 안녕
 * 17144, g4
 * 
 */

public class Main_17144 {

    static int R, C, T;
    static int[][] map;

    static int[] up = new int[2];
    static int[] down = new int[2];

    static int[] dx = new int[4];
    static int[] dy = new int[4];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        int val_cnt = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == -1) {
                    if (val_cnt == 0)
                        up = new int[] { i, j };
                    else
                        down = new int[] { i, j };
                }
                map[i][j] = val;
            }
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C;
    }

    public static void diffusion() {
        int[][] plus = new int[R][C];
        int[][] minus = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int x = i;
                int y = j;

                if (map[x][y] <= 0)
                    continue;

                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (outOfRange(nx, ny) || map[nx][ny] == -1)
                        continue;
                    plus[nx][ny] += map[x][y] / 5;
                    cnt++;
                }
                minus[x][y] = cnt;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = map[i][j] - (map[i][j] / 5) * minus[i][j] + plus[i][j];
            }
        }

    }// end of diffusion

    public static void rotate(int x, int y, boolean isCW) {
        if (!isCW) {
            // 반시계 방향 (위)
            int[] tmp = new int[4];
            tmp[0] = map[x][y];
            tmp[1] = map[x][C - 1];
            tmp[2] = map[0][C - 1];
            tmp[3] = map[0][0];

            // 우
            for (int i = C - 1; i > 1; i--) {
                map[x][i] = map[x][i - 1];
            }
            map[x][1] = 0;

            // 상
            for (int i = 0; i < x - 1; i++) {
                map[i][C - 1] = map[i + 1][C - 1];
            }
            map[x - 1][C - 1] = tmp[1];

            // 좌
            for (int i = 0; i < C - 1; i++) {
                map[0][i] = map[0][i + 1];
            }
            map[0][C - 2] = tmp[2];

            // 하
            for (int i = x - 1; i > 0; i--) {
                map[i][0] = map[i - 1][0];
            }

        } else {
            // 시계방향 (아래)
            int[] tmp = new int[4];
            tmp[0] = map[x][y];
            tmp[1] = map[x][C - 1];
            tmp[2] = map[R - 1][C - 1];
            tmp[3] = map[R - 1][y];

            // 우
            for (int i = C - 1; i > 1; i--) {
                map[x][i] = map[x][i - 1];
            }
            map[x][1] = 0;

            // 하
            for (int i = R - 1; i > x; i--) {
                map[i][C - 1] = map[i - 1][C - 1];
            }
            map[x + 1][C - 1] = tmp[1];

            // 좌
            for (int i = 0; i < C - 1; i++) {
                map[R - 1][i] = map[R - 1][i + 1];
            }
            map[R - 1][C - 2] = tmp[2];

            // 상
            for (int i = x; i < R - 1; i++) {
                map[i][0] = map[i + 1][0];
            }
            map[R - 1][y] = tmp[3];

            map[x][y] = 0;

        }
    }// end of rotate

    public static int getCountDust() {
        int cnt = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0)
                    cnt += map[i][j];
            }
        }
        return cnt;
    }// end of getCountDust

    public static void simulation() {
        while (T-- > 0) {
            diffusion();
            rotate(up[0], up[1], true);
            rotate(down[0], down[1], false);
            printMap();
        }

        System.out.println(getCountDust());
    }// end of simulation

    public static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }// end of printMap

    public static void main(String[] args) throws IOException {
        init();
        simulation();

    }// end of main
}// end of class
