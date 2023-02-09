package Intermediate_low.backtracking.permutation_of_size_n;

import java.io.*;
import java.util.*;

/**
 * 수들 중 최솟값 최대화하기
 * 
 * 크기가 n * n인 2차원 격자 내 각 칸에 정수값이 적혀 있음
 * 이때 정확히 n개의 칸에 색칠을 하여 각 행과 열에 정확히 1개의 색칠된 칸만 오도록 하기
 * 색칠된 칸에 적힌 수들 중 최솟값이 최대가 되도록 하기
 * 
 * 풀이
 * 열에 대한 순열을 작성한다.
 * 모든 경우가 나오기에 각 경우에 대해 행을 순회하며 부분 최솟값을 찾는다.
 * 부분 최솟값 중 최대를 계속 갱신한다.
 */
public class Main_5 {

    static final int MAX_N = 10;
    static final int MAX_NUM = 10_000;

    static int n;
    static int ans = 0;

    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static int[] selected = new int[MAX_N];
    static boolean[] visited = new boolean[MAX_N + 1];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
    }// end of init

    // 선택된 경우에 대한 최솟값 반환
    public static int getMin() {
        int min = MAX_NUM + 1;
        for (int r = 1, c = 0; r <= n; r++, c++)
            min = Math.min(min, map[r][selected[c]]);
        return min;
    }// end of getMin

    // 열에 대한 순열 작성
    public static void func(int depth) {
        if (depth == n) {
            ans = Math.max(ans, getMin()); // 최솟값 중 최댓값 갱신
            return;
        }

        // 순열 찾기
        for (int i = 1; i <= n; i++) {
            if (visited[i])
                continue;
            selected[depth] = i;
            visited[i] = true;

            func(depth + 1);

            selected[depth] = 0;
            visited[i] = false;
        }

    }// end of func

    public static void main(String[] args) throws IOException {
        init();

        func(0);

        System.out.println(ans);
    }// end of main

}// end of class