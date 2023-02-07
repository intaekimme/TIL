package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_under_a_special_condition;

import java.io.*;
import java.util.*;

/**
 * k개 중 하나를 n번 선택하기(conditional)
 * 1차원 윷놀이_가지치기 함
 * 가지치기 안했을 때 : 366ms, 47MB
 * 가지치기 했을 때 : 126ms, 10MB
 */
public class Main_2 {

    static final int MAX_N = 12;
    static final int MAX_K = 4;

    static int n, m, k;

    static int[] turn = new int[MAX_N];
    static int[] horses = new int[MAX_K];

    static int ans = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            turn[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++)
            horses[i] = 1;

    }// end of init

    public static int calc() {
        int score = 0;
        for (int i = 0; i < k; i++)
            score += (horses[i] >= m ? 1 : 0);

        return score;
    }// end of calc

    public static void func(int depth) {
        // 말을 직접 n번 움직이지 않아도
        // 최대가 될 수 있으므로 항상 답을 갱신한다.
        ans = Math.max(ans, calc());

        if (depth == n) {
            return;
        }

        for (int i = 0; i < k; i++) {
            // 이미 결승에 도달한 말은 더이상 움직이지 않는다.
            if (horses[i] >= m)
                continue;

            horses[i] += turn[depth];
            func(depth + 1);
            horses[i] -= turn[depth];
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        init();
        func(0);
        System.out.println(ans);
    }// end of main

}// end of class
