package Intermediate_low.simulation.exhaustive_search;

import java.io.*;
import java.util.*;

/**
 * 양수 직사각형의 최대 크기
 * n * m개의 좌표, n,m max = 20
 * 
 * naive
 * 1개의 좌표에서 가능한 직사각형 갯수 : n * m개
 * 1개의 좌표에서 가능한 모든 직사각형 중 가능한 양수 직사각형 계속 찾아 갱신한다.
 * 
 * 시간복잡도 : O((NM)^3)
 */

public class Main_7 {

    static final int MAX_N = 20;

    static int n, m;
    static int[][] map = new int[MAX_N + 1][MAX_N + 1];

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

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }// end of outOfRage

    public static int findMax(int x, int y) {
        int res = 0;
        for (int dx = 0; dx < n; dx++) {
            for (int dy = 0; dy < m; dy++) {
                int cnt = 0;
                here: for (int nx = x; nx <= x + dx; nx++) {
                    for (int ny = y; ny <= y + dy; ny++) {
                        if (outOfRange(nx, ny) || map[nx][ny] <= 0) {
                            cnt = 0;
                            break here;
                        }
                        cnt++;
                    }
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }// end of findMax

    public static void sol() {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                ans = Math.max(ans, findMax(i, j));
            }
        }

        System.out.println(ans != 0 ? ans : -1);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
