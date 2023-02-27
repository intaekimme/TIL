package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 스타트링크, 5014
 * 
 * bfs
 * arr 배열은 해당 위치로 이동하는데 걸린 점프 횟수
 */

public class Main_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int f, s, g, u, d;
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int[] arr = new int[f + 1];

        Queue<Integer> que = new ArrayDeque<>();

        arr[s] = 1;
        que.offer(s);

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (cur == g) {
                System.out.println(arr[cur] - 1);
                System.exit(0);
            }

            if (cur + u <= f) {
                if (arr[cur + u] == 0) {
                    arr[cur + u] = arr[cur] + 1;
                    que.offer(cur + u);
                }
            }

            if (cur - d > 0) {
                if (arr[cur - d] == 0) {
                    arr[cur - d] = arr[cur] + 1;
                    que.offer(cur - d);
                }
            }
        }

        System.out.println("use the stairs");
    }// end of main

}// end of class
