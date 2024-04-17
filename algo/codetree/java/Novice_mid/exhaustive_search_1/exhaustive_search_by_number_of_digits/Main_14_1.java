package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_14_1 {

    static int N, M;
    static char[][] map;

    static final char[] str = new char[] { 'L', 'E', 'E' };

    static final int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
    static final int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 'L')
                    continue;
                findLee(i, j);
            }
        }

        System.out.println(cnt);
    }// end of main

    public static boolean outOfRange(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }

    public static void findLee(int r, int c) {
        for (int i = 0; i < 8; i++) {
            boolean flag = true;
            for (int j = 1; j <= 2; j++) {
                int nr = r + dx[i] * j;
                int nc = c + dy[i] * j;
                if (outOfRange(nr, nc) || map[nr][nc] != str[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                cnt++;
        }
    }

}// end of class
