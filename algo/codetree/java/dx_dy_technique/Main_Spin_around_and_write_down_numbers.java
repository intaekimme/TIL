package dx_dy_technique;

import java.io.*;
import java.util.*;

public class Main_Spin_around_and_write_down_numbers {

    static final int[] dx = { 0, 1, 0, -1 };
    static final int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        int x = 0;
        int y = 0;
        int dirNum = 0;

        map[0][0] = 1;
        for (int i = 2; i <= n * m; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            // 범위를 벗어났으면
            if (outOfRange(nx, ny, n, m) || map[nx][ny] != 0)
                dirNum = (dirNum + 1) % 4;

            x = x + dx[dirNum];
            y = y + dy[dirNum];
            map[x][y] = i;
        }

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
}
