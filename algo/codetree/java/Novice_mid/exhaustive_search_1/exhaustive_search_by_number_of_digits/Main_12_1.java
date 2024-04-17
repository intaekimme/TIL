package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;

public class Main_12_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isMagicNumber(arr[i], arr[j], arr[k])) {
                        int sum = Integer.parseInt(arr[i]) + Integer.parseInt(arr[j]) + Integer.parseInt(arr[k]);
                        max = Math.max(max, sum);

                        // System.out.println(arr[i] + ", " + arr[j] + ", " + arr[k] + ", " + sum);
                    }
                }
            }
        }

        if (max != 0)
            System.out.println(max);
        else
            System.out.println(-1);
    }// end of main

    public static boolean isMagicNumber(String a, String b, String c) {
        char[] crr_a = new char[] { '0', '0', '0', '0', '0' };
        char[] crr_b = new char[] { '0', '0', '0', '0', '0' };
        char[] crr_c = new char[] { '0', '0', '0', '0', '0' };

        for (int i = a.length() - 1, j = 4; i >= 0; i--, j--) {
            crr_a[j] = a.charAt(i);
        }

        for (int i = b.length() - 1, j = 4; i >= 0; i--, j--) {
            crr_b[j] = b.charAt(i);
        }

        for (int i = c.length() - 1, j = 4; i >= 0; i--, j--) {
            crr_c[j] = c.charAt(i);
        }

        for (int i = 4; i >= 0; i--) {
            if ((crr_a[i] - '0') + (crr_b[i] - '0') + (crr_c[i] - '0') >= 10)
                return false;
        }

        return true;
    }
}// end of class
