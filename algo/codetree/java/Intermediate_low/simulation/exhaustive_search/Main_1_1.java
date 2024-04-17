package Intermediate_low.simulation.exhaustive_search;

import java.io.*;
import java.util.*;

public class Main_1_1 {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isPossible(i, j))
                    continue;
                // 갯수 세기

                res = Math.max(res, count(i, j));
            }
        }

        System.out.println(res);
    }// end of main

    public static boolean isPossible(int r, int c) {
        return r + 3 <= N && c + 3 <= N;
    }// end of isPossible

    public static int count(int r, int c) {
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[r + i][c + j] == 1)
                    cnt++;
            }
        }

        return cnt;
    }// end of count

}// end of class
