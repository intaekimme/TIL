package boj;

import java.io.*;
import java.util.*;

/**
 * n개의 서로 다른 자연수 15655
 * 수열 오름차순
 * 중복 x
 * 조합
 */
public class Main_15655 {
    static final int MAX_N = 8;
    static int n, m;

    static int[] arr = new int[MAX_N];
    static int[] record = new int[MAX_N];

    static StringBuilder sb = new StringBuilder();

    public static void func(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(record[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            record[depth] = arr[i];
            func(depth + 1, i + 1);
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        func(0, 0);

        System.out.print(sb.toString());
    }// end of main
}
