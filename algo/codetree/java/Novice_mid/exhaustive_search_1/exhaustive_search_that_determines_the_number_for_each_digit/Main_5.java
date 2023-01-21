package Novice_mid.exhaustive_search_1.exhaustive_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

/**
 * 개발자의 능력 2
 * 정답 코드
 */
public class Main_5 {

    static int[] arr;
    static int ans = Integer.MAX_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }// end of init

    public static int sum() {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void updateMin(int i, int j, int k, int l) {
        int team1 = arr[i] + arr[j];
        int team2 = arr[k] + arr[l];
        int team3 = sum() - (team1 + team2);

        int max = Math.max(team1, Math.max(team2, team3));
        int min = Math.min(team1, Math.min(team2, team3));

        ans = Math.min(ans, max - min);
    }// end of updateMin

    public static void sol() {
        int cnt = 0;
        for (int i = 0; i < 6; i++)
            for (int j = i + 1; j < 6; j++)

                for (int k = 0; k < 6; k++)
                    for (int l = k + 1; l < 6; l++) {
                        if (k == i || k == j || l == i || l == j)
                            continue;
                        updateMin(i, j, k, l);
                        cnt++;
                    }

        System.out.println(cnt);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        // double start = System.currentTimeMillis();
        sol();
        // double end = System.currentTimeMillis();
        System.out.println(ans);
        // System.out.println(ans + " " + (end - start));
    }// end of main
}
