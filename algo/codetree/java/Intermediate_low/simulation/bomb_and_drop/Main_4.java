package Intermediate_low.simulation.bomb_and_drop;

import java.io.*;
import java.util.*;

public class Main_4 {

    static int[][] tmpMap = new int[4][4];
    static int[][] map = new int[4][4];
    static int[][] cnt = new int[4][4];

    static String strDir;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                tmpMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        strDir = br.readLine();
        int x = 0;
        int y = 0;
        switch (strDir) {
            case "L":
                x = 3;
                for (int i = 3; i >= 0; i--, x--) {
                    for (int j = 3; j >= 0; j--, y++) {
                        map[x][y] = tmpMap[j][i];
                    }
                    y = 0;
                }
                break;
            case "R":
                for (int j = 3; j >= 0; j--, x++) {
                    for (int i = 0; i < 4; i++, y++) {
                        map[x][y] = tmpMap[i][j];
                    }
                    y = 0;
                }
                break;
            case "U":
                x = 3;
                for (int i = 0; i < 4; i++, x--) {
                    for (int j = 3; j >= 0; j--, y++) {
                        map[x][y] = tmpMap[i][j];
                    }
                    y = 0;
                }
                break;
            case "D":
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        map[i][j] = tmpMap[i][j];
                    }
                }
                break;
        }// end of switch
         // 입력 완료

        // 중력 작용 시작
        tmpMap = new int[4][4];
        for (int i = 0; i < 4; i++)
            tmpMap[3][i] = map[3][i];

        // 내리는거 어렵다...
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {

            }
        }
    }// end of main

}// end of class
