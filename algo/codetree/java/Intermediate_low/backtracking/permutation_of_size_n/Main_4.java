package Intermediate_low.backtracking.permutation_of_size_n;

import java.io.*;
import java.util.*;

/**
 * 외판원 순회
 * 
 * 1번 지점에서 출발하여 모든 지점을 정확히 딱 한 번씩만 방문하고 다시 1번 지점으로 돌아오려고 함.
 * i번 지점에서 j번 지점으로 이동하는데 드는 비용 정보 Aij가
 * 주어졌을 때 모든 정점을 겹치지 않게 방문하고 되돌아오는데 필요한 최소 비용의 합 구하기
 * 
 * 풀이 1
 * 순회 경우의 수 뽑을 때 가지치기를 하지 않고 뽑는 경우
 */
public class Main_4 {

    static final int MAX_N = 10;
    static final int MAX_NUM = 10_000;

    static int n;
    static int ans = Integer.MAX_VALUE;

    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static int[] selected = new int[MAX_N + 2];
    static boolean[] visited = new boolean[MAX_N + 2];

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

    public static int getMinCost() {
        // System.out.print(Arrays.toString(selected) + " ");
        int cost = 0;
        int start = 1;
        int end = selected[1];

        // 비용이 0으로 불가능 한 경우
        if (map[start][end] == 0)
            return Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            // 비용이 0으로 불가능한 경우
            if (map[start][end] == 0)
                return Integer.MAX_VALUE;
            // System.out.print(map[start][end] + " ");
            cost += map[start][end];
            start = selected[i];
            end = selected[i + 1];
        }
        // System.out.println(cost);
        return cost;
    }// end of getMinCost

    public static void func(int start) {
        if (start == n + 1) {
            // System.out.println(Arrays.toString(selected));
            // 다시 출발지로 돌아올때만 갱신
            if (selected[n] == 1) {
                ans = Math.min(ans, getMinCost());
            }
            return;
        }

        for (int end = 1; end <= n; end++) {
            if (visited[end])
                continue;
            selected[start] = end;
            visited[end] = true;

            func(start + 1);

            visited[end] = false;
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        init();

        func(1);

        System.out.println(ans);
    }// end of main

}// end of class
