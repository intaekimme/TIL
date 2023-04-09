package boj.bruteforce;

import java.io.*;
import java.util.*;

/**
 * 1059 좋은 구간 s4
 * sol
 */

public class Main_1059 {

    static int cnt = 0;

    public static void dfs(int depth, int s, int e, int[] selected, int n) {
        if (depth == 2) {
            // A <= x <= B
            int A = selected[0];
            int B = selected[1];
            for (int x = A; x <= B; x++) {
                // A <= x <= B 이면 조건을 만족하는 좋은 구간
                if (x == n) {
                    // System.out.println(selected[0] + " " + selected[1]);
                    cnt++;
                    return;
                }
            }
            return;
        }

        // 가능한 구간 선정
        // s(S[i])보다 큰 값과 e(S[i + 1]) 보다 작은값, 왜냐하면 x 가 집합 S에 속하지 않으므로
        for (int cand = s + 1; cand < e; cand++) {
            selected[depth] = cand;
            dfs(depth + 1, cand, e, selected, n);
        }
    }// end of dfs

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집합을 입력 받는다.
        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        // 집합 정렬
        Arrays.sort(arr);

        int[] tmp = new int[L + 1];
        // 집합의 최솟값이 1이 아니라면, 최솟값보다 작은값을 구간의 시작으로 잡고 확인할 때 정수 x가 포함될 수 있음
        // 아래 예시 참조
        // 그러므로 1이 아니면 최솟값을 0을 추가
        if (arr[0] != 1) {
            // 임시 배열에 복사
            for (int i = 1; i < tmp.length; i++)
                tmp[i] = arr[i - 1];

            // 원본 배열 크기 재설정
            arr = new int[L + 1];

            // 원복
            for (int i = 0; i < arr.length; i++)
                arr[i] = tmp[i];
        }

        int[] selected = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            int s = arr[i];
            int e = arr[i + 1];

            // 구간의 시작을 s, e로 하는 경우에 가능한 모든 구간 찾기
            dfs(0, s, e, selected, n);
        }

        System.out.println(cnt);
    }// end of main
}// end of class

// 예시
// 3
// 7 8 9
// 2
// ans : 9
// [1 2], [1 3], [1 4], [1 5], [1 6], [2 3], [2 4], [2 5], [2 6]