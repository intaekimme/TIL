package boj.priority_queue;

import java.io.*;
import java.util.*;

/**
 * 중앙값 구하기 G2, 2696
 * 코드트리 중앙값 구하기와 동일한 문제
 */

public class Main_2696 {

    static int TC, M;
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer> res;

    public static void findMedian(int end) {
        for (int i = 1; i <= end; i++) {
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
                res.add(-maxHeap.peek());
            }
        }
    }// end of findMedian

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            M = Integer.parseInt(br.readLine());

            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>();

            res = new ArrayList<>();

            while (M > 0) {
                st = new StringTokenizer(br.readLine());
                if (M >= 10) {
                    findMedian(10);
                } else {
                    findMedian(M);
                }
                M -= 10;
            }

            int cnt = 0;
            sb.append(res.size()).append("\n");
            for (int i = 0; i < res.size(); i++) {
                sb.append(res.get(i));
                cnt++;
                if (cnt < 10)
                    sb.append(" ");
                else {
                    cnt = 0;
                    sb.append("\n");
                }
            }
            sb.append("\n");
        } // end of TC

        System.out.print(sb.toString());
    }// end of main

}// end of class
