package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_under_a_special_condition;

import java.io.*;
import java.util.*;

/**
 * k개 중 하나를 n번 선택하기(conditional)
 * 1차원 윷놀이
 */
public class Main_2 {

    static int n, m, k;

    static int[] turn;
    static int[] horses;
    static int[] selected;

    static int ans = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        turn = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            turn[i] = Integer.parseInt(st.nextToken());
        }

        selected = new int[n];

    }// end of init

    public static int calc() {
        horses = new int[k + 1];
        Arrays.fill(horses, 1);

        for (int i = 0; i < n; i++) {
            horses[selected[i]] += turn[i];
        }

        int cnt = 0;
        for (int i = 1; i <= k; i++)
            if (horses[i] >= m)
                cnt++;

        return cnt;
    }// end of calc

    public static void func(int depth) {
        if (depth == n) {
            ans = Math.max(ans, calc());
            return;
        }

        for (int i = 1; i <= k; i++) {
            selected[depth] = i;
            func(depth + 1);
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        init();
        func(0);
        System.out.println(ans);
    }// end of main

}// end of class
