package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_get_together {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE; // 최솟값을 구해야 하므로 초깃갑은 int 최댓값

        // i 번째 집에 모일 것이다.
        for (int i = 0; i < n; i++) {
            // i번째 집을 제외한 나머지 사람들이 모일 것이다.

            int dis = 0; // 모든 사람이 i 번째 집에 모일 때 이동한 거리 합.
            for (int j = 0; j < n; j++) {
                // i번째 사람은 자기 집이므로 안 움직여도 됨.
                if (j == i)
                    continue;
                // 나머지 사람들은 움직이여야함.
                dis += Math.abs(i - j) * arr[j]; // 이동 거리 합 = j번째 집과 i번째 집 사이 거리 * j번째 집에 사는 사람의 수
            }

            min = Math.min(min, dis); // 현재까지의 최솟값(min)과 새로 구한 값을 비교해 최솟값을 갱신한다.
        }

        System.out.println(min);
    }
}
