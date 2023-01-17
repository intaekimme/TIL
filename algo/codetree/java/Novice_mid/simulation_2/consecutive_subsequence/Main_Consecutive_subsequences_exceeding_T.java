package consecutive_subsequence;

import java.io.*;
import java.util.*;
import java.lang.Math;

/**
 * 최장 연속 부분수열
 * 
 * 로직
 * i항이 t를 초과하면 갯수를 카운트한다.
 * 작으면 갯수를 0으로 초기화한다.
 * 
 */
public class Main_Consecutive_subsequences_exceeding_T {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i >= 1 && t < arr[i])
                cnt++;
            else
                cnt = 0;

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);

    }
}
