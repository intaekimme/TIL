package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

public class Main_2_1 {

    static final int LEN = 10_000 + 1;

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[LEN];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int pos = Integer.parseInt(st.nextToken());
            if ("G".equals(st.nextToken()))
                arr[pos] = 1;
            else
                arr[pos] = 2;
        }

        int res = Integer.MIN_VALUE;

        int i = 1;
        int j = 0;
        try {
            for (i = 1; i < LEN - K; i++) {
                int sum = 0;

                for (j = 0; j <= K; j++) {
                    sum += arr[i + j];
                }

                res = Math.max(res, sum);
            }
        } catch (Exception e) {
            System.out.println(i + ", " + j + ", " + (i + j));
        }

        System.out.println(res);
    }
}
