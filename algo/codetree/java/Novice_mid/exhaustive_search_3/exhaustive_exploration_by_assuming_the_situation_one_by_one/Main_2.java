package Novice_mid.exhaustive_search_3.exhaustive_exploration_by_assuming_the_situation_one_by_one;

import java.io.*;
import java.util.*;

/**
 * 숫자 2배 후 하나 제거하기
 * 
 */

public class Main_2 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        // 2배할 숫자 하나 선택
        for (int i = 0; i < n; i++) {
            arr[i] *= 2; // 해당 원소 2배

            // 하나의 제거할 숫자 선택
            for (int j = 0; j < n; j++) {
                // 남은 숫자 담을 배열, length : n - 1, index_upper_bound : n - 2
                int[] remainingArr = new int[n - 1];
                // 남은 숫자 담기
                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (j == k)
                        continue;
                    remainingArr[idx++] = arr[k];
                } // end of fork

                // 차이 합 구하기
                int sumDiff = 0;
                for (int k = 0; k < n - 2; k++) {
                    sumDiff += Math.abs(remainingArr[k + 1] - remainingArr[k]);
                } // end of fork

                min = sumDiff < min ? sumDiff : min;
            } // end of forj

            arr[i] /= 2; // 해당 원소 초기화
        } // end of fori

        System.out.println(min);

    }// end of main

}// end of class
