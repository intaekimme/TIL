package boj.bruteforce;

import java.io.*;
import java.util.*;

/**
 * 1059 좋은 구간 s4
 * fail
 */

public class Main_1059 {

    static int cnt = 0;

    public static void dfs(int depth, int s, int e, int[] selected, int n) {
        if (depth == 2) {
            for (int i = selected[0]; i <= selected[1]; i++) {
                if (i == n) {
                    cnt++;
                    return;
                }
            }
            return;
        }

        for (int cand = s + 1; cand < e; cand++) {
            selected[depth] = cand;
            dfs(depth + 1, cand, e, selected, n);
        }
    }// end of dfs

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int[] selected = new int[2];
        for (int i = 0; i < L - 1; i++) {
            int s = arr[i];
            int e = arr[i + 1];

            dfs(0, s, e, selected, n);
        }

        System.out.println(cnt);
    }// end of main
}// end of class
