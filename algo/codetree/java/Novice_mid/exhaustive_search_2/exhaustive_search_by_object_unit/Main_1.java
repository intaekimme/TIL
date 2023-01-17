package Novice_mid.exhaustive_search_2.exhaustive_search_by_object_unit;

import java.io.*;
import java.util.*;

/**
 * 좌표평면 위의 특정 구역 2
 */
public class Main_1 {
    static int n;
    static int[] x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        x = new int[n];
        y = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        // i번째 점 제외

        int min_area = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // 나머지 점들 중 x최소, x최대, y최소, y최대를 구함.
            int x_min = Integer.MAX_VALUE;
            int x_max = Integer.MIN_VALUE;
            int y_min = Integer.MAX_VALUE;
            int y_max = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                x_min = x[j] < x_min ? x[j] : x_min;
                x_max = x_max < x[j] ? x[j] : x_max;
                y_min = y[j] < y_min ? y[j] : y_min;
                y_max = y_max < y[j] ? y[j] : y_max;
            }

            int area = (x_max - x_min) * (y_max - y_min);
            min_area = area < min_area ? area : min_area;
        }

        System.out.println(min_area);

    }// end of main

}// end of class
