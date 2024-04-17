package Novice_mid.exhaustive_search_1.exhaustive_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

public class Main_2_1 {

    static int[] arr = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (i != j && j != k && i != k) {
                        int team1 = arr[i] + arr[j] + arr[k];
                        int team2 = sum - team1;

                        diff = Math.min(diff, Math.abs(team1 - team2));
                    }
                }
            }
        }

        System.out.println(diff);
    }// end of main
}
