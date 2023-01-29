package Novice_mid.exhaustive_search_2.exhaustive_search_by_object_unit;

import java.io.*;
import java.util.*;

public class Main_4 {

    static final int MAX_N = 100;

    static int n;
    static int[] x1 = new int[MAX_N];
    static int[] x2 = new int[MAX_N];

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            x1[i] = Integer.parseInt(st.nextToken());
            x2[i] = Integer.parseInt(st.nextToken());
        }

        // 선분 하나 지정
        for (int i = 0; i < n; i++) {
            // 겹치는지 여부 확인
            boolean overlap = false;
            for (int j = 0; j < n; j++) {

                if (i == j)
                    continue;
                // 1) 지정한 하나의 선분이 비교할 선분보다 x1이 작고 x2가 큰 경우
                // 2) 지정한 하나의 선분이 비교할 선분보다 x1이 크고, x2가 작은 경우
                if ((x1[i] <= x1[j] && x2[j] <= x2[i]) || (x1[j] <= x1[i] && x2[i] <= x2[j])) {
                    overlap = true;
                    break;
                }

            }
            // 겹치지 않으면 정답 추가
            if (overlap == false)
                ans++;
        }

        System.out.println(ans);

    }// end of main

}// end of class