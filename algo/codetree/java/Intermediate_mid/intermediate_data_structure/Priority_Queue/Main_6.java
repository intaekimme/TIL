package Intermediate_mid.intermediate_data_structure.Priority_Queue;

import java.io.*;
import java.util.*;

/**
 * 마지막으로 남은 숫자
 */

public class Main_6 {

    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(-Integer.parseInt(st.nextToken()));
        }

        while (pq.size() >= 2) {
            int a = -pq.poll();
            int b = -pq.poll();

            if (a - b != 0)
                pq.offer(-Math.abs(a - b));
        }

        if (pq.size() == 1)
            System.out.println(-pq.peek());
        else
            System.out.println(-1);

    }
}