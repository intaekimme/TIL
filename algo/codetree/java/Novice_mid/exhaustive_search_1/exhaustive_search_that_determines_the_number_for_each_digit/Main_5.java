package Novice_mid.exhaustive_search_1.exhaustive_search_that_determines_the_number_for_each_digit;

import java.io.*;
import java.util.*;

/**
 * 개발자의 능력 2
 * 정답 코드
 */
public class Main_5 {

    public static int N;
    public static int[] arr;
    public static int[][] team = new int[3][2];
    public static int[] visit = new int[6];
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 1, 0);
        System.out.println(result);
    }

    public static void backtracking(int depth, int count, int cnt) {
        if (cnt == 2) {
            cnt = 0;
        }
        if (depth == 2) {
            count++;
        }
        if (depth == 4) {
            int[] sum = new int[3];
            for (int i = 0; i < 6; i++) {
                if (visit[i] == 0)
                    sum[0] += arr[i];
                if (visit[i] == 1)
                    sum[1] += arr[i];
                if (visit[i] == 2)
                    sum[2] += arr[i];
            }
            int max = Arrays.stream(sum).max().getAsInt();
            int min = Arrays.stream(sum).min().getAsInt();
            result = Math.min(result, Math.abs(max - min));
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (visit[i] != 0)
                continue;
            visit[i] = count;
            team[count][cnt] = arr[i];
            backtracking(depth + 1, count, cnt + 1);
            visit[i] = 0;
        }
    }
}
