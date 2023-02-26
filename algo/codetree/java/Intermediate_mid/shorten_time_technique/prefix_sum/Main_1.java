package Intermediate_mid.shorten_time_technique.prefix_sum;

import java.io.*;
import java.util.*;

/**
 * 정수 n개의 합 2
 */

public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] prefix_sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i + k <= n; i++) {
            max = Math.max(max, prefix_sum[i + k] - prefix_sum[i]);
        }

        System.out.println(max);

    }// end of main

}// end of class
