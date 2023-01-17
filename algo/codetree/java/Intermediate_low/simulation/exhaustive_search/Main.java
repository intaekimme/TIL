package Intermediate_low.simulation.exhaustive_search;

import java.io.*;
import java.util.*;

/**
 * 최고의 33위치
 */
public class Main {

    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                max = Math.max(max, getCount(i, j));
            }
        }

        System.out.println(max);

    }// end of main

    public static int getCount(int sr, int sc) {
        int cnt = 0;

        for (int r = sr; r < sr + 3; r++) {
            for (int c = sc; c < sc + 3; c++) {
                if (map[r][c] == 1)
                    cnt++;
            }
        }

        return cnt;
    }
}
