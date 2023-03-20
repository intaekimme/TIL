package boj.priority_queue;

import java.io.*;
import java.util.*;

/**
 * 1655 가운데를 말해요 g2
 * 중앙값과 같은 문제
 */

public class Main_1655 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());

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
            sb.append(-maxHeap.peek()).append("\n");
        }

        System.out.print(sb.toString());
    }// end of main

}// end of class
