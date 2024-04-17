package boj.backtracking.re1;

import java.io.*;
import java.util.*;

public class Main_15652 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        func(0, 1);

        System.out.print(sb.toString());
    }// end of main

    public static void func(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            func(depth + 1, i);
        }
    }// end of func

}// end of class
