package Intermediate_mid.intermediate_data_structure.Priority_Queue;

import java.io.*;
import java.util.*;

/**
 * 배열 추출
 * 3번 문제 반대, 최대 정수 출력
 */

public class Main_5 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val > 0)
                pq.offer(-val);
            if (val == 0 && pq.isEmpty())
                sb.append(0).append("\n");
            if (val == 0 && !pq.isEmpty())
                sb.append(-pq.poll()).append("\n");
        }

        System.out.println(sb.toString());
    }
}