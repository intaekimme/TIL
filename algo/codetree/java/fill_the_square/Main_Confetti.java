package fill_the_square;

import java.io.*;
import java.util.*;

public class Main_Confetti {

    static final int MAX_LEN = 200;
    static final int OFFSET = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[MAX_LEN][MAX_LEN];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + OFFSET;
            int y = Integer.parseInt(st.nextToken()) + OFFSET;

            addConfetti(x, y, map);
        }

        int ans = 0;
        for (int i = 0; i < MAX_LEN; i++)
            for (int j = 0; j < MAX_LEN; j++)
                if (map[i][j] == 1)
                    ans++;

        System.out.println(ans);

    }// end of main

    public static void addConfetti(int x, int y, int[][] map) {
        for (int i = x; i < x + 8; i++)
            for (int j = y; j < y + 8; j++)
                map[i][j] = 1;
    }// end of addConfetti

}// end of class
