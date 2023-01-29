package Novice_mid.exhaustive_search_2.exhaustive_search_by_object_unit;

import java.io.*;
import java.util.*;

public class Main_6 {

    static int k, n;
    static int[][] arr;
    static int ans = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of init

    public static void sol() {
        // 한 줄 선택
        for (int i = 0; i < k; i++) {

            // 한 줄에서 나온 경우 선택
            int a = 0;
            int b = 0;
            for (int j = 0; j < n; j++) {
                a = arr[i][j];
                for (int k = j + 1; k < n; k++) {
                    if (a <= arr[i][k])
                        continue;
                    b = arr[i][k];

                    for (int l = i + 1; l < k; l++) {
                        for (int o = 0; o < n; o++) {
                            for (int p = o + 1; p < n; p++) {
                                if (a == arr[l][o] && b == arr[l][p])
                                    ans++;
                            }
                        }
                    }
                }
            }
        }
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main

}// end of class