package Novice_mid.exhaustive_search_3.exhaustive_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

public class Main_4_1 {

    static int N, K;
    static int[] arr;

    static final int MAX = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        for (int x = 1; x <= MAX; x++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (x <= arr[i] && arr[i] <= x + K)
                    cnt++;
            }
            res = Math.max(res, cnt);
        }

        System.out.println(res);
    }
}
