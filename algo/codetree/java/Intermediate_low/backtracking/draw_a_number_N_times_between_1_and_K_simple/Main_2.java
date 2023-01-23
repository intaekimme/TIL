package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_simple;

import java.io.*;
import java.util.*;

/**
 * 아름다운 수
 * 1. 규칙에 맞는 수를 생성한다. 중복순열
 * 2. 해당 수가 아름다운 수인지 판별한다.
 * 
 * 결과
 * 1 맞음
 * 2 틀림, 현재 위치부터 뒤에만 보니, 앞에서 이미 만족했어도 뒤에서
 * 
 */
public class Main_2 {

    static final int MAX_N = 10;
    static final int[] digit = new int[MAX_N + 1];
    static int n;
    static int ans = 0;

    public static boolean isBeautifulNumber() {
        boolean[] visited = new boolean[MAX_N + 1];

        // 자리 수 선택
        for (int i = 0; i < n; i++) {
            int num = digit[i]; // 해당 자리에 놓인 수
            int cnt = 0;
            // 해당 자리의 수만큼 같은 수가 있는지 확인
            for (int j = 0; j < num; j++) {
                // 확인하려는 자리가 범위를 넘거나 이미 확인한 수라면 pass
                if (i + j < n && !visited[i + j]) {
                    // 일치하지 않으면 아름다운 수 아님
                    if (num != digit[i + j])
                        return false;
                    else {
                        visited[i + j] = true;
                        cnt++;
                    }
                }
            }
            if (!visited[i] && cnt != num)
                return false;
        }
        return true;
    }

    public static void func(int depth, int cnt) {
        if (depth == n) {
            if (isBeautifulNumber())
                ans++;
            return;
        }

        for (int i = 1; i <= 4; i++) {
            digit[cnt] = i;
            func(depth + 1, cnt + 1);
        }
    }

    public static void sol() {
        func(0, 0);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}// end of class
