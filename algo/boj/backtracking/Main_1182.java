package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * 부분수열의 합, 1182
 * n개의 정수(음수, 0, 양수)
 * 크기가 양수인 부분수열 중 그 수열 원소 다 더한 값이 S가 되는 경우의 수
 * 
 * 풀이
 * 크기가 1 ~ n인 부분수열 모두 생각
 * 각 크기별 경우는 조합으로 생각
 * 각 조합의 합이 S인 경우 정답 카운트
 * 시간 복잡도 : O(2^n)
 * 1<=n<=20 이므로 최대 약 2^21이므로 시간제한에 문제없음
 */

public class Main_1182 {

    static final int MAX_N = 20;

    static int n, s;
    static int[] arr = new int[MAX_N];
    static int[] selected;

    static int ans = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

    }// end of init

    public static int getSum(int size) {
        int sum = 0;
        for (int i = 0; i < size; i++)
            sum += selected[i];
        return sum;
    }// end of getSum

    public static void func(int depth, int start, int subSequenceSize) {
        if (depth == subSequenceSize) {
            if (s == getSum(subSequenceSize))
                ans++;
            return;
        }

        for (int i = start; i < n; i++) {
            selected[depth] = arr[i];
            func(depth + 1, i + 1, subSequenceSize);
        }
    }// end of func

    public static void sol() {
        for (int cnt = 1; cnt <= n; cnt++) {
            selected = new int[cnt];
            func(0, 0, cnt);
        }
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}// end of class
