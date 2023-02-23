package Intermediate_mid.intermediate_data_structure.TreeSet;

import java.io.*;
import java.util.*;

public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        TreeSet<Integer> set = new TreeSet<>();

        String query;
        int val = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            query = st.nextToken();
            if (st.hasMoreTokens()) {
                val = Integer.parseInt(st.nextToken());
            }

            if (query.equals("add"))
                set.add(val);
            if (query.equals("remove"))
                set.remove(val);
            if (query.equals("find"))
                sb.append(set.contains(val) ? "true" : "false").append("\n");
            if (query.equals("lower_bound"))
                sb.append(set.ceiling(val) != null ? set.ceiling(val) : "None").append("\n");
            if (query.equals("upper_bound"))
                sb.append(set.higher(val) != null ? set.higher(val) : "None").append("\n");
            if (query.equals("largest"))
                sb.append(set.isEmpty() ? "None" : set.last()).append("\n");
            if (query.equals("smallest"))
                sb.append(set.isEmpty() ? "None" : set.first()).append("\n");
        }

        System.out.println(sb.toString());

    }// end of main

}// end of class
