package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

public class Main_7_1 {

    static int N, H, T;

    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < N - T; i++) {
            int sum = 0;
            for (int j = 0; j < T; j++) {
                sum += Math.abs(map[i + j] - H);
            }
            res = Math.min(res, sum);
        }

        System.out.println(res);
    }
}
