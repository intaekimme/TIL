package Novice_mid.exhaustive_search_1.exhaustive_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

public class Main_5 {

    static int[] arr;
    static boolean[] visited;
    static int[] team1_arr = new int[2];
    static int[] team2_arr = new int[2];
    static int[] team3_arr = new int[2];

    static int ans = Integer.MAX_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[6];
        visited = new boolean[6];

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

    public static void sol() {
        for (int i = 0; i < 6; i++) {
            if (!visited[i]) {
                team1_arr[0] = arr[i];
                visited[i] = true;
                for (int j = 0; j < 6; j++) {
                    if (!visited[j]) {
                        team1_arr[1] = arr[j];
                        visited[j] = true;
                        for (int k = 0; k < 6; k++) {
                            if (!visited[k]) {
                                team2_arr[0] = arr[k];
                                visited[k] = true;
                                for (int l = 0; l < 6; l++) {
                                    if (!visited[l]) {
                                        team2_arr[1] = arr[l];

                                        int team1 = team1_arr[0] + team1_arr[1];
                                        int team2 = team2_arr[0] + team2_arr[1];
                                        int team3 = sum() - (team1 + team2);

                                        int max = Math.max(team1, Math.max(team2, team3));
                                        int min = Math.min(team1, Math.min(team2, team3));

                                        ans = Math.min(ans, max - min);
                                    }
                                } // end of l
                                visited[k] = false;
                            }
                        } // end of k
                        visited[j] = false;
                    }
                } // end of j
                visited[i] = false;
            }
        } // end of i

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}
