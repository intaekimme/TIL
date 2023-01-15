package boj;

import java.io.*;
import java.util.*;

public class Main_2563 {
    static final int MAX_LEN = 100;
    static final int SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[MAX_LEN][MAX_LEN];
        StringTokenizer st;
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

        int ans = 0;
        for (int i = 0; i < MAX_LEN; i++) {
            for (int j = 0; j < MAX_LEN; j++) {
                if (map[i][j] == 1) {
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}
