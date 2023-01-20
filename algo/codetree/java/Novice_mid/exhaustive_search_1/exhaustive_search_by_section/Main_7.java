package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

/**
 * 밭의 높이를 고르게하기
 */
public class Main_7 {
    static final int MAX_N = 100;

    static int n, h, t;
    static int[] arr = new int[MAX_N];
    static int min = Integer.MAX_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }// end of init

    public static void sol() {
        for (int i = 0; i <= n - t; i++) {
            int cost = 0;
            for (int j = i; j < i + t; j++) {
                cost += Math.abs(arr[j] - h);
            }
            min = Math.min(min, cost);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(min);
    }// end of main
}
