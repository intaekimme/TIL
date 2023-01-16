package complete_search_by_section;

import java.io.*;
import java.util.*;

/**
 * 특정 구간의 원소 평균값
 * 평균 계산 시 double로 계산해야함.
 */

public class Main_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        // 모든 구간 계산
        for (int i = 0; i < n; i++) { // 구간의 시작점
            for (int j = i; j < n; j++) { // 구간의 끝점
                // 구간 내 원소 합
                int sum = 0;
                boolean flag = false;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                // 평균
                double mean = (double) sum / (j - i + 1);

                // 구간 내에 평균값과 동일한 원소가 있으면 개수 세주기
                for (int k = i; k <= j; k++) {
                    if (arr[k] == mean) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    ans++;
            }
        }

        System.out.println(ans);

    }// end of main
}
