package complete_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

/**
 * 훌륭한 점프
 */
public class Main_5 {

    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for (int a = Math.max(arr[0], arr[n - 1]); a <= 100; a++) {
            if (isPossible2(a))
                min = a < min ? a : min;
        }

        System.out.println(min);

    }// end of main

    public static boolean isPossible(int maxVal) {
        int[] availableIndices = new int[n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= maxVal)
                availableIndices[cnt++] = i;
        }

        for (int i = 1; i < cnt; i++) {
            int dist = availableIndices[i] - availableIndices[i - 1];
            if (dist > k)
                return false; // 가능한 모든 경우가 k이내로 점프하는 것을 반복해서 도달해야 함. 그렇지 않으면 잘못된 방법으로 도달. 따라서 early return으로
                              // 처리
        }

        return true;
    } // end of isPossible

    public static boolean isPossible2(int maxVal) {
        // 마지막 index로 부터
        // 숫자 limit을 넘지 않으면서
        // 거리 k이내로 계속 이동이 가능한지를 판단
        int lastIdx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= maxVal) {
                if (i - lastIdx > k)
                    return false;
                lastIdx = i;
            }
        }

        return true;
    }

}// end of class
