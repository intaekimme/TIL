package Novice_mid.exhaustive_search_2.exhaustive_search_by_value;

import java.io.*;
import java.util.*;

/**
 * 정보에 따른 숫자 2
 * 
 * 각 문자별 위치정보를 기록
 * 매 특별한 위치마다 모든 위치정보를 확인하며 최소거리 갱신
 * 
 * 도출된 S와 N의 최소거리를 비교
 */
public class Main_4 {
    static final int MAX_N = 100;

    static int T, a, b;
    static int[] s = new int[MAX_N];
    static int[] n = new int[MAX_N];

    static int ans = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int sCnt = 0;
        int nCnt = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int pos = Integer.parseInt(st.nextToken());

            if (c == 'S')
                s[sCnt++] = pos;
            else
                n[nCnt++] = pos;
        }
    }// end of init

    public static void sol() {
        for (int x = a; x <= b; x++) {

            int d1 = Integer.MAX_VALUE;
            int d2 = Integer.MAX_VALUE;
            for (int i = 0; i < T; i++) {
                d1 = Math.min(d1, Math.abs(s[i] - x));
                d2 = Math.min(d2, Math.abs(n[i] - x));
            }

            if (d1 <= d2)
                ans++;
        }

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }
}