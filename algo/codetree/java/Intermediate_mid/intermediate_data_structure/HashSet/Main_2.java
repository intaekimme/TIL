package Intermediate_mid.intermediate_data_structure.HashSet;

import java.io.*;
import java.util.*;

/**
 * 데이터 비교
 */
public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(st.nextToken());
            sb.append(set.contains(val) ? 1 : 0).append(" ");
        }

        System.out.println(sb.toString());

    }// end of main

}// end of class
