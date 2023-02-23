package Intermediate_mid.intermediate_data_structure.TreeSet;

import java.io.*;
import java.util.*;

/**
 * 숫자 빠르게 찾기 2
 */

public class Main_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(br.readLine());
            if (set.ceiling(val) == null)
                sb.append(-1).append("\n");
            else
                sb.append(set.ceiling(val)).append("\n");
        }

        System.out.println(sb.toString());

    }// end of main

}// end of class