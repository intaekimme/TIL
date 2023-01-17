package Novice_mid.exhaustive_search_3.exhaustive_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

/**
 * 가장 많이 나온 쌍
 */
public class Main_3 {

    static int n, m;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[m];
        b = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        // n 이하의 수로 만들 수 있는 모든 쌍 (i, j)
        for (int i = 1; i <= n; i++) {
            for (int j = 1 + 1; j <= n; j++) {
                max = Math.max(max, countNum(i, j));
            }
        }

        System.out.println(max);
    }// end of main

    // (first, second) 쌍이 (a[i], b[i]) 혹은 (b[i], a[i])면
    // 갯수 카운트
    public static int countNum(int first, int second) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (a[i] == first && b[i] == second)
                cnt++;
            else if (a[i] == second && b[i] == first)
                cnt++;
        }
        return cnt;
    }

}// end of class
