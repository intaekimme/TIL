package fill_the_square;

import java.io.*;
import java.util.*;

public class Main_rectangles_that_overlap {

    static final int MAX_LEN = 200;
    static final int OFFSET = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x1[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            y1[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            x2[i] = Integer.parseInt(st.nextToken()) + OFFSET;
            y2[i] = Integer.parseInt(st.nextToken()) + OFFSET;
        }

        int[][] map = new int[MAX_LEN][MAX_LEN];

        for (int i = 0; i < n; i++)
            for (int x = x1[i]; x < x2[i]; x++)
                for (int y = y1[i]; y < y2[i]; y++)
                    map[x][y] = i % 2 == 0 ? 1 : 2; // 1 : red, 2 : blue

        int ans = 0;
        for (int x = 0; x < MAX_LEN; x++)
            for (int y = 0; y < MAX_LEN; y++)
                if (map[x][y] == 2)
                    ans++;

        System.out.println(ans);
    }
}
