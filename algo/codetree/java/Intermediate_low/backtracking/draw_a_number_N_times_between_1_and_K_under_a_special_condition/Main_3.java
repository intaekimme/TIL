package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_under_a_special_condition;

import java.io.*;
import java.util.*;

public class Main_3 {

    static final int MAX_N = 80;
    static final int[] arr = new int[] { 4, 5, 6 };

    static int n;
    static int[] selected = new int[MAX_N];

    static String ans;
    static String res;

    public static String makeString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(selected[i]);
        return sb.toString();
    }// end of makeString

    public static boolean isValid() {
        String arr = makeString();

        for (int i = 1; i <= n / 2; i++) {
            for (int j = 0; j <= n - 2 * i; j++) {
                if (arr.substring(j, j + i).equals(arr.substring(j + i, j + (2 * i)))) {
                    return false;
                }
            }
        }
        res = arr;
        return true;
    }// end of isValid

    public static void func(int depth) {
        if (depth == n) {
            if (isValid()) {
                if (res.compareTo(ans) < 0)
                    ans = res;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (depth >= 1 && selected[depth - 1] == arr[i])
                continue;
            selected[depth] = arr[i];
            func(depth + 1);
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(6);
        ans = sb.toString();

        func(0);

        System.out.println(ans);
    }// end of main

}// end of class