package Novice_mid.exhaustive_search_2.exhaustive_search_by_object_unit;

import java.io.*;
import java.util.*;

/**
 * 개발자의 순위
 */
public class Main_7 {

    static int k, n;
    static int[][] arr;

    static int[] nums;
    static int[] selected = new int[2];

    static int ans = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        nums = new int[n];
        int val = n;
        for (int i = 0; i < n; i++)
            nums[i] = val--;

    }// end of init

    public static boolean isAllwaysWin() {
        int cnt = 0; // a번 개발자가 b번 개발자보다 더 높은 순위인 경우
        // 각 경기별로
        for (int i = 0; i < k; i++) {
            // a번 개발자
            for (int j = 0; j < n; j++) {
                // b 번 개발자
                for (int k = j + 1; k < n; k++) {
                    // 앞서 예상한 순위와 일치하면 카운트
                    if (selected[0] == arr[i][j] && selected[1] == arr[i][k])
                        cnt++;
                }
            }
        }

        // 모든 경기에서 순위가 높으면 true 리턴
        if (cnt == k)
            return true;
        return false;
    }// end of isAllwaysWin

    // a, b 개발자의 가능한 경우 수, 순서 상관 있음
    public static void func(int depth) {
        if (depth == 2) {
            // 모든 경기에서 항상 a번 개발자가 b번 개발자보다 더 높은 순위인가?
            if (isAllwaysWin()) {
                ans++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            selected[depth] = nums[i];
            func(depth + 1);
        }
    }// end of func

    public static void sol() {
        func(0);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main

}// end of class