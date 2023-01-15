package consecutive_subsequence;

import java.io.*;
import java.lang.Math;

/**
 * 최장 연속 부분 수열
 * 연속되는 수 4
 * 
 * 로직
 * i-1항이 i항보다 크면 카운트, 작아지면 중단하고
 * 지금까지의 최장 길이를 갱신
 */
public class Main_consecutive_number_4 {
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
            if (i >= 1 && arr[i - 1] < arr[i]) {
                cnt++;
            } else {
                cnt = 1;
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
