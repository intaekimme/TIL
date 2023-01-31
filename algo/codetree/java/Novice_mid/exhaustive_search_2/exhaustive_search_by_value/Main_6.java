package Novice_mid.exhaustive_search_2.exhaustive_search_by_value;

import java.io.*;

/**
 * 빙산의 일각 2
 * 
 * 시뮬레이션으로 풀음
 * 해수면의 높이를 1 ~ 빙산 최대 높이까지 움직여 보며
 * 
 * 수면 위에 존재하는 빙산들을 카운트
 * 한 덩어리 빙산 확인 방법
 * 해수면 위로 존재하는 빙산을 발견하면
 * 해수면을 찾을 때까지 빙산을 제거하며 이동, 해수면을 찾으면 한덩어리 카운트
 * 
 * 이후 반복에서는 빙산이 존재하지 않으므로 새로운 빙산을 찾기 전까지 카운트 안됨
 */
public class Main_6 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 2];

        int h_max = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            h_max = h_max < arr[i] ? arr[i] : h_max;
        }

        int ans = -1;

        // 해수면 높이 조정
        for (int h = 1; h <= h_max; h++) {
            int[] next = new int[n + 2];
            System.arraycopy(arr, 0, next, 0, n + 2);
            for (int i = 1; i <= n; i++) {
                next[i] -= h;
            }

            int cnt = 0;
            // 빙산 확인
            for (int i = 1; i <= n; i++) {
                // 빙산이 발견되면
                if (next[i] > 0) {
                    // 해수면을 찾기전까지 제거
                    for (int j = i + 1; j <= n + 1; j++) {
                        if (next[j] <= 0) {
                            cnt++;
                            break;
                        }
                        next[j] = 0;
                    }
                }
            }

            ans = Math.max(ans, cnt);
        } // end of for

        System.out.println(ans);
    }
}
