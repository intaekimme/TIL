package Novice_mid.exhaustive_search_2.exhaustive_search_by_object_unit;

import java.io.*;
import java.util.*;

/**
 * 선분 3개 지우기,
 * 지울 3개의 직선 선택
 */
public class Main_9 {

    static int n;
    static int[] l, r;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        l = new int[n];
        r = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            l[i] = Integer.parseInt(st.nextToken());
            r[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    boolean overlap = false;
                    int[] arr = new int[101];

                    // n개의 직선 표시
                    for (int x = 0; x < n; x++) {
                        if (x == i || x == j || x == k)
                            continue;
                        for (int y = l[x]; y <= r[x]; y++)
                            arr[y]++;
                    }

                    for (int x = 1; x <= 100; x++)
                        if (arr[x] > 1)
                            overlap = true;

                    if (overlap == false)
                        ans++;
                }
            }
        }
        System.out.println(ans);

    }// end of main

}// end of class