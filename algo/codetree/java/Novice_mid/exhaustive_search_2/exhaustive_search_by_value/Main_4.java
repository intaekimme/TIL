package Novice_mid.exhaustive_search_2.exhaustive_search_by_value;

import java.io.*;
import java.util.*;

/**
 * 정보에 따른 숫자 2
 * 
 * 정해진 범위에서 최단 거리를 '시뮬레이션'으로 찾음
 */
public class Main_4 {
    static final int MAX_LEN = 1000;

    static int T, a, b;
    static char[] arr = new char[MAX_LEN + 1];
    static int ans = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int pos = Integer.parseInt(st.nextToken());

            arr[pos] = c;
        }
    }// end of init

    // 범위 내 존재하는지 판단
    public static boolean inRange(int x) {
        return 1 <= x && x <= MAX_LEN;
    }

    /*
     * 특별한 위치 x로부터 양옆에 찾아야하는 알파벳이 최초 등장하는 순간의 거리 반환
     */
    public static int findMin(int x, char find) {
        int x1 = x - 1;
        int x2 = x + 1;
        while (true) {
            x1++;
            x2--;

            if (inRange(x1) && arr[x1] == find)
                return Math.abs(x1 - x);
            if (inRange(x2) && arr[x2] == find)
                return Math.abs(x2 - x);
            if (!inRange(x1) && !inRange(x2))
                break;
        }
        return 0;
    }// end of findMin

    public static void sol() {
        for (int x = a; x <= b; x++) {
            int d1 = findMin(x, 'S');
            int d2 = findMin(x, 'N');

            if (d1 <= d2)
                ans++;
        }
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}