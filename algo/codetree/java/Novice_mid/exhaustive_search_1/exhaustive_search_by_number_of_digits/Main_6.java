package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] a = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            a[i] = input.charAt(i) - '0';
        }

        int max = 0;
        if (a.length > 1) {
            for (int id = 1; id < a.length; id++) {

                int subMax = 0;

                int arr[] = new int[a.length];
                System.arraycopy(a, 0, arr, 0, a.length);

                arr[id] = arr[id] == 1 ? 0 : 1;

                for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
                    subMax += arr[i] * (int) Math.pow(2, j);
                }

                max = max < subMax ? subMax : max;
            }
        }

        System.out.println(max);
    }
}
