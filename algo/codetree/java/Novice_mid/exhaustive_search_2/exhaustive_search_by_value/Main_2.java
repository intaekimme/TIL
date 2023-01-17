package Novice_mid.exhaustive_search_2.exhaustive_search_by_value;

import java.io.*;
import java.util.*;

/**
 * 데이터센터의 온도 조정 2
 */
public class Main_2 {

    static int[] arr;
    static int n, c, g, h;
    static final int MAX_LEN = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[MAX_LEN + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ta = Integer.parseInt(st.nextToken());
            int tb = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= MAX_LEN; j++) {
                if (j < ta)
                    arr[j] += c;
                else if (ta <= j && j <= tb)
                    arr[j] += g;
                else if (j > tb)
                    arr[j] += h;
            }
        }

        int max = -1;
        for (int i = 0; i <= MAX_LEN; i++) {
            max = max < arr[i] ? arr[i] : max;
        }

        System.out.println(max);
    }
}
