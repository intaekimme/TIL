package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r, c;

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        String[][] map = new String[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = st.nextToken();
            }
        }

        String start = map[0][0];
        String end = map[r - 1][c - 1];

        int cnt = 0;
        if (start.equals(end)) {
            System.out.println(cnt);
            System.exit(0);
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if ("W".equals(start) && "B".equals(map[i][j])) {
                    for (int k = i + 1; k < r - 1; k++) {
                        for (int l = j + 1; l < c - 1; l++) {
                            if ("W".equals(map[k][l]))
                                cnt++;
                        }
                    }
                }
                if ("B".equals(start) && "W".equals(map[i][j])) {
                    for (int k = i + 1; k < r - 1; k++) {
                        for (int l = j + 1; l < c - 1; l++) {
                            if ("B".equals(map[k][l]))
                                cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
