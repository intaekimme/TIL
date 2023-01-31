package Novice_mid.exhaustive_search_3.exhaustive_exploration_by_assuming_the_situation_one_by_one;

import java.io.*;
import java.util.*;

/**
 * 3개의 선 2
 */

public class Main_4 {
    static final int MAX_N = 20;
    static int n;

    static int[] x = new int[MAX_N];
    static int[] y = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        // xxx
        for (int i = 0; i <= 10; i++) {
            for (int j = i + 1; j <= 10; j++) {
                for (int k = j + 1; k <= 10; k++) {
                    if (i == j || j == k || k == i)
                        continue;

                    boolean[] check = new boolean[n];

                    for (int l = 0; l < n; l++) {
                        if (x[l] == i || x[l] == j || x[l] == k)
                            check[l] = true;
                    }

                    int cnt = 0;
                    for (int l = 0; l < n; l++)
                        if (check[l])
                            cnt++;
                    if (cnt == n) {
                        System.out.println(1);
                        System.exit(0);
                    }
                }
            }
        }

        // xxy
        for (int i = 0; i <= 10; i++) {
            for (int j = i + 1; j <= 10; j++) {
                for (int k = 0; k <= 10; k++) {
                    if (i == j)
                        continue;

                    boolean[] check = new boolean[n];

                    for (int l = 0; l < n; l++) {
                        if (x[l] == i || x[l] == j || y[l] == k)
                            check[l] = true;
                    }

                    int cnt = 0;
                    for (int l = 0; l < n; l++)
                        if (check[l])
                            cnt++;
                    if (cnt == n) {
                        System.out.println(1);
                        System.exit(0);
                    }
                }
            }
        }

        // xyy
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                for (int k = j + 1; k <= 10; k++) {
                    if (j == k)
                        continue;

                    boolean[] check = new boolean[n];

                    for (int l = 0; l < n; l++) {
                        if (y[l] == j || y[l] == k || x[l] == i)
                            check[l] = true;
                    }

                    int cnt = 0;
                    for (int l = 0; l < n; l++)
                        if (check[l])
                            cnt++;
                    if (cnt == n) {
                        System.out.println(1);
                        System.exit(0);
                    }
                }
            }
        }

        // yyy
        for (int i = 0; i <= 10; i++) {
            for (int j = i + 1; j <= 10; j++) {
                for (int k = j + 1; k <= 10; k++) {
                    if (i == j || j == k || k == i)
                        continue;

                    boolean[] check = new boolean[n];

                    for (int l = 0; l < n; l++) {
                        if (y[l] == i || y[l] == j || y[l] == k)
                            check[l] = true;
                    }

                    int cnt = 0;
                    for (int l = 0; l < n; l++)
                        if (check[l])
                            cnt++;
                    if (cnt == n) {
                        System.out.println(1);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(0);
    }
}