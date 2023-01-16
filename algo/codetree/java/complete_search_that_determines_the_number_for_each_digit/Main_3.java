package complete_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

/**
 * 다이얼 한 조합을 고르고, 그 조합이 기존 조합과 거리가 2이내인지 확인
 * fail 코드
 */
public class Main_3 {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;

        int[] comb1 = new int[3];
        int[] comb2 = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++)
            comb1[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++)
            comb1[2] = Integer.parseInt(st.nextToken());

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if ((i != j && j != k && k != i) && (check(i, j, k, comb1) || check(i, j, k, comb2)))
                        ans++;
                }
            }
        }

        System.out.println(ans);

    }// end of main

    // 주어진 자리가 기존 조합과 거리가 2이내에 존재하는지 확인
    public static boolean check(int i, int j, int k, int[] comb) {
        for (int s = 0; s < n; s++) { // 기준 원소
            for (int t = s - 2; t <= s + 2; t++) { // 원소로부터 좌우 거리 2
                if (t < 0) { // 인덱스 음수 처리
                    // 조합을 기록하고 왜 숫자를 다시 입력받고(comb와 i,j,k)
                    // 그러면서 왜 개별적인 범위에서 체크를 하지?
                    // 문제 이해 못함
                    if (comb[i] == arr[n + t] || comb[j] == arr[n + t] || comb[k] == arr[n + t])
                        return true;
                } else { // 인덱스 양수인 경우
                    if (comb[i] == arr[t] || comb[j] == arr[t] || comb[k] == arr[t])
                        return true;
                }
            }
        }
        return false;
    }// end of check1

}// end of class
