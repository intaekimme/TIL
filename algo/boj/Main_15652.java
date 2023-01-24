package boj;

import java.io.*;
import java.util.*;

/**
 * 15652 n과 m (4)
 * 자연수, m개를 고른 수열
 * 중복 허용, 비내림차순, 단조 증가(같아도 됨)
 */
public class Main_15652 {

    static final int MAX_N = 8;
    static int n, m;

    static int[] arr = new int[MAX_N];

    static StringBuilder sb = new StringBuilder();

    public static void func(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            func(depth + 1, i);
        }
    }// end of func

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0, 1);

        System.out.print(sb.toString());
    }// end of main
}// end of class

// 4 2

// 1 1
// 1 2
// 1 3
// 1 4
// 2 2
// 2 3
// 2 4
// 3 3
// 3 4
// 4 4