package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * 도영이가 만든 맛있는 음식, 2961
 * 
 * 풀이
 * 사용한 재료 수 별 조합생각하기
 * 조합 별 최소 경우 구해서 갱신
 */

public class Main_2961 {

    static final int MAX_N = 10;

    static int n;
    static int[][] ingredients = new int[MAX_N][];
    static int[] selected = new int[MAX_N];

    static int ans = Integer.MAX_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());

            ingredients[i] = new int[] { sour, bitter };
        }

    }// end of init

    public static int cooking(int end) {
        int sour = 1;
        int bitter = 0;
        for (int i = 0; i < end; i++) {
            int[] ingredient = ingredients[selected[i]];

            sour *= ingredient[0];
            bitter += ingredient[1];
        }

        return Math.abs(sour - bitter);
    }// end of cooking

    public static void func(int end, int depth, int start) {
        if (depth == end) {
            ans = Math.min(ans, cooking(end));
            return;
        }

        for (int i = start; i < n; i++) {
            selected[depth] = i;
            func(end, depth + 1, i + 1);
        }
    }

    public static void sol() {
        for (int selected = 1; selected <= n; selected++)
            func(selected, 0, 0);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}// end of class
