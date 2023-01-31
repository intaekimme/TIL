package Novice_mid.exhaustive_search_2.exhaustive_search_by_value;

import java.io.*;

/**
 * 흥미로운 숫자 2
 */
public class Main_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int ans = 0;
        for (int i = x; i <= y; i++) {
            if (isMagicNumber(i))
                ans++;
            // System.out.println(i);
        }

        System.out.println(ans);
    }// end of main

    public static boolean isMagicNumber(int n) {
        int[] number_cnt = new int[10];

        int digit = 0; // 현재 판단중인 수의 자릿수
        while (true) {
            if (n < 10) {
                number_cnt[n]++;
                digit++;
                break;
            }
            number_cnt[n % 10]++;
            n /= 10;
            digit++;
        }

        // System.out.println(Arrays.toString(number_cnt));

        for (int i = 0; i < 10; i++)
            if (number_cnt[i] == digit - 1) // 흥미로운 수는 같은 수가 자릿수 - 1개가 존재하는 수
                return true;
        return false;

    }// end of isMagicNumber

}// end of class
