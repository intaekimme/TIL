package Intermediate_mid.shorten_time_technique.grid_compression;

import java.io.*;
import java.util.*;

/**
 * 점 개수 세기 3_fail
 */

public class Main_1 {

    static int n, q;
    static HashMap<Integer, Integer> mapper = new HashMap<>();
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        input = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            input[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(input);

        for (int i = 0; i < n; i++)
            mapper.put(input[i], i + 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int s_val = mapper.get(s);
            int e_val = mapper.get(e);

            sb.append(e_val - s_val + 1).append("\n");
        }

        System.out.println(sb.toString());
    }// end of main

}// end of class