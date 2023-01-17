package fill_the_square;

import java.io.*;
import java.util.*;

public class Main_cover_debris {
    static final int OFFSET = 1000;
    static final int MAX_LEN = 2000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int[] x1 = new int[2];
        int[] y1 = new int[2];
        int[] x2 = new int[2];
        int[] y2 = new int[2];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            x1[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            y1[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            x2[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            y2[i] = Integer.parseInt(st.nextToken()) + OFFSET;
        }

        int[][] map = new int[MAX_LEN][MAX_LEN];

        for (int i = 0; i < 2; i++)
            for (int x = x1[i]; x < x2[i]; x++)
                for (int y = y1[i]; y < y2[i]; y++)
                    map[x][y] = i + 1;

        int x_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE;
        int y_max = Integer.MIN_VALUE;

        int cnt = 0;
        for (int x = 0; x < MAX_LEN; x++)
            for (int y = 0; y < MAX_LEN; y++) {
                if (map[x][y] == 1) {
                    cnt++;
                    x_min = x < x_min ? x : x_min;
                    x_max = x > x_max ? x : x_max;
                    y_min = y < y_min ? y : y_min;
                    y_max = y > y_max ? y : y_max;
                }
            }

        int ans = cnt > 0 ? (x_max - x_min + 1) * (y_max - y_min + 1) : 0;

        System.out.println(ans);

    }
}
