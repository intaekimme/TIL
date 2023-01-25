package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * nm과 k (1),18920_fail, 40min
 * 
 */
public class Main_18920 {
    static final int MAX_N = 10;
    static final int[] dx = { 0, -1, 0, 1 };
    static final int[] dy = { 1, 0, -1, 0 };

    static int n, m, k;
    static int[][] map = new int[MAX_N][MAX_N];
    static int[] selected;

    static int ans = Integer.MIN_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
    }// end of init

    public static boolean isAdj(int p1, int p2) {
        int x1 = p1 / n;
        int y1 = p1 % m;

        int x2 = p2 / n;
        int y2 = p2 % m;

        // x, y 좌표 둘 중 하나는 거리차가 0 이고 나머지는 1이면 인접
        return (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 0) ||
                (Math.abs(x1 - x2) == 0 && Math.abs(y1 - y2) == 1);

    }// end of isAdj

    public static boolean isPossible() {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++)
                if (isAdj(selected[i], selected[j]))
                    return false;
        }
        return true;
    }// end of isPossible

    public static int getSum() {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            int x = selected[i] / n;
            int y = selected[i] % m;

            sum += map[x][y];
        }
        return sum;
    }// end of getSum

    public static void func(int depth, int start) {
        if (depth == k) {
            // for (int i = 0; i < k; i++)
            // System.out.print(selected[i] + " ");
            // System.out.println();

            if (!isPossible())
                return;

            ans = Math.max(ans, getSum());
            return;
        }

        for (int i = start; i < n * m; i++) {
            selected[depth] = i;
            func(depth + 1, i + 1);
        }
    }// end of func

    public static void sol() {
        selected = new int[k];

        func(0, 0);
    }// end of sol;

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}// end of calss