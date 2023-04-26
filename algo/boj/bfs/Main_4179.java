package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 불 4179
 * g4
 */

public class Main_4179 {

    static int R, C;
    static char[][] map;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

    }// end of init

    public static void main(String[] args) throws IOException {
        init();
    }// end of main
}// end of class
