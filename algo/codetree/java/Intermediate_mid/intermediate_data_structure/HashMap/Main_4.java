package Intermediate_mid.intermediate_data_structure.HashMap;

import java.io.*;
import java.util.*;

/**
 * 대응되는 수와 문자
 */
public class Main_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            map1.put(i, str);
            map2.put(str, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String cur = br.readLine();
            try {
                int key = Integer.parseInt(cur);
                sb.append(map1.get(key)).append("\n");
            } catch (Exception e) {
                sb.append(map2.get(cur)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }// end of main

}// end of class