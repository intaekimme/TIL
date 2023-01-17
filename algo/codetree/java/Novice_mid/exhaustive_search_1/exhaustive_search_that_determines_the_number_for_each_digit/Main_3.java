package Novice_mid.exhaustive_search_1.exhaustive_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

/**
 * 다이얼 한 조합을 고르고, 그 조합이 기존 조합과 거리가 2이내인지 확인
 */
public class Main_3 {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // 모든 자리가 주어진 첫 조합과의 거리가 2 이내인지 확인합니다.
                    if ((Math.abs(a - i) <= 2 || Math.abs(a - i) >= n - 2)
                            && (Math.abs(b - j) <= 2 || Math.abs(b - j) >= n - 2) &&
                            (Math.abs(c - k) <= 2 || Math.abs(c - k) >= n - 2))
                        ans++;

                    // 모든 자리가 주어진 두번째 조합과의 거리가 2 이내인지 확인합니다.
                    else if ((Math.abs(a2 - i) <= 2 || Math.abs(a2 - i) >= n - 2)
                            && (Math.abs(b2 - j) <= 2 || Math.abs(b2 - j) >= n - 2) &&
                            (Math.abs(c2 - k) <= 2 || Math.abs(c2 - k) >= n - 2))
                        ans++;
                }
            }
        }

        System.out.println(ans);

    }// end of main

}// end of class
