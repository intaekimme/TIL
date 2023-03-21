package Intermediate_mid.intermediate_data_structure.Priority_Queue;

import java.io.*;
import java.util.*;

/**
 * 최솟값 3개
 */

public class Main_12 {

    static int n;
    static int[] arr = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            pq.offer(val);
            if (pq.size() < 3) {
                sb.append(-1);
            } else {
                long res = 1;
                for (int j = 0; j < 3; j++) {
                    arr[j] = pq.poll();
                    res *= arr[j];
                }

                sb.append(res);
                for (int j = 0; j < 3; j++) {
                    pq.offer(arr[j]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }// end of main
}