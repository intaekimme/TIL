package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

/**
 * 숨은 단어 찾기 2
 */
public class Main_14 {

    static final int MAX_LEN = 50;

    static int n, m;
    static char[][] map = new char[MAX_LEN][MAX_LEN];
    static char[] name = new char[] { 'L', 'E', 'E' };
    static int word_cnt = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }// end of outOfRange

    public static boolean isValid(int pos, int x, int y) {
        return name[pos] == map[x][y];
    }// end of isValid

    public static void check(int x, int y) {
        int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };

        for (int i = 0; i < 8; i++) {

            int isAllMatch = 0;
            for (int j = 0; j < 3; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (outOfRange(nx, ny))
                    break;

                if (isValid(j, nx, ny))
                    isAllMatch++;

                if (isAllMatch == 3) {
                    word_cnt++;
                }
            }

        }
    }// end of check

    public static void sol() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                check(i, j);
            }
        }
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();

        sol();

        System.out.println(word_cnt);
    }// end of main

}// end of class
