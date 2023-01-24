package boj;

import java.io.*;
import java.util.*;

/**
 * n과 m (7) 15656
 * 서로 다른 자연수
 * 같은 수 중복 허용
 * 
 */
public class Main {

    static final int MAX_N = 7;

    static int n, m;
    static int[] arr = new int[MAX_N];
    static int[] record = new int[MAX_N];

    static StringBuilder sb = new StringBuilder();

    public static void func(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(record[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            record[depth] = arr[i];
            func(depth + 1);
        }
    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        func(0);

        System.out.print(sb.toString());
    }// end of main
}// end of class
