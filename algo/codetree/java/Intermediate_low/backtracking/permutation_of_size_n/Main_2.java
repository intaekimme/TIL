package Intermediate_low.backtracking.permutation_of_size_n;

import java.io.*;

/**
 * 거꾸로 순열
 * 중복제거를 위해 방문배열 사용
 */
public class Main_2 {

    static int n;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void func(int depth) {
        if (depth == n) {
            for (int num : selected)
                sb.append(num).append(" ");
            sb.append("\n");
        }

        for (int i = n; i >= 1; i--) {
            if (visited[i])
                continue;

            selected[depth] = i;
            visited[i] = true;

            func(depth + 1);

            visited[i] = false;
            selected[depth] = 0;
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        selected = new int[n];
        visited = new boolean[n + 1];

        func(0);

        System.out.println(sb.toString());
    }// end of main

}// end of class