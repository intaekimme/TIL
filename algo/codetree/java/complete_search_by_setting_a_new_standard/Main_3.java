package complete_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

/**
 * 가장 많이 나온 쌍
 */
public class Main_3 {

    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c]++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                max = map[i][j] + map[j][i] > max ? map[i][j] + map[j][i] : max;
            }
        }

        System.out.println(max);
    }// end of main

}// end of class
