package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_on_the_checkboard_2 {
    static int r;
    static int c;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = st.nextToken();
            }
        }

        int cnt = jump(0, 0, 0, 0);

        System.out.println(cnt);

    }// end of main

    public static int jump(int x, int y, int cnt, int jump_cnt) {
        if (x == r - 1 && y == c - 1 && jump_cnt == 3)
            return cnt + 1;

        for (int i = x + 1; i < r; i++) {
            for (int j = y + 1; j < c; j++) {
                if (!map[x][y].equals(map[i][j]))
                    cnt = jump(i, j, cnt, jump_cnt + 1);
            }
        }
        return cnt;
    }

}// end of class
