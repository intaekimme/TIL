package Intermediate_mid.intermediate_data_structure.TreeSet;

import java.io.*;
import java.util.*;

/**
 * 가까운 숫자
 */

public class Main_6 {

    static final int MAX = (int) 1e9 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();

        set.add(0);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min_dist = MAX;
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());

            set.add(val);

            int up_dist = MAX;
            int down_dist = MAX;

            // 위 거리 측정하기
            if (set.higher(val) != null)
                up_dist = Math.abs(set.higher(val) - val);

            // 아래 거리 측정하기
            down_dist = Math.abs(set.lower(val) - val);

            min_dist = Math.min(min_dist, Math.min(up_dist, down_dist));
            // System.out.println(floor + " " + ceiling + " " + min_dist);
            sb.append(min_dist).append("\n");
        }

        System.out.println(sb.toString());
    }// end of main

}// end of class