package Intermediate_low.simulation.exhaustive_search;

import java.io.*;
import java.util.*;

/**
 * 행복한 수열의 개수
 * 행복한 수열 = 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열
 * 행과 열 탐색
 * 총 2n개의 수열 탐색해서 행복한 수열의 갯수 반환
 */
public class Main_2 {

    static final int MAX_N = 100;

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

    public static int checkRow(int r) {
        int cnt = 1;
        int res = 0;
        for (int c = 2; c <= n; c++) {
            if (map[r][c - 1] == map[r][c])
                cnt++;
            else
                cnt = 1;
            res = Math.max(res, cnt);
        }

        if (res >= m)
            return 1;
        return 0;
    }

    public static int checkCol(int c) {
        int cnt = 1;
        int res = 0;
        for (int r = 2; r <= n; r++) {
            if (map[r - 1][c] == map[r][c])
                cnt++;
            else
                cnt = 1;
            res = Math.max(res, cnt);
        }

        if (res >= m)
            return 1;
        return 0;
    }

    public static void sol() {

        if (m == 1) {
            System.out.println(n * 2);
            System.exit(0);
        }

        // 행 탐색
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += checkRow(i);
        }

        for (int i = 1; i <= n; i++) {
            ans += checkCol(i);
        }

        System.out.println(ans);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }
}