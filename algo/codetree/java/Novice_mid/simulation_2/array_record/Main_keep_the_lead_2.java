package array_record;

import java.io.*;
import java.util.*;

/**
 * 시간 배열에 A와 B의 이동거리를 각 각 기록
 * 이 시간 배열을 처음부터 순회하면서
 * 선두를 조회, 이전 선두 조합과 다르면 정답 카운트
 * 
 */
public class Main_keep_the_lead_2 {

    static final int MAX_LEN = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[MAX_LEN + 1];
        int[] B = new int[MAX_LEN + 1];

        int timeA = 1;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for (int j = 0; j < t; j++) {
                A[timeA] = A[timeA - 1] + v;
                timeA++;
            }
        }

        int timeB = 1;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for (int j = 0; j < t; j++) {
                B[timeB] = B[timeB - 1] + v;
                timeB++;
            }
        }

        int pre = findComb(A[1], B[1]);
        int ans = 0;
        for (int i = 2; i <= MAX_LEN; i++) {
            int cur = findComb(A[i], B[i]);
            if (pre != cur)
                ans++;
            pre = cur;
        }

        System.out.println(ans);

    }// end of main

    // a < b : 0, b < a : 1, a == b : 2
    public static int findComb(int a, int b) {
        if (a == b)
            return 2;
        return a < b ? 0 : 1;
    }

}// end of class
