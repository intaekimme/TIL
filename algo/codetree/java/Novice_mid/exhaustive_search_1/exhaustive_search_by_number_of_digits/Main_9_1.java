package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;

public class Main_9_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int len = input.length();

        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == '(' && i + 1 < len && input.charAt(i + 1) == '(') {
                for (int j = i + 2; j < len; j++) {
                    if (input.charAt(j) == ')' && j + 1 < len && input.charAt(j + 1) == ')')
                        cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}