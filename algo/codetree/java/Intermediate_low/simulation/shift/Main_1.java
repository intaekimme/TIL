package Intermediate_low.simulation.shift;

import java.io.*;
import java.util.*;

/**
 * 컨베이어 벨트
 */
public class Main_1 {

    static int n, t;
    static int[][] belt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        belt = new int[2][n];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    belt[i][j] = Integer.parseInt(st.nextToken());
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    belt[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // t초 동안 수행
        for (int i = 0; i < t; i++) {
            int next = rightShift();
            next = downShift(next);
            next = leftShift(next);
            upShift(next);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    sb.append(belt[i][j]).append(" ");
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    sb.append(belt[i][j]).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());

    }// end of main

    public static int rightShift() {
        int next = belt[0][n - 1];
        for (int i = n - 1; i > 0; i--) {
            belt[0][i] = belt[0][i - 1];
        }
        return next;
    }

    public static int downShift(int before) {
        int next = belt[1][n - 1];
        belt[1][n - 1] = before;
        return next;
    }

    public static int leftShift(int before) {
        int next = belt[1][0];
        for (int i = 0; i < n - 2; i++) {
            belt[1][i] = belt[1][i + 1];
        }
        belt[1][n - 2] = before;
        return next;
    }

    public static void upShift(int before) {
        belt[0][0] = before;
    }
}
