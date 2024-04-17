package boj.backtracking.re1;

import java.io.*;
import java.util.*;

/**
 * 24.04.18 연산자 끼워넣기 (2)
 */
public class Main_15658 {

    static int N;
    static int[] num, op; // N개의 자연수 입력, 연산자 갯수 입력
    static int[] arr; // 연산자 순열

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        num = new int[N];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        func(1);

        System.out.println(max);
        System.out.println(min);
    }// end of main

    public static void func(int depth) {
        if (depth == N) {
            max = Math.max(max, calc());
            min = Math.min(min, calc());
            return;
        }

        for (int idx = 0; idx < 4; idx++) {
            if (op[idx] > 0) {
                arr[depth] = idx;
                op[idx]--;
                func(depth + 1);
                op[idx]++;
            }
        }
    }// end of func

    public static int calc() {
        int res = num[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] == 0)
                res += num[i];
            else if (arr[i] == 1)
                res -= num[i];
            else if (arr[i] == 2)
                res *= num[i];
            else
                res /= num[i];
        }

        return res;
    }
}// end of class
