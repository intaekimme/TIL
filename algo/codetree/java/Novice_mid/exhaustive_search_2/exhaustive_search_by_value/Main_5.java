package Novice_mid.exhaustive_search_2.exhaustive_search_by_value;

import java.io.*;
import java.util.*;

/**
 * 등차수열
 */
public class Main_5 {
    static final int MAX_N = 100;

    static int n;
    static int[] arr = new int[MAX_N];
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int min = MAX_N + 1;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = max < arr[i] ? arr[i] : max;
            min = arr[i] < min ? arr[i] : min;
        }

        // 가능한 자연수 k
        for (int i = min; i <= max; i++) {
            int cnt = 0;
            // a[i] 선택
            for (int j = 0; j < n; j++) {
                // a[j] 선택
                for (int k = j + 1; k < n; k++) {
                    // a[i], k, a[j] 순서로 등차수열을 이루는가
                    if (arr[j] - i == i - arr[k])
                        cnt++;
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);

    }
}
