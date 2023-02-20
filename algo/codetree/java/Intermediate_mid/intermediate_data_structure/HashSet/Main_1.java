package Intermediate_mid.intermediate_data_structure.HashSet;

import java.io.*;
import java.util.*;

/**
 * hashset 기본
 */

public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String query = st.nextToken();
            int val = Integer.parseInt(st.nextToken());

            if (query.equals("find"))
                sb.append(set.contains(val) ? "true" : "false").append("\n");
            if (query.equals("add"))
                set.add(val);
            if (query.equals("remove"))
                set.remove(val);
        }

        System.out.println(sb.toString());

    }// end of main

}// end of class
