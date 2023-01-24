package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_simple;

import java.io.*;
import java.util.*;

public class Main_4 {

    static final int MAX_N = 15;
    static final int MAX_LEN = 1000;

    static int n;

    static int[][] lines = new int[MAX_N + 1][]; // 막대 배열
    static int[] record = new int[MAX_N + 1]; // 조합 기록
    static boolean[] visited = new boolean[MAX_N + 1];

    static int ans = Integer.MIN_VALUE;
    static int overlapCnt = Integer.MAX_VALUE;

    public static void countOverlappingLine(int line_cnt) {
        int[] line_records = new int[MAX_N + 1];

        // 겹치는 선분 판별을 위해 뽑은 선분들 기록
        for (int i = 0; i < line_cnt; i++) {
            int line_num = record[i];
            int x1 = lines[line_num][0];
            int x2 = lines[line_num][1];

            for (int x = x1; x <= x2; x++)
                line_records[x]++;
        }

        // 겹치는 선분의 갯수 카운트
        int cnt = 0;
        for (int i = 1; i <= MAX_N; i++)
            if (line_records[i] > 1)
                cnt = Math.max(cnt, line_records[i]);

        overlapCnt = Math.min(overlapCnt, cnt);

        ans = Math.max(ans, line_cnt - overlapCnt);

    }// end of countOverlappingLine

    /**
     * 
     * @param line_cnt 뽑는 막대 수
     * @param depth    재귀 깊이
     * @param start    처음 뽑는 막대
     */
    public static void func(int line_cnt, int depth, int start) {
        if (depth == line_cnt) {
            countOverlappingLine(line_cnt); // 뽑은 선분이 겹치는지 확인하는 함수
            // for (int i : record)
            // System.out.print(i + " ");
            // System.out.println();
            return;
        }

        // 막대 배열 line 인덱스로 조합
        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                record[depth] = i;
                visited[i] = true;
                func(line_cnt, depth + 1, start + 1);
                visited[i] = false;
            }
        }

    }// end of func

    public static void sol() {
        // i : 뽑은 막대 갯수
        for (int i = 1; i <= n; i++)
            func(i, 0, 1);
    }// end of sol

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            lines[i] = new int[] { x1, x2 };
        }
    }// end of init

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main

}// end of class
