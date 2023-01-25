package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * n과 m (11), 15665
 * 자연수, 길이 m
 * 중복을 허용하는 원소
 * 중복되는 수열 허용 x
 * 
 * 풀이
 * 순열
 */
public class Main_15665 {
    static final int MAX_N = 8;

    static int n, m;
    static int[] numbers = new int[MAX_N];
    static int[] selected = new int[MAX_N];

    static StringBuilder sb = new StringBuilder();

    public static void func(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(selected[i]).append(" ");
            sb.append("\n");
            return;
        }

        int last_cand = 0;
        for (int cand = 0; cand < n; cand++) {
            if (last_cand == numbers[cand])
                continue;
            selected[depth] = numbers[cand];
            last_cand = numbers[cand];
            func(depth + 1);
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Arrays.fill(numbers, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);

        func(0);

        System.out.print(sb.toString());
    }// end of main
}
