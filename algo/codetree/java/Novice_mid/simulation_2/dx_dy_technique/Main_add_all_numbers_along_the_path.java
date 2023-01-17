package dx_dy_technique;

import java.io.*;
import java.util.*;

public class Main_add_all_numbers_along_the_path {

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        String query = br.readLine();

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = n / 2;
        int y = n / 2;
        int dirNum = 0;

        int ans = map[x][y];
        for (int i = 0; i < t; i++) {
            if (query.charAt(i) == 'F') {
                int nx = x + dx[dirNum];
                int ny = y + dy[dirNum];

                if (outOfRange(nx, ny, n))
                    continue;

                x = x + dx[dirNum];
                y = y + dy[dirNum];

                ans += map[x][y];
            } else if (query.charAt(i) == 'L')
                dirNum = (dirNum - 1 + 4) % 4;
            else if (query.charAt(i) == 'R')
                dirNum = (dirNum + 1) % 4;
        }

        System.out.println(ans);

    }// end of main

    public static boolean outOfRange(int x, int y, int n) {
        return (x < 0 || x >= n || y < 0 || y >= n);
    }// end of outOfRange

}// end of class
