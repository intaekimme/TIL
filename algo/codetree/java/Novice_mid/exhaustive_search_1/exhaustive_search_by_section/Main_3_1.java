package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

public class Main_3_1 {

    static int N;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double sum = 0;
                for (int k = i; k <= j; k++)
                    sum += arr[k];

                double mean = sum / (Math.abs(i - j) + 1);

                for (int k = i; k <= j; k++)
                    if (arr[k] == mean) {
                        cnt++;
                        break;
                    }
            }
        }

        System.out.println(cnt);
    }
}
