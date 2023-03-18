package Intermediate_mid.intermediate_data_structure.Priority_Queue;

import java.io.*;
import java.util.*;

/**
 * 앞에서부터 삭제하기 2
 * 
 * n의 갯수가 100,000개이기 때문에
 * 앞에서 부터 지워서 계산하면 O(N^2)으로 시간초과 발생함
 * 
 * 따라서 뒤에서부터 앞으로 넣어주면서 계산해야 O(NlogN)에 풀 수 있음
 */

public class Main_7 {

    static int n;
    static double ans = 0;

    static int[] arr;
    static long[] sum;

    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        sum = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + arr[i];
        }

        ans = (double) sum[n - 1] / 1;
        pq = new PriorityQueue<>();
        pq.offer(arr[n - 1]);

        for (int k = n - 2; k >= 1; k--) {

            pq.offer(arr[k]);

            double res = sum[k] - pq.peek();

            double quotient = pq.size() - 1;
            ans = Math.max(ans, Math.round(res * 100 / quotient) / 100.0);
        }

        System.out.printf("%.2f", ans);
    }
}
