package Curriculum_by_Company;

import java.io.*;
import java.util.*;

public class Main_13 {

    static final int N = 19;
    static int[][] map = new int[N][N];

    static int[] dx = new int[] { 1, 1, 1, 0 };
    static int[] dy = new int[] { -1, 0, 1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int bCnt = 0;
        int wCnt = 0;
        int WIN = 0;
        int posX = 1;
        int posY = 1;

        here: for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    if (outOfRange(i, j, dir))
                        continue;

                    bCnt = 0;
                    wCnt = 0;

                    for (int k = 0; k < 5; k++) {
                        if (map[i + dx[dir] * k][j + dy[dir] * k] == 1)
                            bCnt++;
                        else if (map[i + dx[dir] * k][j + dy[dir] * k] == 2)
                            wCnt++;
                    }

                    if (bCnt == 5) {
                        WIN = 1;
                        posX = i + dx[dir] * 2;
                        posY = j + dy[dir] * 2;
                        break here;
                    }

                    if (wCnt == 5) {
                        WIN = 2;
                        posX = i + dx[dir] * 2;
                        posY = j + dy[dir] * 2;
                        break here;
                    }

                } // end of dir loop
            } // end of j loop
        } // end of i loop

        System.out.println(WIN);
        if (WIN != 0)
            System.out.println(posX + " " + posY);
    }// end of main

    public static boolean outOfRange(int x, int y, int dir) {
        return x + (dx[dir] * 4) < 0 || x + (dx[dir] * 4) >= N || y + (dy[dir] * 4) < 0 || y + (dy[dir] * 4) >= N;
    }
}