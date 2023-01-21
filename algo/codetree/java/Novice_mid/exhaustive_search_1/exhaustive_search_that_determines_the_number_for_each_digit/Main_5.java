package Novice_mid.exhaustive_search_1.exhaustive_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

public class Main_5 {

    static int[] arr;
    static boolean[] visited;
    static int[] record = new int[3];
    static int[] team = new int[2];

    static int idx = 0;
    static int team_cnt = 0;
    static int cnt = 0;

    static int ans = Integer.MAX_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[6];
        visited = new boolean[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }// end of init

    public static void sol() {
        func(0);
    }// end of sol

    /**
     * 조합 코드를 잘못짠 거 같음
     */
    public static void func(int start) {
        if (cnt == 2) {
            cnt = 0;
            team_cnt++;
            record[idx++] = team[0] + team[1];

            System.out.print("(" + team[0] + ", " + team[1] + ") ");

            if (team_cnt == 3) {
                System.out.println();
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < 3; i++)
                    max = Math.max(max, record[i]);
                for (int i = 0; i < 3; i++)
                    min = Math.min(min, record[i]);

                ans = Math.min(ans, max - min);

                idx = 0;
                team_cnt = 0;
            }
            return;
        }

        for (int i = start; i < 6; i++) {
            team[cnt++] = arr[i];
            func(i + 1);
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}
