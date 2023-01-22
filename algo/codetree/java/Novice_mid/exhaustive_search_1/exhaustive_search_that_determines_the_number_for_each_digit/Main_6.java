package Novice_mid.exhaustive_search_1.exhaustive_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

/**
 * 개발팀의 능력
 * 개발팀의 능력 2와 같은 문제
 */
public class Main_6 {

    static int[] arr = new int[5];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(st.nextToken());
    }// end of init

    public static int sum() {
        int sum = 0;
        for (int i = 0; i < 5; i++)
            sum += arr[i];
        return sum;
    }// end of sum

    public static void sol() {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++)
            for (int j = i + 1; j < 5; j++)

                for (int k = 0; k < 5; k++)
                    for (int l = k + 1; l < 5; l++) {
                        if (k == i || k == j || l == i || l == j)
                            continue;
                        int team1 = arr[i] + arr[j];
                        int team2 = arr[k] + arr[l];
                        int team3 = sum() - (team1 + team2);

                        if (team1 == team2 || team2 == team3 || team1 == team3)
                            continue;

                        int max = Math.max(team1, Math.max(team2, team3));
                        int min = Math.min(team1, Math.min(team2, team3));

                        ans = Math.min(ans, max - min);
                    }

        if (ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
