package dx_dy_technique;

import java.io.*;

/**
 * (n,n) 부터 반시계 방향으로 감아 들어간다.
 */
public class Main_start_in_middle_and_go_around {

    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        int x = n - 1;
        int y = n - 1;
        int dirNum = 0;

        map[n - 1][n - 1] = n * n;
        for (int i = (n * n) - 1; i >= 1; i--) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if (outOfRange(nx, ny, n) || map[nx][ny] != 0)
                dirNum = (dirNum + 1) % 4;

            x = x + dx[dirNum];
            y = y + dy[dirNum];

            map[x][y] = i;
        } // end of for

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }// end of main

    public static boolean outOfRange(int x, int y, int n) {
        return (x < 0 || x >= n || y < 0 || y >= n);
    }
}// end of class
