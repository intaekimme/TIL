package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 미세먼지 안녕 sol
 * 17144, g4
 * 
 * 62144KB, 644ms
 */

public class Main_17144 {

    static int R, C, T;
    static int[][] map;

    static int up;
    static int down;

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

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
                    if (val_cnt == 0) {
                        up = i;
                        val_cnt++;
                    } else
                        down = i;
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

                if (map[x][y] <= 0 || map[x][y] / 5 <= 0)
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

        System.out.println("plus");
        printMap(plus);
        System.out.println("minus");
        printMap(minus);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = map[i][j] - (map[i][j] / 5) * minus[i][j] + plus[i][j];
            }
        }

    }// end of diffusion

    public static void rotate() {
        int[][] copy = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 || i == R - 1 || j == 0 || j == C - 1 || i == up || i == down)
                    continue;
                copy[i][j] = map[i][j];
            }
        }
        copy[up][0] = -1;
        copy[down][0] = -1;

        // 반시계 방향 (위)

        // 아래
        for (int i = up - 1; i >= 0; i--) {
            if (i + 1 == up)
                continue;
            copy[i + 1][0] = map[i][0];
        }

        // 왼쪽
        for (int i = 1; i < C; i++) {
            copy[0][i - 1] = map[0][i];
        }

        // 위
        for (int i = 1; i <= up; i++) {
            copy[i - 1][C - 1] = map[i][C - 1];
        }

        // 오른쪽
        for (int i = C - 2; i >= 1; i--) {
            copy[up][i + 1] = map[up][i];
        }

        // 시계방향 (아래)
        // 위
        for (int i = down + 1; i <= R - 1; i++) {
            if (i - 1 == down)
                continue;
            copy[i - 1][0] = map[i][0];
        }

        // 왼쪽
        for (int i = 1; i < C; i++) {
            copy[R - 1][i - 1] = map[R - 1][i];
        }

        // 아래
        for (int i = R - 2; i >= down; i--) {
            copy[i + 1][C - 1] = map[i][C - 1];
        }

        // 오른쪽
        for (int i = C - 2; i >= 1; i--) {
            copy[down][i + 1] = map[down][i];
        }

        System.out.println("copy");
        printMap(copy);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = copy[i][j];
            }
        }
    }// end of rotate

    public static int getCountDust() {
        int cnt = 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                cnt += map[i][j];
            }
        }
        return cnt;
    }// end of getCountDust

    public static void simulation() {
        while (T-- > 0) {
            diffusion();
            System.out.println("after diffusion");
            printMap(map);
            rotate();
            printMap(map);
        }

        System.out.println(getCountDust());
    }// end of simulation

    public static void printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }// end of printMap

    public static void main(String[] args) throws IOException {
        init();
        System.out.println();
        simulation();

    }// end of main
}// end of class
