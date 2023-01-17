package Novice_mid.exhaustive_search_2.exhaustive_search_by_value;

import java.io.*;
import java.util.*;

/**
 * 숫자들의 합 중 최대
 * 자리수를 계속 잘라서 누적한다.
 * 반복문과 재귀를 이용할 수 있다
 */
public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int ans = 0;

        long before_time1 = System.currentTimeMillis();
        for (int i = x; i <= y; i++) {
            ans = Math.max(ans, getSum1(i));
        }
        long after_time1 = System.currentTimeMillis();

        long before_time2 = System.currentTimeMillis();
        for (int i = x; i <= y; i++) {
            ans = Math.max(ans, getSum2(i));
        }
        long after_time2 = System.currentTimeMillis();

        System.out.printf("%d %d", after_time1 - before_time1, after_time2 - before_time2);
    }// end of main

    public static int getSum1(int n) {
        int sum = 0;
        while (n >= 1) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }// end of getSum1

    public static int getSum2(int n) {
        if (n < 10)
            return n;
        return getSum2(n / 10) + n % 10;
    }// end of getSum2

}// end of class

/**
 * 1 10000000
 * 108 78
 * while 보다 재귀가 빠르다
 */