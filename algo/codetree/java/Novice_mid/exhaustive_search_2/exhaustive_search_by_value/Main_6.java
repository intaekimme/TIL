package Novice_mid.exhaustive_search_2.exhaustive_search_by_value;

import java.io.*;

/**
 * 빙산의 일각 2
 * 
 * 시뮬레이션으로 찾지않고
 * 빙산이 발견된 시점만 카운트
 * 
 * 빙산이 발견된 시점 : 이전은 해수면, 현재는 빙산인 경우
 * 이렇게 카운트 시 인덱스 0인 지점을 카운트 못하므로 따로 체크
 */
public class Main_6 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = -1;

        // 해수면 높이 조정
        for (int h = 1; h <= 1000; h++) {
            int cnt = 0;

            // 인덱스 0
            if (arr[0] > 0)
                cnt++;

            // 빙산 확인
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] <= h && arr[i] > h)
                    cnt++;
            }

            ans = Math.max(ans, cnt);
        } // end of for

        System.out.println(ans);
    }
}
