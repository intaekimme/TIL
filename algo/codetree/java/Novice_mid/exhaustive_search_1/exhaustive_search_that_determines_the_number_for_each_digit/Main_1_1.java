package Novice_mid.exhaustive_search_1.exhaustive_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

public class Main_1_1 {

    static int N;

    static int[] arr = new int[3];
    static int[] brr = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    brr[0] = i;
                    brr[1] = j;
                    brr[2] = k;

                    if (check(arr, brr))
                        cnt++;
                }
            }
        }

        System.out.println(cnt);
    }// end of main

    public static boolean check(int[] arr, int[] brr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < brr.length; j++) {
                if (i == j && Math.abs(arr[i] - brr[j]) <= 2)
                    return true;
            }
        }
        return false;
    }
}
