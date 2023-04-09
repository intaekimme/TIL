package boj.bruteforce;

import java.io.*;
import java.util.*;

/**
 * 1059 좋은 구간 s4
 * sol
 */

public class Main_1059 {

    static int cnt = 0;

    public static void dfs(int depth, int s, int e, int[] selected, int n) {
        if (depth == 2) {
            for (int i = selected[0]; i <= selected[1]; i++) {
                if (i == n) {
                    // System.out.println(selected[0] + " " + selected[1]);
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

        int[] tmp = new int[L + 1];
        if (arr[0] != 1) {
            for (int i = 1; i < L + 1; i++)
                tmp[i] = arr[i - 1];
            arr = new int[L + 1];
            for (int i = 0; i < L + 1; i++)
                arr[i] = tmp[i];
        }

        int[] selected = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            int s = arr[i];
            int e = arr[i + 1];

            dfs(0, s, e, selected, n);
        }

        System.out.println(cnt);
    }// end of main
}// end of class

// 3
// 7 8 9
// 2