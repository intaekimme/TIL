package array_record;

import java.io.*;
import java.util.*;
import java.lang.Math;

/**
 * 로봇이 1초에 한 칸씩 움직인다.
 * 구하는 것 : 로봇 A와 B가 바로 직전에는 다른 위치에 있다가 그 다음 번에 같은 위치에 오게 되는 경우
 * 유의사항 : 한 로봇이 정지한 이 후 다른 로봇의 움직임에 의해 겹치는 것도 카운트해야함.
 * 
 * 배열 기록
 * 인덱스 : 매 초
 * 값 : 해당 초에서 위치(음수 가능)
 */

public class Main_robot_moving_left_and_right {

    static final int MAX_TIME = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[MAX_TIME + 1];
        int[] B = new int[MAX_TIME + 1];

        int timeA = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            if (dir.equals("L"))
                for (int j = 0; j < s; j++) {
                    A[timeA] = A[timeA - 1] - 1;
                    timeA++;
                }
            else
                for (int j = 0; j < s; j++) {
                    A[timeA] = A[timeA - 1] + 1;
                    timeA++;
                }

        }

        int timeB = 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            if (dir.equals("L"))
                for (int j = 0; j < s; j++) {
                    B[timeB] = B[timeB - 1] - 1;
                    timeB++;
                }
            else
                for (int j = 0; j < s; j++) {
                    B[timeB] = B[timeB - 1] + 1;
                    timeB++;
                }

        }

        // A 움직임 종료 이후
        for (int j = timeA; j < MAX_TIME; j++) {
            A[j] = A[timeA - 1];
        }
        // B 움직임 종료 이후
        for (int j = timeB; j < MAX_TIME; j++) {
            B[j] = B[timeB - 1];
        }
        int ans = 0;
        int limit = Math.max(timeA, timeB);
        for (int i = 2; i < limit; i++) {
            if (A[i - 1] != B[i - 1] && A[i] == B[i])
                ans++;
        }

        System.out.println(ans);

    }
}
