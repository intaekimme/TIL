package complete_search_by_number_of_digits;

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main_top_13_location {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 3; j++) {
                int cnt = 0;
                for (int k = j; k < j + 3; k++) {
                    cnt += map[i][k];
                }
                max = Math.max(max, cnt);
            }
        }

        System.out.println(max);
    }
}
