package reasoning_about_what_happened;

import java.io.*;
import java.util.*;

/**
 * 비둘기와 전깃줄
 */

public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[11][3]; // 비둘기, 0열 : 비둘기 위치, 1열 : 건넌 횟수, 2열 : 관측정보
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 비둘기 번호
            int position = Integer.parseInt(st.nextToken()); // 비둘기 위치

            // 최초 관측이면 위치만 기록
            if (arr[num][2] == 0) {
                arr[num][0] = position;
                arr[num][2]++;
                continue;
            }
            // 최초 관측이 아니면 관측중인 비둘기
            // 관측중인 비둘기 위치가 변경되었으면 위치 기록 후 건넌횟수 증가
            if (arr[num][0] != position) {
                arr[num][0] = position;
                arr[num][1]++;
                arr[num][2]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= 10; i++) {
            ans += arr[i][1];
        }

        System.out.println(ans);
    }// end of main

}// end of class
