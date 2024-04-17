package Intermediate_low.simulation.bomb_and_drop;

import java.io.*;
import java.util.*;

public class Main_1_1 {

    static int N;

    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringTokenizer st;
        for (int test = 0; test < 2; test++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int diff = e - s + 1;

            // 빼는 블럭 표시
            for (int i = N - s; i >= N - e; i--) {
                arr[i] = 0;
            }

            int[] tmp = new int[N - diff];
            int tmpRow = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == 0)
                    continue;
                tmp[tmpRow++] = arr[i];
            }

            N = N - diff;
            arr = new int[N];
            System.arraycopy(tmp, 0, arr, 0, N);
        } // end of for

        StringBuilder sb = new StringBuilder();
        sb.append(arr.length).append("\n");
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());

    }// end of main

}// end of class
