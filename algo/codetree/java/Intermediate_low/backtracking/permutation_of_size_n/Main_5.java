package Intermediate_low.backtracking.permutation_of_size_n;

import java.io.*;
import java.util.*;

public class Main_5 {

    static final int MAX_N = 10;

    static int n;
    static int ans = 0;

    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static int[] selected = new int[MAX_N];
    static boolean[] visited = new boolean[MAX_N + 1];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
    }// end of init

    public static func(int depth) {
        if(depth == n) {
            something();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(visited[i])
                continue;
            selected[depth] = i;
            visited[i] = true;

            func(depth + 1);

            selected[depth] = 0;
            visited[i] = false;
        }

    }// end of func

    public static void main(String[] args) throws IOException {
        init();

        func(0);
    }
}
