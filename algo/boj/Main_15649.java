package boj;

import java.io.*;
import java.util.*;

/**
 * N과 M (1)
 * 중복 없이 m개를 고른 수열
 * 중복 없는 순열
 */
public class Main_15649 {
    static final int MAX_N = 8;

    static int[] arr = new int[MAX_N + 1];
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void func(int depth) {
        if (depth == m + 1) {
            for (int i = 1; i <= m; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = arr[depth - 1] + 1; i <= n; i++) {
            arr[depth] = i;
            func(depth + 1);
        }

    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(1);

        System.out.print(sb.toString());
    }// end of main
}// end of class
