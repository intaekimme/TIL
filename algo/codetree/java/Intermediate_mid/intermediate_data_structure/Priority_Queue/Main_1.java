package Intermediate_mid.intermediate_data_structure.Priority_Queue;

import java.io.*;
import java.util.*;

/**
 * 정수 명령 처리 6
 */

public class Main_1 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();
            int val = 0;
            if (st.hasMoreTokens()) {
                val = Integer.parseInt(st.nextToken());
            }

            if (query.equals("push")) {
                pq.add(-val);
            }
            if (query.equals("size")) {
                sb.append(pq.size()).append("\n");
            }
            if (query.equals("empty")) {
                sb.append(pq.isEmpty() ? 1 : 0).append("\n");
            }
            if (query.equals("pop")) {
                sb.append(-pq.poll()).append("\n");
            }
            if (query.equals("top")) {
                sb.append(-pq.peek()).append("\n");
            }

        }
        System.out.println(sb.toString());
    }
}
