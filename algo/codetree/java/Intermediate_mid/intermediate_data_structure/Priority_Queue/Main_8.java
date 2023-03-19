package Intermediate_mid.intermediate_data_structure.Priority_Queue;

import java.io.*;
import java.util.*;

/**
 * 중앙값
 * 
 * 두 개의 우선순위 큐를 사용
 * maxHeap : 중앙값과 중앙값보다 작은 숫자들, 중앙값보다 작은 숫자들 중 최대
 * minHeap : 중앙값보다 큰 숫자들, 중앙값보다 큰 숫자들 중 최소
 */

public class Main_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TC; tc++) {
            int m = Integer.parseInt(br.readLine());

            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= m; i++) {
                int val = Integer.parseInt(st.nextToken());

                if (minHeap.size() == maxHeap.size())
                    maxHeap.offer(-val);
                else
                    minHeap.offer(val);

                if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < -maxHeap.peek()) {
                    int a = -maxHeap.poll();
                    int b = minHeap.poll();

                    minHeap.offer(a);
                    maxHeap.offer(-b);
                }

                if (i % 2 != 0) {
                    sb.append(-maxHeap.peek()).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }// end of main

}// end of class