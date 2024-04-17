package boj.backtracking.re1;

import java.io.*;
import java.util.*;

/**
 * 24.4.17 N과 M (1)
 */
public class Main_15649 {

    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1];

        func(0, 1);
    }// end of main

    public static void func(int depth, int start) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }

            System.out.println(sb.toString());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                func(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }// end of func

}// end of class