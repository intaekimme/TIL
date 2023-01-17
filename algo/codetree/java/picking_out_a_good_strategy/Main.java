package picking_out_a_good_strategy;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1')
                continue;

            arr[i] = '1';
            max = Math.max(max, getMinDist());
            arr[i] = '0';
        }

        System.out.println(max);

    }// end of main

    public static int getMinDist() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] != '1')
                continue;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == '1' && arr[j] == '1') {
                    min = Math.min(min, j - i);
                    break;
                }
            }
        }
        return min;
    }
}// end of class
