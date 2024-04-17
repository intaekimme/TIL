package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_16_1 {

    static int N, S;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    if (k == i || k == j)
                        continue;
                    sum += arr[k];
                }

                res = Math.min(Math.abs(S - sum), res);
            }
        }

        System.out.println(res);
    }
}
