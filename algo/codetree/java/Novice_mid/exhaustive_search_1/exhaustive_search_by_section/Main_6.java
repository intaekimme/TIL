package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

/**
 * G or H 2
 */
public class Main_6 {

    static final int MAX_LEN = 100;

    static int n;
    static char[] arr = new char[MAX_LEN + 1];
    static int[] pos;
    static int max = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        pos = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            char alph = st.nextToken().charAt(0);

            pos[i] = p;
            arr[p] = alph;
        }

        Arrays.sort(pos);

    }// end of init

    public static boolean isOne(int x, int y, char c) {
        for (int i = pos[x]; i <= pos[y]; i++) {
            if (arr[i] != 0 && arr[i] != c)
                return false;
        }
        return true;

    }// end of isOne

    public static boolean isSame(int x, int y) {
        int g_cnt = 0;
        int h_cnt = 0;
        for (int i = pos[x]; i <= pos[y]; i++) {
            if (arr[i] == 'G')
                g_cnt++;
            if (arr[i] == 'H')
                h_cnt++;
        }
        if (g_cnt != h_cnt)
            return false;
        return true;
    }// end of isSame

    public static boolean isValid(int x, int y) {
        if (isOne(x, y, 'G') || isOne(x, y, 'H'))
            return true;
        if (isSame(x, y))
            return true;
        return false;
    }// end of isValid

    public static void sol() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!isValid(i, j))
                    continue;
                max = Math.max(max, Math.abs(pos[i] - pos[j]));
            }
        }
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(max);
    }// end of main
}// end of class
