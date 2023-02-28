package Intermediate_mid.shorten_time_technique.lr_technique;

import java.io.*;
import java.util.*;

/**
 * 미래가 보이는 가위, 바위, 보_fail
 */

public class Main_2 {

    static int n;
    static int ans = 0;
    static char[] input;

    static int[][] l; // 0 : 주먹, 1 : 가위, 2 : 보
    static int[][] r; // 0 : 주먹, 1 : 가위, 2 : 보

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = new char[n];

        for (int i = 0; i < n; i++)
            input[i] = br.readLine().charAt(0);

        l = new int[3][n];
        r = new int[3][n];
    }// end of init

    public static void leftFill() {
        for (int i = 0; i < 3; i++) {
            if ((i == 0 && input[0] == 'S') || (i == 1 && input[0] == 'P') || (i == 2 && input[0] == 'H'))
                l[i][0] = 1;
            for (int j = 1; j <= n - 1; j++) {
                l[i][j] = l[i][j - 1];
                // (주먹, 가위), (가위, 보), (보, 주먹)
                if ((i == 0 && input[j] == 'S') || (i == 1 && input[j] == 'P') || (i == 2 && input[j] == 'H'))
                    l[i][j] += 1;
            } // end of j loop
        } // end of i loop
    }// end of leftFill

    public static void rightFill() {
        for (int i = 0; i < 3; i++) {
            if ((i == 0 && input[n - 1] == 'S') || (i == 1 && input[n - 1] == 'P') || (i == 2 && input[n - 1] == 'H'))
                r[i][n - 1] = 1;
            for (int j = n - 2; j >= 0; j--) {
                r[i][j] = r[i][j + 1];
                // (주먹, 가위), (가위, 보), (보, 주먹)
                if ((i == 0 && input[j] == 'S') || (i == 1 && input[j] == 'P') || (i == 2 && input[j] == 'H'))
                    r[i][j] += 1;
            } // end of j loop
        } // end of i loop
    }// end of rightFill

    public static void sol() {
        leftFill();
        rightFill();

        // for (int i = 0; i < 3; i++) {
        // System.out.println(Arrays.toString(r[i]));
        // }
        // for (int i = 0; i < 3; i++) {
        // System.out.println(Arrays.toString(l[i]));
        // }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    continue;
                for (int k = 0; k <= n - 2; k++)
                    ans = Math.max(ans, l[i][k] + r[j][k + 1]);
            }
        }

        System.out.println(ans);

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main
}
