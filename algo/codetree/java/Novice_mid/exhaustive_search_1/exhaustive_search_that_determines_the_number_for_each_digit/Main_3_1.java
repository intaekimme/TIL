package Novice_mid.exhaustive_search_1.exhaustive_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

public class Main_3_1 {

    static int N;

    static int a1, b1, c1, a2, b2, c2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a2 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if ((((Math.abs(a1 - i) <= 2 || Math.abs(a1 - i) >= N - 2) ||
                            (Math.abs(a1 - j) <= 2 || Math.abs(a1 - j) >= N - 2) ||
                            (Math.abs(a1 - k) <= 2 || Math.abs(a1 - k) >= N - 2)) ||
                            ((Math.abs(b1 - i) <= 2 || Math.abs(b1 - i) >= N - 2) ||
                                    (Math.abs(b1 - j) <= 2 || Math.abs(b1 - j) >= N - 2) ||
                                    (Math.abs(b1 - k) <= 2 || Math.abs(b1 - k) >= N - 2))
                            ||
                            ((Math.abs(c1 - i) <= 2 || Math.abs(c1 - i) >= N - 2) ||
                                    (Math.abs(c1 - j) <= 2 || Math.abs(c1 - j) >= N - 2) ||
                                    (Math.abs(c1 - k) <= 2 || Math.abs(c1 - k) >= N - 2)))
                            ||
                            (((Math.abs(a2 - i) <= 2 || Math.abs(a2 - i) >= N - 2) ||
                                    (Math.abs(a2 - j) <= 2 || Math.abs(a2 - j) >= N - 2) ||
                                    (Math.abs(a2 - k) <= 2 || Math.abs(a2 - k) >= N - 2)) ||
                                    ((Math.abs(b2 - i) <= 2 || Math.abs(b2 - i) >= N - 2) ||
                                            (Math.abs(b2 - j) <= 2 || Math.abs(b2 - j) >= N - 2) ||
                                            (Math.abs(b2 - k) <= 2 || Math.abs(b2 - k) >= N - 2))
                                    ||
                                    ((Math.abs(c2 - i) <= 2 || Math.abs(c2 - i) >= N - 2) ||
                                            (Math.abs(c2 - j) <= 2 || Math.abs(c2 - j) >= N - 2) ||
                                            (Math.abs(c2 - k) <= 2 || Math.abs(c2 - k) >= N - 2))))
                        cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
