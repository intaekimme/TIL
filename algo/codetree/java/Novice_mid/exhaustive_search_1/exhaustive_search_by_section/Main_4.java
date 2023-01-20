package Novice_mid.exhaustive_search_1.exhaustive_search_by_section;

import java.io.*;
import java.util.*;

/**
 * 아름다운 수열 2
 * 수열 B의 각 원소들의 순서를 바꿔 나오는 수열을 아름다운 수열이라 함
 * 수열 A에서 길이가 M인 연속 부분 수열들 중 아름다운 수열의 수를 세라
 * 
 * 풀이
 * 아름다운 수열 = B의 순열
 * 길이 M인 연속 부분 수열의 모든 원소가 입력으로 주어진 수열 B의 원소와 모두 일치만하면
 * 연속 부분 수열로 아름다운 수열을 만들 수 있다.
 * 따라서 원소가 존재하는지만 확인한다.
 * 
 */
public class Main_4 {
    static final int MAX_N = 100;

    static int n, m;
    static int ans = 0;
    static int[] a = new int[MAX_N];
    static int[] b = new int[MAX_N];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            b[i] = Integer.parseInt(st.nextToken());

    }// end of init

    public static void sol() {
        int[] check = new int[MAX_N + 1];
        // 모든 구간 시작 지점
        for (int i = 0; i <= n - m; i++) {
            Arrays.fill(check, 0);

            // 시작 지점에서 길이 M인 연속 부분 수열의 원소를 기록
            for (int j = i; j < i + m; j++) {
                check[a[j]]++;
            }

            // 수열 B를 확인하며 기록한 것과 일치하는지 확인
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (check[b[j]] >= 1) {
                    check[b[j]]--;
                    cnt++;
                }
            }

            // 모든 원소(수열 B의 크기)가 일치하면 아름다운 수열이 될 수 있다.
            if (cnt == m)
                ans++;
        }
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}// end of class
