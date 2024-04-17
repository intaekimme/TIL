package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

/**
 * 한 자리를 정하여 완전탐색 연습문제
 */
public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int dist = 0;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dist += arr[j] * (Math.abs(i - j));
                }
            }

            if (dist < res)
                res = dist;
        }

        System.out.println(res);
    }
}
