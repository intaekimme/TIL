package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_under_a_special_condition;

import java.util.Scanner;

public class Main {
    static int n;
    static char[] result;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        result = new char[n];

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            System.out.println(result);
            if (cnt == 1)
                System.exit(0);
            return;
        }

        result[depth] = '4';
        if (check(depth)) {
            dfs(depth + 1);
        }

        result[depth] = '5';
        if (check(depth)) {
            dfs(depth + 1);
        }

        result[depth] = '6';
        if (check(depth)) {
            dfs(depth + 1);
        }
    }

    private static boolean check(int depth) {
        int len = depth + 1 >> 1;
        for (int i = 1; i <= len; i++) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (result[depth - j] != result[depth - i - j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return false;
            }
        }
        return true;
    }
}
