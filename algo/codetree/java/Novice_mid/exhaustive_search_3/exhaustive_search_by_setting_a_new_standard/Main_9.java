package Novice_mid.exhaustive_search_3.exhaustive_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

public class Main_9 {

    static final int MAX = 1_000_000;

    static int N, K;

    static int[] arr;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        map = new int[MAX + 1];
        Arrays.fill(map, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (map[arr[i]] != Integer.MAX_VALUE)
                map[arr[i]]++;
            else
                map[arr[i]] = 0;
        }

        for (int i = 0; i < N - K; i++) {
            if (arr[i] == 0)
                continue;

            int val = arr[i];
            for (int j = 1; j <= K; j++) {
                if (val == arr[i + j]) {
                    map[val]--;
                    arr[i] = 0;
                    arr[i + j] = 0;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = MAX; i >= 0; i--) {
            if (map[i] == 0) {
                res = i;
                break;
            }
        }

        if (res == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(res);
    }
}
