package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * n과 m (3) 15651
 * 자연수, m개 고른 수열
 * 중복 허용
 */
public class Main_15651 {

    static final int MAX_N = 7;

    static int n, m;
    static int[] arr = new int[MAX_N];

    static StringBuilder sb = new StringBuilder();

    public static void func(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[cnt] = i;
            func(cnt + 1);
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
}

// 4 2

// 1 1
// 1 2
// 1 3
// 1 4
// 2 1
// 2 2
// 2 3
// 2 4
// 3 1
// 3 2
// 3 3
// 3 4
// 4 1
// 4 2
// 4 3
// 4 4