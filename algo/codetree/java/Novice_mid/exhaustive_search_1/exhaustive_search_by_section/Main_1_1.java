package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

public class Main_1_1 {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N - K + 1; i++) {
            int sum = 0;
            for (int j = 0; j < K; j++) {
                sum += arr[i + j];
            }
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }
}
