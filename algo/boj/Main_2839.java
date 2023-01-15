package boj;

import java.io.*;
import java.util.*;

/**
 * DP + 그리디 접근
 * 찾아야 하는 무게가 n일 때 n보다 적은 무게 t와 n보다 t만큼 적은 무게 n - t의 합으로 무게 n을 만들 수 있으면
 * 가장 적은 적은 봉지를 들여 무게 n을 만들 수 있다.
 */
public class Main_2839 {

    static final int MAX_LEN = 5000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[MAX_LEN + 1];
        // 가장 무거운 무게로 초기화
        Arrays.fill(arr, Integer.MAX_VALUE);

        arr[1] = -1;
        arr[2] = -1;
        arr[3] = 1;
        arr[4] = -1;
        arr[5] = 1;

        // 1 <= n <= 4 는 바로 출력
        if (n <= 5) {
            System.out.println(arr[n]);
            System.exit(0);
        }

        for (int i = 6; i <= n; i++) {
            int t = i - 3; // 찾아야 하는 무게보다 최소한 3은 작아야 봉지가 가능함.
            // 무게 t와 n - t의 차가 같아질 때 까지 반복
            while (t >= i - t) {
                // 무게 t 또는 n - t가 불가능하면
                if (arr[t] < 0 || arr[i - t] < 0) {
                    t--; // 더 적은 무게 확인
                    continue;
                }
                // 무게 t의 봉지 수와 무게 n - t의 봉지 수가 현재 봉지 수보다 적으면 갱신, 아니면 그대로
                arr[i] = arr[t] + arr[i - t] < arr[i] ? arr[t] + arr[i - t] : arr[i];
                t--; // 가능한게 있을 수 있으므로 무게를 줄여서 확인...(1)
            }
            // 한 번도 갱신이 안됐으면 불가능 하므로 -1
            arr[i] = arr[i] != Integer.MAX_VALUE ? arr[i] : -1;
        }
        // 정답 출력
        System.out.println(arr[n]);

        sc.close();
    }
}
