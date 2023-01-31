package Novice_mid.exhaustive_search_2.exhaustive_search_by_value;

import java.io.*;
import java.util.*;

/**
 * 팰린드롬 수 찾기
 */

public class Main_7 {

    static int ans = 0;

    public static boolean isPalindrome(int x) {
        String number = Integer.toString(x);

        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i))
                return false;
        }
        return true;
    }// end of isPalindrome

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = x; i <= y; i++) {
            if (isPalindrome(i))
                ans++;
        }

        System.out.println(ans);
    }// end of main

}// end of class