package dx_dy_technique;

import java.io.*;
import java.util.*;

public class Main_spin_around_and_fill_the_square {

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        // System.out.println('A'); // A
        // System.out.println((char) ('A' + 1)); // B

        map[0][0] = 65; // A's ascii code = 65
        int x = 0;
        int y = 0;
        int dirNum = 0;
        for (int i = 2; i <= n * m; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if (outOfRange(nx, ny, n, m) || map[nx][ny] != 0)
                dirNum = (dirNum + 1) % 4;

            int pre = map[x][y] == 90 ? 64 : map[x][y];
            // a b c d e f g h i j k l m n o p q r s t u v w x y z
            // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
            // 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90
            x = x + dx[dirNum];
            y = y + dy[dirNum];

            map[x][y] = pre + 1;

        } // end of n * m loop

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append((char) (map[i][j])).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }// end of main

    public static boolean outOfRange(int x, int y, int n, int m) {
        return (x < 0 || x >= n || y < 0 || y >= m);
    }

}// end of class
