package boj;

import java.io.*;
import java.util.*;

/**
 * 1235 학생 번호 s4 fail
 */

public class Main_1235 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int ans = 0;

        int len = arr[0].length();
        for (int k = len - 1; k > 0; k--) {
            HashSet<String> set = new HashSet<>();

            boolean flag = true;
            for (int i = 0; i < n; i++) {
                String val = arr[i].substring(k);
                if (set.contains(val)) {
                    flag = false;
                    break;
                }
                set.add(val);
            }
            if (flag) {
                ans = len - k;
                break;
            }
        } // end of for

        System.out.println(ans);
    }// end of main
}
