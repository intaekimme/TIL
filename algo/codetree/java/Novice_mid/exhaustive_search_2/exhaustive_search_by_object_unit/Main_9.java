package Novice_mid.exhaustive_search_2.exhaustive_search_by_object_unit;

import java.io.*;
import java.util.*;

/**
 * 선분 3개 지우기
 */
public class Main_9 {

    static int n;
    static int[][] lines;
    static int[][] selected;
    static int ans = 0;

    public static boolean isOverRapped() {
        for (int i = 1; i < n - 3; i++) {
            if (selected[i - 1][1] >= selected[i][0])
                return true;
        }
        return false;
    }// end of isOverRapped

    public static void func(int depth, int start) {
        if (depth == n - 3) {
            if (!isOverRapped()) {
                ans++;
            }

            return;
        }

        for (int i = start; i < n; i++) {
            selected[depth] = lines[i];
            func(depth + 1, i + 1);
        }

    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        lines = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            lines[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        }

        Arrays.sort(lines, (a, b) -> a[0] - b[0]);

        selected = new int[n - 3][];
        func(0, 0);

        System.out.println(ans);

    }// end of main

}// end of class