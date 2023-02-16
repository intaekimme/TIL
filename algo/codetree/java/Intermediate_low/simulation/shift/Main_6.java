package Intermediate_low.simulation.shift;

import java.io.*;

/**
 * 최단 Run Length 인코딩
 */

public class Main_6 {

    static char[] crr;

    public static void shift() {
        char temp = crr[crr.length - 1];

        for (int i = crr.length - 1; i > 0; i--)
            crr[i] = crr[i - 1];

        crr[0] = temp;

        // System.out.println(Arrays.toString(crr));
    }// end of shift

    public static int getRunLengthEncoding() {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        sb.append(crr[0]);
        for (int i = 1; i < crr.length; i++) {
            if (crr[i] != crr[i - 1]) {
                sb.append(cnt).append(crr[i]);
                cnt = 1;
                continue;
            }
            cnt++;
        }
        sb.append(cnt);

        String res = sb.toString();
        // System.out.println(res);
        return res.length();
    }// end of getRunLengthEncoding

    public static void sol() {
        int ans = 20;
        for (int i = 1; i <= crr.length; i++) {
            shift();
            ans = Math.min(ans, getRunLengthEncoding());
        }
        System.out.println(ans);
    }// end of sol

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        crr = br.readLine().toCharArray();

        sol();
    }// end of main

}// end of class