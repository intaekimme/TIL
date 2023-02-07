package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_simple;

import java.io.*;

/**
 * 알파벳과 사칙연산
 */
public class Main_7 {

    static final int MAX_ALPH = 6;

    static String input;
    static int alph, res, ans;
    static int[] selected = new int[MAX_ALPH];
    static boolean[] visited = new boolean[MAX_ALPH];
    static char[] op;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            int cur = input.charAt(i) - 'a';
            if (cur < 0 || cur > 5)
                continue;
            if (!visited[cur]) {
                visited[cur] = true;
            }
        }

        op = new char[input.length() - alph];

        int op_idx = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/')
                op[op_idx++] = input.charAt(i);
        }
        res = 0;
        ans = 0;

    }// end of init

    public static void calc() {
        res = selected[input.charAt(0) - 'a'];

        int num_idx = 2;
        for (int i = 0; i < op.length; i++) {
            if (op[i] == '+')
                res += selected[input.charAt(num_idx) - 'a'];
            if (op[i] == '-')
                res -= selected[input.charAt(num_idx) - 'a'];
            if (op[i] == '*')
                res *= selected[input.charAt(num_idx) - 'a'];
            if (op[i] == '/')
                res /= selected[input.charAt(num_idx) - 'a'];
            num_idx += 2;
        }

    }// end of calc

    public static void func(int depth) {
        if (depth == MAX_ALPH) {
            calc();
            ans = Math.max(ans, res);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            if (!visited[depth]) {
                func(depth + 1);
                continue;
            }
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