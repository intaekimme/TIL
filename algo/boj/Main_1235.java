package boj;

import java.io.*;
import java.util.*;

/**
 * 1235 학생 번호 s4 sol
 * 인덱스를 0번까지 이동시키지 않아 틀렸었음
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

        int ans = 1;

        int len = arr[0].length();
        for (int k = len - 1; k >= 0; k--) {
            HashSet<String> set = new HashSet<>();

            boolean flag = true;
            for (int i = 0; i < n; i++) {
                String val = arr[i].substring(k);
                // System.out.print(val + " ");
                if (set.contains(val)) {
                    flag = false;
                    break;
                }
                set.add(val);
            }
            // System.out.println();
            if (flag) {
                break;
            }
            ans++;
        } // end of for

        System.out.println(ans);
    }// end of main
}