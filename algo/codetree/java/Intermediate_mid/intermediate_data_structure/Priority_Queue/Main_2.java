package Intermediate_mid.intermediate_data_structure.Priority_Queue;

import java.io.*;
import java.util.*;

/**
 * 큰 숫자만 계속 고르기
 */

public class Main_2 {

    static int n, m;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            // 최댓값을 구하기 위해 음수 처리해서 넣어줌
            pq.offer(-Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            // 음수 처리해서 넣었기 때문에 다시 음수로 원복
            int val = -pq.poll();
            pq.offer(-(val - 1));
        }

        System.out.println(-pq.poll());

    }
}
