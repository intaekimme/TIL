package complete_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

/**
 * 개발자의 능력 3
 */
public class Main_2 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (i != j && j != k && k != i) {
                        int diff = getDiff(i, j, k);
                        ans = diff < ans ? diff : ans;
                    }
                }
            }
        }

        System.out.println(ans);

    }// end of main

    public static int getDiff(int i, int j, int k) {
        int sum1 = arr[i] + arr[j] + arr[k];

        int sum2 = 0;
        for (int t = 0; t < 6; t++) {
            sum2 += arr[t];
        }
        sum2 -= sum1;
        return Math.abs(sum2 - sum1);
    }

}// end of class
