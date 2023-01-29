package Novice_mid.exhaustive_search_2.exhaustive_search_by_object_unit;

import java.io.*;
import java.util.*;

/**
 * 이상한 폭탄
 */

public class Main_8 {

    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int ans = -1;
        // 선택 가능한 시작 지점
        for (int i = 0; i <= n - k; i++) {
            // k 길이 만큼 확인
            // 서로 다른 2개 선택
            for (int j = i; j <= i + k; j++) {
                for (int l = j + 1; l <= i + k; l++) {
                    // 2개가 같으면 갱신
                    if (arr[j] == arr[l])
                        ans = Math.max(ans, arr[j]);
                }
            }
        }

        System.out.println(ans);
    }// end of main

}// end of class
