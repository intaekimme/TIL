package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * 연산자 끼워넣기, 14888
 * n개의 수, n-1개의 연산자
 * 주어진 수의 순서를 바꾸면 안됨
 * 
 * 예, 6개의 수, 5개의 연산자 -> 총 60가지의 식 => 같은 것이 있는 순열 : 5!/2!
 * 
 * 풀이
 * 같은 것이 있는 순열로 문제풀이
 * 연산자 입력이 연산자 갯수로 들어옴
 * (+) : 1, (-) : 2, (*) : 3, (/) : 4로 구분
 * 연산자 배열 크기 : n-1
 * 
 * 같은 것이 있는 순열이므로 이전 후보 기억 후 현재 후보와 같은 경우 순열 생성 중단
 * 연산자 배열 크기만큼 순열 생성 후
 * 식 결과 도출
 * 얻은 결과로 최댓값, 최솟값 갱신
 * 
 */

public class Main_14888 {
    static final int MAX_N = 11;

    static int n;
    static int[] arr = new int[MAX_N];
    static int[] operator = new int[MAX_N - 1];
    static int[] selected = new int[MAX_N - 1];
    static boolean[] used = new boolean[MAX_N - 1];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        // 연산자 결정, (1,+), (2,-), (3,*), (4,/)
        for (int i = 1; i <= 4; i++) {
            int op = Integer.parseInt(st.nextToken()); // 연산자 출연횟수
            for (int j = 0; j < op; j++)
                operator[idx++] = i;
        }

    }// end of init

    // 입력에서 매칭한 연산자 쌍에 매칭해 연산 결과 반환
    public static int calc(int subRes, int operand, int operator) {
        if (operator == 1) // +
            return subRes + operand;
        if (operator == 2) // -
            return subRes - operand;
        if (operator == 3) // *
            return subRes * operand;
        return subRes / operand; // /
    }// end of calc

    // 생성된 순열 바탕으로 연산결과 갱신
    public static void updateResult() {
        int subRes = arr[0];
        for (int i = 1, j = 0; i < n; i++, j++) {
            subRes = calc(subRes, arr[i], selected[j]);
        }

        max = Math.max(max, subRes);
        min = Math.min(min, subRes);
    }// end of getResult

    /*
     * 같은 것이 있는 순열 생성
     */
    public static void func(int depth) {
        if (depth == n - 1) {
            updateResult();
            return;
        }

        int last_cand = 0;
        for (int i = 0; i < n - 1; i++) {
            if (used[i])
                continue;
            if (last_cand == operator[i])
                continue;

            selected[depth] = operator[i];
            last_cand = operator[i];
            used[i] = true;
            func(depth + 1);
            used[i] = false;
        }
    }// end of func

    public static void sol() {
        func(0);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(max);
        System.out.println(min);
    }// end of main
}// end of class
