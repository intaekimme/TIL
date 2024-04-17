package boj.simulation;

import java.io.*;
import java.util.*;

public class Main {

    static int N, B, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long sum = 0;

        for (int i = 0; i < N; i++) {
            long res = arr[i] - B <= 0 ? 1
                    : 1 + ((arr[i] - B) > C ? (arr[i] - B) / C + 1 : (arr[i] - B) == C ? (arr[i] - B) / C : 1);

            sum += res;
        }

        System.out.println(sum);
    }// end of main
}// end of class
