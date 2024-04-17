package boj.backtracking.re1;

import java.io.*;
import java.util.*;

public class Main_15650 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

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

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            func(depth + 1, i + 1);
        }
    }// end of func

}
