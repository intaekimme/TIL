package Intermediate_mid.intermediate_data_structure.HashMap;

import java.io.*;
import java.util.*;

/**
 * 순서를 바꾸었을 때 같은 단어 그룹화하기
 * 단어의 갯수를 카운트한 후 그것을 키로 만들어서 입력
 */
public class Main_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] alph;

        HashMap<String, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            alph = new int[58];
            String input = br.readLine();
            int idx = 0;
            for (int j = 0; j < input.length(); j++) {
                idx = input.charAt(j) - 'A';
                alph[idx]++;
            }

            // System.out.println(Arrays.toString(alph));

            String key = Arrays.toString(alph);
            // System.out.println(map.containsKey(key) ? "Yes" : "No");
            int cnt = map.getOrDefault(key, 0) + 1;
            // System.out.println(cnt);
            max = Math.max(max, cnt);
            map.put(key, cnt);
        }

        System.out.println(max);
    }// end of main

}// end of class
