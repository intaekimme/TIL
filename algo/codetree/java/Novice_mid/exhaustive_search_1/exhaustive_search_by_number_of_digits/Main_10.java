package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

/**
 * 인접하지 않은 2개의 숫자
 */
public class Main_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) <= 1) // 거리가 1 이내면 덧셈 후 최댓값 비교과정 안함
                    continue;
                max = Math.max(max, arr[i] + arr[j]);
            }
        }

        System.out.println(max);
    }// end of main
}
