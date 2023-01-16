package complete_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;
import java.lang.Math;

/**
 * 한 가지로 열리는 자물쇠
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] comb = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            comb[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        // 모든 조합을 다 만들어 본다
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // 한 자리라도 주어진 조합과의 거리가 2 이내인지 확인한다
                    if (check(i, comb[0]) || check(j, comb[1]) || check(k, comb[2]))
                        ans++;
                }
            }
        }

        System.out.println(ans);

    }// end of main

    // 두 수의 차가 2이내인지 확인하는 함수
    public static boolean check(int n, int m) {
        return Math.abs(n - m) <= 2;
    }

}// end of class
