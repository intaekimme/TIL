package Intermediate_mid.shorten_time_technique.prefix_sum;

import java.io.*;
import java.util.*;

/**
 * 정수 n개의 합 3
 * 격자 사이즈 설정시 -1 해줘야 함. 여기서는 입력에서 -1 처리함
 */

public class Main_2 {

    static int[][] arr;
    static int[][] prefix_sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[n + 1][n + 1];
        prefix_sum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // printArr(arr);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefix_sum[i][j] = arr[i][j] + prefix_sum[i - 1][j] + prefix_sum[i][j - 1] - prefix_sum[i - 1][j - 1];
            }
        }

        // System.out.println();
        // printArr(prefix_sum);

        int max = 0;

        for (int i = 1; i + k <= n; i++) {
            for (int j = 1; j + k <= n; j++) {
                int sub_sum = prefix_sum[i + k][j + k] - prefix_sum[i - 1][j + k] - prefix_sum[i + k][j - 1]
                        + prefix_sum[i - 1][j - 1];
                max = Math.max(max, sub_sum);
                // System.out.print(sub_sum + " ");
            }
            // System.out.println();
        }

        System.out.println(max);

    }// end of main

    public static void printArr(int[][] array) {
        for (int i = 1; i < array.length; i++)
            System.out.println(Arrays.toString(array[i]));
    }

}// end of class
