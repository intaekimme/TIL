package picking_out_a_good_strategy;

import java.io.*;
import java.util.*;

/**
 * 연속된 숫자 만들기 2
 * 와....이거 진짜 모르겠다
 */
public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int p3 = Integer.parseInt(st.nextToken());

    }// end of main

    // 재귀로 찾아야 하나...?
    public static int recur(int p1, int p2, int p3, int cnt) {
        if (p1 < p2 && p2 < p3) {
            return cnt;
        }

    }

}// end of class
