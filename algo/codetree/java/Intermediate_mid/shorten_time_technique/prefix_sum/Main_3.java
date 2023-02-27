package Intermediate_mid.shorten_time_technique.prefix_sum;

import java.io.*;
import java.util.*;

/**
 * 부분 수열의 합이 k
 */

public class Main_3 {

    static int n, k;
    static int[] arr, prefix_sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        prefix_sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }

        int ans = 0;
        // n번째 요소 : [1, n]
        for (int i = 0; i <= n; i++) {
            // 구간합의 길이(j) : [0, n-1]
            for (int j = 0; i + j <= n; j++) {
                // System.out.print("(" + i + ", " + j + ") / ");
                if (prefix_sum[i + j] - prefix_sum[i] == k)
                    ans++;
            }
            // System.out.println();
        }

        System.out.println(ans);

    }
}