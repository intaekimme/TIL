package Novice_mid.exhaustive_search_3.exhaustive_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

public class Main_7 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = input.charAt(i) - '0';
        }

        int res = Integer.MIN_VALUE;

        // 첫번째 자리 선정
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1)
                continue;

            arr[i] = 1;

            // 두번째 자리 선정
            for (int j = 0; j < N; j++) {
                // 먼저 넣은 자리이거나, 사람이 이미 있는 경우 패스
                if (i == j || arr[j] == 1)
                    continue;

                arr[j] = 1;

                int dist = Integer.MAX_VALUE;

                // 두 사람 선정
                for (int r = 0; r < N; r++) {
                    if (arr[r] == 0)
                        continue;
                    for (int c = 0; c < N; c++) {
                        // 먼저 고른 사람과 동일한 사람이거나, 사람이 없는 경우 패스
                        if (r == c || arr[c] == 0)
                            continue;
                        dist = Math.min(dist, Math.abs(r - c));
                    } // end of for c
                } // end of for r

                res = Math.max(res, dist);
                arr[j] = 0;

            } // end of for j

            arr[i] = 0;
        } // end of for i

        System.out.println(res);
    }// end of main
}

/**
 * 
 * 14
 * 10001001000010
 * 012
 * 10x010010x0010 이 경우에 가장 가까운 두 사람 간의 거리가 2가 되며, 이보다 더 크게 만들 수는 없습니다.
 * 
 * 10001000100x00100x
 */