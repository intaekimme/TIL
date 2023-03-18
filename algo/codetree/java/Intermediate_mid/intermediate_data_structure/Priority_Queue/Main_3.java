package Intermediate_mid.intermediate_data_structure.Priority_Queue;

import java.io.*;
import java.util.*;

/**
 * 최소 정수 출력
 * 
 * 뽑은 다음에 확인하면 비어서 정답과 다르게 나올 수 도 있다.
 * 그래서 뽑는 것을 맨 마지막으로 배치해줘야 함
 */

public class Main_3 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val > 0)
                pq.offer(val);
            if (val == 0 && pq.isEmpty())
                sb.append(0).append("\n");
            if (val == 0 && !pq.isEmpty())
                sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
