package Novice_mid.exhaustive_search_2.exhaustive_search_by_object_unit;

import java.io.*;
import java.util.*;

/**
 * 스승의 은혜 2
 */
public class Main_5 {

    static final int MAX_N = 1000;
    static int n, b;
    static int[] p;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(p); // 오름차순 정렬

        // 할인할 선물 하나 선택
        for (int i = 0; i < n; i++) {

            int tmp_b = b;
            int cnt = 0;
            // 예산안에서
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (tmp_b - p[j] >= 0) {
                        tmp_b -= p[j];
                        cnt++;
                    }
                } else {
                    if (tmp_b - (p[j] / 2) >= 0) {
                        tmp_b -= p[j] / 2;
                        cnt++;
                    }
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);

    }// end of main

}// end of class