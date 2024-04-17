package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_10_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                if (j < n)
                    max = Math.max(max, arr[i] + arr[j]);
            }
        }

        System.out.println(max);
    }
}
