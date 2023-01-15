package dx_dy_technique;

import java.io.*;
import java.util.*;

public class Main_Positions_with_3_or_more_1 {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check(i, j, n, map))
                    ans++;
            }
        }

        System.out.println(ans);

    }// end of main

    public static boolean isRange(int x, int y, int n) {
        return (x < 0 || x >= n || y < 0 || y >= n);
    }

    public static boolean check(int x, int y, int n, int[][] map) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isRange(nx, ny, n))
                continue;
            if (map[nx][ny] == 1)
                cnt++;
        }
        return cnt >= 3 ? true : false;
    }
}// end of class