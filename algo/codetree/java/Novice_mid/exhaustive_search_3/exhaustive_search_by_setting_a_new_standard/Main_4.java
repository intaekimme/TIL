package Novice_mid.exhaustive_search_3.exhaustive_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

/**
 * 숫자들의 최대 차
 */
public class Main_4 {
    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int end = arr[n - 1]; // 최솟값으로 정할 원소의 상한
        int max = 0; // 뽑을 수 있는 최대 숫자의 갯수

        // 최솟값 고정
        for (int i = 1; i <= end; i++) {
            int cnt = 0; // 최대 최소 범위에 포함되는 원소 갯수

            // 전체 원소 중 조건을 만족하는 원소의 갯수 세기
            for (int j = 0; j < n; j++) {
                if (i <= arr[j] && arr[j] <= i + k)
                    cnt++;
            }
            // 최대 숫자 갯수 갱신
            max = max < cnt ? cnt : max;
        }

        System.out.println(max);

    }// end of main
}
