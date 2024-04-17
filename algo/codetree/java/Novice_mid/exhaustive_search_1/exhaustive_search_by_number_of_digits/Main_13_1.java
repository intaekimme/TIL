package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_13_1 {

    static final int MAX_LEN = 19;
    static int[][] map = new int[MAX_LEN][MAX_LEN];

    public static void main(String[] argsr) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < MAX_LEN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAX_LEN; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] res = new int[3];

        for (int i = 0; i < MAX_LEN; i++) {
            for (int j = 0; j < MAX_LEN; j++) {
                if (map[i][j] == 0)
                    continue;
                if (res[0] != 0)
                    break;
                res = findBingGo(i, j, map[i][j]);
            }
        }

        if (res[0] == 0)
            System.out.println(res[0]);
        else {
            System.out.println(res[0]);
            System.out.println(res[1] + " " + res[2]);
        }
    }// end of main

    public static int[] findBingGo(int x, int y, int dol) {
        int[] res = new int[3];

        boolean isWidth = true;
        boolean isHeight = true;
        boolean isDownCross = true;
        boolean isUpCross = true;

        // width
        for (int i = 0; i < 5; i++) {
            if (y + i >= MAX_LEN) {
                isWidth = false;
                continue;
            }
            if (map[x][y + i] != dol) {
                isWidth = false;
                continue;
            }
        }
        if (isWidth) {
            res[0] = dol;
            res[1] = x + 1;
            res[2] = (y + 1) + 2;
        }

        // height
        for (int i = 0; i < 5; i++) {
            if (x + i >= MAX_LEN) {
                isHeight = false;
                continue;
            }
            if (map[x + i][y] != dol) {
                isHeight = false;
                continue;
            }
        }
        if (isHeight) {
            res[0] = dol;
            res[1] = (x + 1) + 2;
            res[2] = y + 1;
        }

        // down Cross
        for (int i = 0; i < 5; i++) {
            if (x + i >= MAX_LEN || y + i >= MAX_LEN) {
                isDownCross = false;
                continue;
            }
            if (map[x + i][y + i] != dol) {
                isDownCross = false;
                continue;
            }
        }
        if (isDownCross) {
            res[0] = dol;
            res[1] = (x + 1) + 2;
            res[2] = (y + 1) + 2;
        }

        // up Cross
        for (int i = 0; i < 5; i++) {
            if (x - i <= 0 || y + i >= MAX_LEN) {
                isUpCross = false;
                continue;
            }
            if (map[x - i][y + i] != dol) {
                isUpCross = false;
                continue;
            }
        }
        if (isUpCross) {
            res[0] = dol;
            res[1] = (x + 1) - 2;
            res[2] = (y + 1) + 2;
        }

        return res;
    }
}// end of class