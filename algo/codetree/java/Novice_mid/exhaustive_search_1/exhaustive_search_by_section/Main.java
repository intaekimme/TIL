package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

/**
 * 바구니 안의 사탕 2
 * 문제 잘 읽자
 * 구간이 바구니가 놓일 수 있는 범위 벗어나면 안된다는 말 없었음
 * 바구니가 놓일 수 있는 범위 내에 존재하는 바구니가 구간 안에 존재하면 그냥 카운트
 */

public class Main {

    // 0 <= k <= 200
    // 0 <= 바구니 위치 <= 100
    // -200 <= 바구니 위치 - k <= -100
    // 200 <= 바구니 위치 + k <= 300
    static final int MAX_LEN = 500; // 0 <= n + k <= 500;

    static int n, k;
    static int[] arr = new int[MAX_LEN + 1];
    static int max = Integer.MIN_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            arr[pos] += candy;
        }

    }// end of init

    public static void sol() {

        for (int c = 0; c < MAX_LEN; c++) {
            if (c - k < 0 || c + k >= MAX_LEN)
                continue;
            int sum = 0;
            for (int x = c - k; x <= c + k; x++)
                sum += arr[x];
            max = Math.max(max, sum);
        }
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(max);
    }// end of main
}
