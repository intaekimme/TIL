package Novice_high.DP.One_Object_Moving_in_Grid;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[][] { { 9, 6, 1, 5, 3, 7, 8, 5 },
                { 3, 4, 2, 5, 7, 8, 7, 9 },
                { 8, 7, 7, 6, 4, 3, 5, 7 },
                { 3, 6, 8, 9, 5, 7, 7, 9 },
                { 8, 7, 6, 2, 3, 5, 6, 8 },
                { 1, 2, 3, 4, 5, 2, 3, 5 },
                { 9, 8, 7, 6, 8, 3, 4, 5 },
                { 6, 5, 4, 6, 3, 7, 9, 9 } };

        int[][] dp = new int[8][8];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < 8; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }

        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + arr[i][j], dp[i][j - 1] + arr[i][j]);
            }
        }

        for (int i = 0; i < 8; i++)
            System.out.println(Arrays.toString(dp[i]));

        int ans = 0;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                ans = Math.max(ans, dp[i][j]);

        System.out.println(ans);
    }// end of main
}
