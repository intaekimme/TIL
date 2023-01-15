package boj;

import java.io.*;
import java.util.*;

/**
 * 2805 S2 나무자르기
 */
public class Main_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색 시작
        // 전처리, 정렬, 오름차순
        Arrays.sort(trees);

        int lo = 0; // 하한 시작
        int hi = trees[trees.length - 1]; // 상한 시작, 나무 최댓값

        // 상한과 하한이 만날 때까지 반복한다, 역전이 되면 그 때 까지 못찾은 것이므로 역전된 상한 값이 정답이 된다.
        while (lo <= hi) {
            int mid = (lo + hi) / 2; // 중간값, 나무를 자를 높이 h

            long sum = 0; // 높이 h로 나무를 자르고 남은 나무들의 길이 합
            // 잘랐을 때 음수면 0으로 누적
            for (int i = 0; i < trees.length; i++) {
                sum += trees[i] - mid >= 0 ? trees[i] - mid : 0;
            }

            // 남은 나무의 길이 합이 내가 필요한 M미터보다 모자르면 좀 더 낮게 잘라야함.
            // 상한 높이 조정
            if (sum < m) {
                hi = mid - 1;
                continue;
            }

            // 남은 나무의 길이 합이 내가 필요한 M미터보다 많으면 좀 더 높이 잘라야 필요한 만큼만 가져갈 수 있음
            // 하한 높이 조정
            if (sum >= m) {
                lo = mid + 1;
            }

        } // end of while

        System.out.println(hi);

    }// end of main

}// end of class
