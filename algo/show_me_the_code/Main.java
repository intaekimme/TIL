package show_me_the_code;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, c;
    static int[][] w;
    static int[] a, b;
    static boolean[] visited_a, visited_b;

    public static void main(String[] args) throws IOException {
        init();

        long ans = sol();

        System.out.println(ans);

    }// end of main

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        w = new int[c][c];
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        a = new int[n];
        visited_a = new boolean[n];
        b = new int[m];
        visited_b = new boolean[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
    }// end of init

    public static long sol() {
        long max = Long.MIN_VALUE;
        max = Math.max(max, perm(0, 0));
        return max;
    }// end of sol

    public static long perm(int i, int j) {
        return 0;
    }

}// end of class
