package Novice_mid.exhaustive_search_3.exhaustive_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

/**
 * 초기 수열 복원하기 - 시간초과
 */

public class Main_8 {

    static int N;

    static int[] arr;
    static int[] res;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        res = new int[N];
        visited = new boolean[N + 1];

        func(0);

    }// end of main

    public static void func(int depth) {
        if (depth == N) {
            for (int i = 0; i < N - 1; i++) {
                if (res[i] + res[i + 1] != arr[i])
                    return;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(res[i]).append(" ");
            }

            System.out.println(sb.toString());
            System.exit(0);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i])
                continue;

            res[depth] = i;
            visited[i] = true;

            func(depth + 1);

            res[depth] = 0;
            visited[i] = false;
        }
    }
}
