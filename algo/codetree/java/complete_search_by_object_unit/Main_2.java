package complete_search_by_object_unit;

import java.io.*;
import java.util.*;

/**
 * 가장 가까운 두 점 사이의 거리
 * 가장 가까운 두 점 사이의 거리에 제곱을 한 값을 구하라
 * = n개의 점에서 2점을 선택하는 모든 경우의 거리를 계산 후 최솟값을 구한다
 */
public class Main {
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

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.min(ans, getDistance(i, j));
            }
        }

        System.out.println(ans);

    }// end of main

    public static int getDistance(int a, int b) {
        int x1 = x[a];
        int y1 = y[a];
        int x2 = x[b];
        int y2 = y[b];

        return (int) Math.pow(x1 - x2, 2) + (int) Math.pow(y1 - y2, 2);
    }
}
