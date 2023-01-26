package boj.backtracking;

import java.io.*;

/**
 * N-Queen, 9663
 * 
 * N * N 체스판에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 * 
 * N이 주어졌을 때, 퀸을 노흔 방법의 수 출력
 * 
 * 풀이 3.
 * 행별로 가능한 열 기록
 */

public class Main_9663 {
    static final int MAX_N = 14;

    static int n;
    static int ans = 0;
    // static int call = 0;

    static boolean[] used1;
    static boolean[] used2;
    static boolean[] used3;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        used1 = new boolean[n]; // 열 확인
        used2 = new boolean[2 * n - 1];// / 방향 대각선 확인
        used3 = new boolean[2 * n - 1];// \ 방향 대각선 확인
    }// end of init

    public static void func(int row) {
        // call++;
        if (row == n) {
            ans++;
            return;
        }
        // 호출된 행 별로 가능할 열 표시
        for (int i = 0; i < n; i++) {
            if (used1[i] || used2[row + i] || used3[row - i + n - 1])
                continue;
            used1[i] = true;
            used2[row + i] = true;
            used3[row - i + n - 1] = true;
            func(row + 1);
            used1[i] = false;
            used2[row + i] = false;
            used3[row - i + n - 1] = false;
        }

    }// end of func

    public static void sol() {
        func(0);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
        // System.out.println(call);
    }// end of main
}// end of class
