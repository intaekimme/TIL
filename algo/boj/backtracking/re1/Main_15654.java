package boj.backtracking.re1;

import java.io.*;
import java.util.*;

public class Main_15654 {

    static final int MAX = 10_000 + 1;

    static int N, M;
    static int[] input, arr;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        arr = new int[M];
        visited = new boolean[MAX];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        func(0);

        System.out.print(sb.toString());
    }// end of main

    public static void func(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[input[i]]) {
                arr[depth] = input[i];
                visited[input[i]] = true;
                func(depth + 1);
                visited[input[i]] = false;
            }
        }
    }
}//
