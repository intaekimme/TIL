package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

/**
 * G to H 3
 * 탐색 구간이 배열의 최대위치보다 긴 경우가 문제였다
 * 문제 범위 잘 읽기
 * 최적화보다는 문제 범위만큼 선언하는게 이롭다.
 */
public class Main_2 {

    static int[] px;
    static char[] alph;
    static int[] arr;
    static int MAX_LEN = 20_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        px = new int[n];
        alph = new char[n];

        int R = 0; // 사람 위치 중 최댓값
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            px[i] = Integer.parseInt(st.nextToken());
            alph[i] = st.nextToken().charAt(0);
            R = R < px[i] ? px[i] : R;
        }

        arr = new int[MAX_LEN + 1];
        for (int i = 0; i < n; i++) {
            arr[px[i]] = alph[i] - 'F';
        }

        int max = 0;
        for (int i = 1; i <= R + 1; i++) {
            int sum = 0;
            for (int j = i; j <= i + k; j++) {
                sum += arr[j];
            }
            max = max < sum ? sum : max;
        }

        System.out.println(max);

    }
}
