package Novice_mid.exhaustive_search_3.exhaustive_exploration_by_assuming_the_situation_one_by_one;

import java.io.*;
import java.util.*;

/**
 * 좌표평면 위의 균형 2
 */
public class Main_5 {

    static final int MAX_N = 100;

    static int n;
    static int[] x = new int[MAX_N + 1];
    static int[] y = new int[MAX_N + 1];

    public static int countPoints(int v, int t) {
        int cnt_1 = 0; // 1사분면
        int cnt_2 = 0; // 2사분면
        int cnt_3 = 0; // 3사분면
        int cnt_4 = 0; // 4사분면

        for (int i = 0; i < n; i++) {
            // 1사분면
            if (v < x[i] && y[i] < t)
                cnt_1++;
            // 2사분면
            if (v < x[i] && t < y[i])
                cnt_2++;
            // 3사분면
            if (x[i] < v && t < y[i])
                cnt_3++;
            // 4사분면
            if (x[i] < v && y[i] < t)
                cnt_4++;
        }

        return Math.max(cnt_1, Math.max(cnt_2, Math.max(cnt_3, cnt_4)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 2; i <= 100; i += 2) {
            for (int j = 2; j <= 100; j += 2) {
                ans = Math.min(ans, countPoints(i, j));
            }
        }

        System.out.println(ans);
    }
}
