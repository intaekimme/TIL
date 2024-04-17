package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

public class Main_5_1 {

    static int N, K;

    static int LEN = 501;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[LEN];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int c_cnt = Integer.parseInt(st.nextToken());

            int pos = Integer.parseInt(st.nextToken());

            arr[pos] += c_cnt;
        }

        int res = Integer.MIN_VALUE;

        for (int i = K; i < LEN - K; i++) {
            int sum = 0;
            for (int j = -K; j <= K; j++) {
                sum += arr[i + j];
            }

            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}
