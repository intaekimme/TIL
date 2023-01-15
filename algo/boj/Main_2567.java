package boj;

import java.io.*;
import java.util.*;

public class Main_2567 {

    static final int MAX_LEN = 100;
    static final int SIZE = 10;
    static final int[] dx = { 0, -1, 0, 1 };
    static final int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] map = new int[MAX_LEN + 2][MAX_LEN + 2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int r = x; r < x + SIZE; r++) {
                for (int c = y; c < y + SIZE; c++) {
                    map[r][c] = 1;
                }
            }
        }
        // BufferedOutputStream bs = new BufferedOutputStream(new
        // FileOutputStream("output.txt"));
        // for (int x = 0; x < MAX_LEN; x++) {
        // for (int y = 0; y < MAX_LEN; y++) {
        // bs.write(Arrays.toString(map[x]).getBytes());
        // }
        // }
        // bs.close();

        int ans = 0;
        for (int x = 1; x < MAX_LEN; x++) {
            for (int y = 1; y < MAX_LEN; y++) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (map[x][y] == 1 && map[nx][ny] == 0) {
                        ans++;
                    }
                } // end of for i
            } // end of for y
        } // end of for x

        System.out.println(ans);

    }// end of main

}// end of main
