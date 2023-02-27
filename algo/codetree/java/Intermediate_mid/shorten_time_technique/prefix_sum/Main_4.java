package Intermediate_mid.shorten_time_technique.prefix_sum;

import java.io.*;
import java.util.*;

/**
 * 연속한 k개의 숫자 - 메모리 초과 코드
 * 
 * 범위
 * 1 ≤ B, K ≤ N
 * 1 ≤ N ≤ 100,000
 * 
 * 시간 복잡도, O(N^3)
 */

public class Main_4 {

    static int n, k, b;
    static int[] arr, records, selected, prefix_sum;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        records = new int[b];
        Arrays.fill(arr, 1);

        for (int i = 0; i < b; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[val] = 0;
            records[i] = val;
        }

    }// end of init

    public static void func(int depth, int start, int end) {
        if (depth == end) {
            prefix_sum = getPrefixSum();

            if (hasContinousK()) {
                System.out.println(end);
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < b; i++) {
            selected[depth] = records[i];
            func(depth + 1, i + 1, end);
        }
    }// end of func

    public static int[] getPrefixSum() {
        int[] res = new int[n + 1];

        for (int i = 0; i < selected.length; i++)
            arr[selected[i]] = 1;

        for (int i = 1; i <= n; i++) {
            if (arr[i] != 0)
                res[i] = res[i - 1] + arr[i];
            else
                res[i] = 0;
        }

        for (int i = 0; i < selected.length; i++)
            arr[selected[i]] = 0;

        return res;
    }// end of getPrefixSum

    public static boolean hasContinousK() {
        for (int i = 1; i <= n; i++)
            if (prefix_sum[i] == k)
                return true;
        return false;
    }// end of hasContinousK

    public static void sol() {
        // 채우는 수의 갯수
        for (int i = 1; i <= b; i++) {
            selected = new int[i];
            func(0, 0, i);
        }
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class