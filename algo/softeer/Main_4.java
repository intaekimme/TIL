package softeer;

import java.util.*;
import java.io.*;

/**
 * 21년 재직자 대회 예선
 * 전광판
 */
public class Main_4 {

    static String[] numbers = new String[] { "1111110", "0011000", "0110111", "0111101", "1011001", "1101101",
            "1101111", "1111000", "1111111", "1111101" };
    static int t;
    static String a, b;

    StringBuilder sb = new StringBuilder();

    public static String[] initBubbles() {
        return new String[] { "0000000", "0000000", "0000000", "0000000", "0000000", "0000000" };
    }// end of initBubbles

    public static int getCount(String from, String to) {
        int cnt = 0;
        for (int i = 0; i < 7; i++) {
            if (from.charAt(i) == to.charAt(i))
                continue;
            cnt++;
        }
        return cnt;
    }// end of getCount

    public static void sol(String a, String b) {
        String[] from = initBubbles();
        String[] to = initBubbles();

        // a -> from
        int idx = 4;
        for (int i = a.length() - 1; i >= 0; i--) {
            from[idx--] = numbers[a.charAt(i) - '0'];
        }

        // b -> to
        idx = 4;
        for (int i = b.length() - 1; i >= 0; i--) {
            to[idx--] = numbers[b.charAt(i) - '0'];
        }

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            cnt += getCount(from[i], to[i]);
        }

        System.out.println(cnt);

    }// end of sol

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();

            sol(a, b);
        }

    }// end of main
}// end of class