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

    static int[] arr = new int[MAX_N];
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void func(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = arr[depth] + 1; i <= n; i++) {
            // arr[depth] = i;
            // func(depth + 1, i + 1);
            arr[depth] = i;
            func(depth + 1);
        }

    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0);

        System.out.print(sb.toString());
    }// end of main
}// end of class
