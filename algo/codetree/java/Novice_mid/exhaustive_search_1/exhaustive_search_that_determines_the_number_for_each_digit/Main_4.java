package Novice_mid.exhaustive_search_1.exhaustive_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

/**
 * 숫자 카운트
 */

public class Main_4 {

    static final int MAX_N = 10;

    static int n;
    static int ans = 0;
    static int[] brr = new int[MAX_N];
    static int[] one_cnt = new int[MAX_N];
    static int[] two_cnt = new int[MAX_N];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            brr[i] = Integer.parseInt(st.nextToken());
            one_cnt[i] = Integer.parseInt(st.nextToken());
            two_cnt[i] = Integer.parseInt(st.nextToken());
        }

    }// end of init

    // B가 말한 세 자리 수에 있는 숫자들 중 하나가 A가 생각한 세 자리의 수의 동일한 자리에 위치하면 1번 카운트를 하나 올라간다.
    public static boolean checkOne(int idx, int num) {
        int cnt = 0;

        String b = Integer.toString(brr[idx]);
        String a = Integer.toString(num);

        for (int i = 0; i < 3; i++) {
            if (b.charAt(i) == a.charAt(i))
                cnt++;
        }

        if (cnt == one_cnt[idx])
            return true;
        return false;

    }// end of checkOne

    // B가 말한 세 자리 수에 있는 숫자들 중 하나가 A가 생각한 세 자리 수에 있긴 하나 다른 자리에 위치하면 2번 카운트가 하나 올라간다.
    public static boolean checkTwo(int idx, int num) {
        int cnt = 0;

        String b = Integer.toString(brr[idx]);
        String a = Integer.toString(num);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && b.charAt(i) == a.charAt(j)) {
                    cnt++;
                    break;
                }
            }
        }

        if (cnt == two_cnt[idx])
            return true;
        return false;

    }// end of checkTwo

    public static void sol() {
        int num = 0;
        // 모든 숫자를 다 만들어 봄.
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    // 각 자리가 모두 다른지 확인
                    if (i == j || j == k || i == k)
                        continue;

                    // A가 생각한 수
                    num = i * 100 + j * 10 + k;
                    int cnt = 0;
                    // A가 생각한 수가 B가 생각한 수의 경우와 모두 같은지 확인
                    for (int l = 0; l < n; l++) {
                        if (!checkOne(l, num))
                            break;
                        if (!checkTwo(l, num))
                            break;
                        cnt++;
                    }

                    // 경우가 모두 일치하면 정답 + 1
                    if (cnt == n) {
                        // System.out.println(num);
                        ans++;
                    }
                }
            }
        }
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}
