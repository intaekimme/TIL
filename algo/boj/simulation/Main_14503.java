package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 14503 로봇청소기_sol
 * simulation
 */

public class Main_14503 {

    static int n, m, sr, sc, dir;
    static int ans = 0;
    static int[][] map; // 0 : 청소 안한 칸, 1: 벽, 2 : 청소한 칸

    static int[] dx = new int[] { -1, 0, 1, 0 }; // 북, 동, 남, 서
    static int[] dy = new int[] { 0, 1, 0, -1 };

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of init

    public static void sol() {
        int x = sr;
        int y = sc;

        while (true) {

            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[x][y] == 0) {
                map[x][y] = 2;
                ans++;
            }

            // 현재 칸의 주변 4칸을 확인한다.
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 청소되지 않은 빈 칸인 경우
                if (map[nx][ny] == 0) {
                    // 해당 칸으로 한 칸 전진한다.
                    x = nx;
                    y = ny;
                    break;
                } else {
                    cnt++;
                }

            }

            // 주변 4칸중 청소되지 않은 빈 칸이 없는 경우
            if (cnt == 4) {
                int nx = x + dx[(dir + 2) % 4];
                int ny = y + dy[(dir + 2) % 4];

                // 후진한 칸이 벽이라면 작동을 멈춘다.
                if (map[nx][ny] == 1)
                    break;
                else {
                    // 후진할 수 있다면 후진한다.
                    x = nx;
                    y = ny;
                }
            }

            // for (int i = 0; i < n; i++)
            // System.out.println(Arrays.toString(map[i]));
            // System.out.println("-----------------------------");
        } // end of while

        System.out.println(ans);

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
