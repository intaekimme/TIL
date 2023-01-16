package complete_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

/**
 * 가장 작은 x 찾기
 */
public class Main_2 {

    static int n;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 가능한 조건의 최댓값이 10_000
        int ans = Integer.MAX_VALUE;
        for (int x = 1; x <= 5000; x++) {
            int t = x;
            boolean isValid = true;
            for (int j = 0; j < n; j++) {
                if (a[j] > 2 * t || 2 * t > b[j]) {
                    isValid = false;
                    break;
                }
                t *= 2;
            }
            if (isValid)
                ans = x < ans ? x : ans;
        }

        System.out.println(ans);

    }// end of main

}// end of class