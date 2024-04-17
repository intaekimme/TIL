package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

/**
 * 두 자리를 정하여 완전탐색 연습문제
 */
public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();

        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == '(') {
                for (int j = i + 1; j < len; j++) {
                    if (input.charAt(j) == ')')
                        cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
