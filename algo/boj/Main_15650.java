package boj;

import java.io.*;
import java.util.*;

/**
 * n과 m (2) 15650
 * 자연수, 중복 없이 m개
 * 오름차순
 * 
 * 중복없는 조합
 */
public class Main_15650 {
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
            func(depth + 1, i + 1); // 현재 뽑은 수 다음 수부터 뽑기 시작
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
