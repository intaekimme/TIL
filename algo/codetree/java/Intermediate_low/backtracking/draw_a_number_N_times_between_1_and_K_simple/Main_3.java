package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_simple;

import java.io.*;
import java.util.*;

/**
 * 강력한 폭발
 */
public class Main_3 {

    static final int MAX_N = 20;
    static final int MAX_BOMB = 10;

    static int n;
    static int[][] map = new int[MAX_N][MAX_N];
    static int[][] map_after_bomb;
    static int[][] bomb = new int[MAX_BOMB][];
    static int[] record = new int[MAX_N];

    static int bomb_cnt = 0;

    static int ans = Integer.MIN_VALUE;

    static int[][][] bomb_dxdy = new int[][][] {
            { { 0, -1, 1, -2, 2 },
                    { 0, 0, 0, 0, 0 } },
            { { 0, -1, 0, 1, 0 },
                    { 0, 0, 1, 0, -1 } },
            { { 0, -1, 1, 1, -1 },
                    { 0, 1, 1, -1, -1 } }
    };

    public static int countExplosion() {
        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cnt += map_after_bomb[i][j];

        return cnt;
    }// end of countExplosion

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }// end of outOfRange

    public static void explosion(int idx) {
        int bomb_type = record[idx] - 1;

        int bomb_x = bomb[idx][0];
        int bomb_y = bomb[idx][1];

        int[] dx = bomb_dxdy[bomb_type][0];
        int[] dy = bomb_dxdy[bomb_type][1];

        for (int i = 0; i < 5; i++) {
            int nx = bomb_x + dx[i];
            int ny = bomb_y + dy[i];

            if (outOfRange(nx, ny))
                continue;

            map_after_bomb[nx][ny] = 1;
        }

    }// end of explosion

    public static void simulation() {
        map_after_bomb = new int[MAX_N][MAX_N];

        for (int i = 0; i < MAX_BOMB; i++) {
            if (bomb[i] != null)
                explosion(i);
        }

        int res = countExplosion();

        ans = Math.max(ans, res);
    }// end of simulation

    public static void func(int cnt) {
        if (cnt == bomb_cnt) {
            simulation();
            return;
        }

        for (int bomb_type = 1; bomb_type <= 3; bomb_type++) {
            record[cnt] = bomb_type;
            func(cnt + 1);
        }
    }// end of func

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int bomb_idx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    bomb[bomb_idx++] = new int[] { i, j };
                    bomb_cnt++;
                }
            }
        }
    }// end of init

    public static void main(String[] args) throws IOException {
        init();
        func(0);
        System.out.println(ans);
    }// end of main

}// end of class
