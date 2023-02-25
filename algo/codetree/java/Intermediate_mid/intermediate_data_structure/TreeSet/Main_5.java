package Intermediate_mid.intermediate_data_structure.TreeSet;

import java.io.*;
import java.util.*;

/**
 * 최대 숫자 구하기
 */

public class Main_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= m; i++)
            set.add(i);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (set.contains(val))
                set.remove(val);
            System.out.println(set.last());
        }

    }// end of main

}// end of class