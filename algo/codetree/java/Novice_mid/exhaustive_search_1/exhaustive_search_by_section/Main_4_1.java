package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

public class Main_4_1 {

    static final int LEN = 100 + 1;

    static int N, M;

    static int[] arr;
    static int[] brr;

    static int[] check;

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        brr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - M + 1; i++) {
            check = new int[LEN];
            for (int j = 0; j < M; j++) {
                check[arr[i + j]] = 1;
            }

            if (isMatch()) {
                cnt++;
            }
        }

        System.out.println(cnt);

        // func(0, 0);
    }// end of main

    public static boolean isMatch() {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (check[brr[i]] >= 1) {
                check[brr[i]]--;
                cnt++;
            }
        }
        if (cnt == M)
            return true;
        return false;
    }

    // 조합을 잘못설계
    /**
     * public static void func(int idx, int start) {
     * if (idx == M) {
     * System.out.println(Arrays.toString(crr));
     * // check();
     * return;
     * }
     * 
     * for (int i = start; i < M; i++) {
     * crr[idx] = brr[i];
     * func(idx + 1, i + 1);
     * }
     * }// end of func
     * 
     * public static void check() {
     * for (int i = 0; i < N - M; i++) {
     * boolean flag = true;
     * for (int j = 0; j <= M; j++) {
     * if (arr[i + j] != crr[i + j]) {
     * flag = false;
     * break;
     * }
     * }
     * if (flag)
     * cnt++;
     * }
     * }
     */
}
