package Novice_mid.exhaustive_search_3.exhaustive_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

public class Main_2_1 {

    static int N;

    static int[] A;
    static int[] B;

    static final int MAX = 10_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int res = MAX;

        for (int i = 1; i < MAX; i++) {
            int x = i;

            boolean flag = true;
            for (int j = 0; j < N; j++) {
                x *= 2;
                if (x < A[j] || x > B[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                res = Math.min(res, i);
                break;
            }
        } // end of for

        System.out.println(res);

    }// end of main
}
