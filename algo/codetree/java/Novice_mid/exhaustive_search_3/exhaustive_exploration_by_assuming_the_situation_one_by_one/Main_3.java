package Novice_mid.exhaustive_search_3.exhaustive_exploration_by_assuming_the_situation_one_by_one;

import java.io.*;

/**
 * 수를 여러번 사용하여 특정 수 만들기
 */

public class Main_3 {

    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        C = Integer.parseInt(input[2]);

        int ans = 0;

        // A와 B를 사용하는 모든 경우
        for (int i = 0; i <= C / A; i++) {
            for (int j = 0; j <= C / B; j++) {
                if (A * i + B * j <= C)
                    ans = Math.max(ans, A * i + B * j);
            }
        }

        System.out.println(ans);
    }
}