package Intermediate_low.simulation.exhaustive_search;

import java.io.*;
import java.util.*;

/**
 * 트로미노
 * 
 */

public class Main_3 {

    static final int MAX_N = 200;
    static int n, m;
    static int ans = 0;

    static int[][] map = new int[MAX_N + 3][MAX_N + 3];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of init

    public static int getSumBlock1(int x, int y) {
        int[][] dx = new int[][] { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { 0, -1, 0 } };
        int[][] dy = new int[][] { { 0, 0, 1 }, { 0, 0, 1 }, { 0, -1, 0 }, { 0, 0, -1 } };
        int res = 0;

        // 4개의 블록 탐색
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            // 3개의 영역 탐색
            for (int j = 0; j < 3; j++) {
                int nx = x + dx[i][j];
                int ny = y + dy[i][j];

                sum += map[nx][ny];
            }
            res = Math.max(res, sum);
        }

        return res;
    }// end of getSumBlock1

    public static int getSumBlock2(int x, int y) {
        int[][] dx = new int[][] { { 0, 0, 0 }, { 0, 1, 2 } };
        int[][] dy = new int[][] { { 0, 1, 2 }, { 0, 0, 0 } };
        int res = 0;

        // 2개의 블록 탐색
        for (int i = 0; i < 2; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                int nx = x + dx[i][j];
                int ny = y + dy[i][j];

                sum += map[nx][ny];
            }
            res = Math.max(res, sum);
        }

        return res;
    }// end of getSumBlock2

    public static void sol() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                ans = Math.max(ans, getSumBlock1(i, j));
                ans = Math.max(ans, getSumBlock2(i, j));
            }
        }

        System.out.println(ans);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
