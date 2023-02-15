package Intermediate_low.simulation.exhaustive_search;

import java.io.*;
import java.util.*;

/**
 * 금 채굴하기
 * 마름모 영역 카운트
 * 
 * 마름모 방정식 생각하기
 * x, y : 점 x, y의 좌표 (k에 따라 새롭게 구한 좌표)
 * centerX, centerY : 마름모의 x, y 좌표
 * a : 가로 길이의 절반
 * b : 세로 길이의 절반
 * 
 * 마름모 방정식 : |x - centerX| / a + |y - centerY| / b = 1 -> 테두리
 * 마름모 내부에 존재하는지 알려면
 * |x - centerX| / a + |y - centerY| / b <= 1 만족해야함
 */

public class Main_4 {

    static final int MAX_N = 20;
    static final int MAX_K = 20;

    static int n, m;

    static int[][] map = new int[MAX_N + 1][MAX_N + 1];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }// end of outOfRage

    public static boolean inArea(int x, int y, int centerX, int centerY, int k) {
        return Math.abs(x - centerX) + Math.abs(y - centerY) <= k;
    }// end of inArea

    public static int findMax(int x, int y) {
        int res = 0;

        for (int k = 0; k <= n; k++) {
            int cnt = 0;
            for (int dx = -k; dx < k + 1; dx++) {
                for (int dy = -k; dy < k + 1; dy++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    if (!outOfRange(nx, ny) && inArea(nx, ny, x, y, k) && map[nx][ny] == 1) {
                        cnt += map[nx][ny];
                    }
                }
            }
            if (cnt == 0)
                continue;
            int digCost = (int) Math.pow(k, 2) + (int) Math.pow(k + 1, 2);
            int gold = m * cnt;
            if (digCost > gold)
                continue;
            res = Math.max(res, cnt);
        }

        return res;
    }// end of findMax

    public static void sol() {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, findMax(i, j));
            }
        }

        System.out.println(ans);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
