package Intermediate_mid.intermediate_data_structure.TreeSet;

import java.io.*;
import java.util.*;

/**
 * 작지만 큰 숫자
 */

public class Main_14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            set.add(val);
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int res = -1;
            int query = Integer.parseInt(st.nextToken());

            if (set.floor(query) != null) {
                res = set.floor(query);
                set.remove(res);
            }

            sb.append(res).append("\n");
        }

        System.out.println(sb.toString());

    }// end of main

}// end of class