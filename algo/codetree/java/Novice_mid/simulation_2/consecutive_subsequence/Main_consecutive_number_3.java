package consecutive_subsequence;

import java.io.*;
import java.lang.Math;

/**
 * 최장 연속 부분 수열
 * 연속되는 수 3
 * 
 * 로직
 * i-1항과 i 항의 곱이 양수면 두 항이 가튼 부호
 * 음수면 다른 부호
 */
public class Main_consecutive_number_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i >= 1 && arr[i] * arr[i - 1] > 0)
                cnt++;
            else
                cnt = 1;

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
