package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_8_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int dist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int subDist = 0;
            for (int j = 0; j < n; j++) {
                subDist += arr[(i + j) % n] * j;
            }

            dist = subDist < dist ? subDist : dist;
        }

        System.out.println(dist);
    }
}
