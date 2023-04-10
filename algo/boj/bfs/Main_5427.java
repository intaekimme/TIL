package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 5427 불
 */

public class Main_5427 {

    static int tc;
    static int w, h;
    static char[][] map;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }// end of init

    public static void simulation() {
        // 생존자 위치 확인

        // 생존자 위치에서부터 bfs 시작

    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main
}// end of class
