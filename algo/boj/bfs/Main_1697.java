package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 1697. 숨박꼭질
 * 
 */

public class Main {

    static final int MAX = (int) 1e5; // 100_000

    static int n, k;
    static int[] arr;
    static Queue<Integer> que = new ArrayDeque<>();

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[MAX + 1];
        Arrays.fill(arr, (int) 1e9);
    }// end of init

    public static boolean outOfRange(int x) {
        return x < 0 || x > MAX;
    }// end of outOfRange

    public static void sol() {
        arr[n] = 0;
        que.offer(n);

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (cur == k)
                break;

            // 1초 후에 가능한 위치
            if (!outOfRange(cur - 1) && arr[cur - 1] > arr[cur] + 1) {
                arr[cur - 1] = arr[cur] + 1;
                que.offer(cur - 1);
            }
            if (!outOfRange(cur + 1) && arr[cur + 1] > arr[cur] + 1) {
                arr[cur + 1] = arr[cur] + 1;
                que.offer(cur + 1);
            }
            if (!outOfRange(cur * 2) && arr[cur * 2] > arr[cur] + 1) {
                arr[cur * 2] = arr[cur] + 1;
                que.offer(cur * 2);
            }
        }

        System.out.println(arr[k]);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
