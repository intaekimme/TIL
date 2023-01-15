package show_me_the_code;

import java.io.*;
import java.util.*;

/**
 * 최대한 많은 깨달음을 얻기 위해 금을 칠한다
 * 깨달음의 양, 가능한 많은 금색 동상들이 같은 방향
 * = | (왼쪽을 바라보는 금색 돌상의 갯수) - (오른쪽을 바라보는 금색 돌상의 개수) |
 * 절댓값이므로 절댓값이 커지기 위해서는 '두 개의 차가 커야한다'
 * 
 * 
 */

public class Main_a_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l_cnt = Integer.MIN_VALUE; // 왼쪽 연속 칠하기
        int r_cnt = Integer.MIN_VALUE; // 오른쪽 연속 칠하기

        // 왼쪽으로 연속된 동상만 카운트
        for (int i = 0; i < n; i++) {
            if (arr[i] != 1) // 현재 위치의 동상이 왼쪽이 아니면 다음 동상 확인
                continue;
            int cnt = 1; // 각 위치별 연속인 동상의 갯수
            for (int j = i + 1; j < n; j++) {
                if (arr[j - 1] != arr[j])
                    break;
                cnt++;
            }
            l_cnt = Math.max(l_cnt, cnt);
        } // end of 왼쪽 loop

        // 오른쪽으로 연속된 동상만 카운트
        for (int i = 0; i < n; i++) {
            if (arr[i] != 2) // 현재 위치의 동상이 왼쪽이 아니면 다음 동상 확인
                continue;
            int cnt = 1; // 각 위치별 연속인 동상의 갯수
            for (int j = i + 1; j < n; j++) {
                if (arr[j - 1] != arr[j])
                    break;
                cnt++;
            }
            r_cnt = Math.max(r_cnt, cnt);
        } // end of 오른쪽 loop

        int ans = Math.max(l_cnt, r_cnt);
        System.out.println(ans);

    } // end of main

}// end of class
