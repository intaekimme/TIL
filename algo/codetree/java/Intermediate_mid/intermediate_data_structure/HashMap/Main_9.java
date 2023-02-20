package Intermediate_mid.intermediate_data_structure.HashMap;

import java.io.*;
import java.util.*;

/**
 * 순서를 바꾸었을 때 같은 단어 그룹화하기
 * 단어를 char[]로 받고 그것을 정렬한 것을 키로 사용
 */
public class Main_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            Arrays.sort(input);

            // System.out.println(Arrays.toString(alph));

            String key = new String(input);
            int cnt = map.getOrDefault(key, 0) + 1;
            max = Math.max(max, cnt);
            map.put(key, cnt);
        }

        System.out.println(max);
    }// end of main

}// end of class
