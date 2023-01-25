package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * n과 m (10) 15664
 * 중복된 원소 존재
 * 자연수, 길이 m
 * 중복되는 수열 허용 x
 * 조합
 * 
 * 풀이
 * 이전에 뽑았던 원소를 기억해 다시 뽑지 않음
 */
public class Main_15664 {
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

        int last_cand = 0;
        for (int cand = start; cand < n; cand++) {
            if (arr[cand] == last_cand)
                continue;
            last_cand = arr[cand];
            record[depth] = arr[cand];
            func(depth + 1, cand + 1);
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        func(0, 0);

        System.out.println(sb.toString());
    }// end of main
}
