package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_16 {
    static final int MAX_N = 100;

    static int n, s;
    static int[] arr = new int[MAX_N];
    static int[] record = new int[MAX_N - 2];
    static int min = Integer.MAX_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

    }// end of init

    public static void func(int cnt, int start) {
        if (cnt == n - 2) {
            int sum = 0;
            for (int val : record)
                sum += val;
            min = Math.min(min, Math.abs(s - sum));
            return;
        }

        for (int i = start; i < n; i++) {
            record[cnt] = arr[i];
            func(cnt + 1, i + 1);
        }
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();

        func(0, 0);

        System.out.println(min);
    }// end of main

}// end of class
