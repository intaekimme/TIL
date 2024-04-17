package Novice_mid.exhaustive_search_3.exhaustive_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

public class Main_1_1 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[] input = br.readLine().toCharArray();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = input[i] - '0';
        }

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (arr[i] != 0)
                continue;

            arr[i] = 1;

            int dist = Integer.MAX_VALUE;
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (arr[j] != 1)
                    continue;
                for (int k = 0; k < N; k++) {
                    if (j == k)
                        continue;
                    if (arr[k] != 1)
                        continue;

                    tmp = Math.min(Math.abs(j - k), tmp);
                }
                dist = Math.min(dist, tmp);
            }

            res = Math.max(dist, res);

            arr[i] = 0;
        }

        System.out.println(res);
    }// end of main

}// end of class
