package dx_dy_technique;

import java.io.*;
import java.util.*;

public class Main_Spin_around_and_write_down_numbers_2 {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        map[0][0] = 1;
        int x = 0;
        int y = 0;
        int dirNum = 0;
        for (int i = 2; i <= n * m; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if (outOfRange(nx, ny, n, m) || map[nx][ny] != 0)
                dirNum = (dirNum + 1) % 4;

            x = x + dx[dirNum];
            y = y + dy[dirNum];

            map[x][y] = i;
        } // end of for

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }// end of main

    public static boolean outOfRange(int x, int y, int n, int m) {
        return (x < 0 || x >= n || y < 0 || y >= m);
    }

}// end of class
