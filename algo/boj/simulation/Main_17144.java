package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 미세먼지 안녕
 * 17144, g4
 * 
 */

public class Main_17144 {

    static int R, C, T;
    static int[][] map;

    static int[] up = new int[2];
    static int[] down = new int[2];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        int val_cnt = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == -1) {
                    if (val_cnt == 0)
                        up = new int[] { i, j };
                    else
                        down = new int[] { i, j };
                }
                map[i][j] = val;
            }
        }
    }// end of init

    public static void simulation() {
        while (T-- > 0) {

        }
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();

    }// end of main
}// end of class
