package array_record;

import java.io.*;
import java.util.*;

/**
 * A가 최대 이동할 수 있는 시간 = 1000
 * 
 * @param args
 * @throws IOException
 */

public class Main_keep_the_lead {

    static final int MAX_TIME = 1000 * 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[MAX_TIME + 1]; // 인덱스 : 시간 (t), 값 : 속도 v로 1초 이동한 후 거리
        int[] B = new int[MAX_TIME + 1]; // 인덱스 : 시간 (t), 값 : 속도 v로 1초 이동한 후 거리

        // A입력
        int timeA = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            // t초 동안 움직임
            for (int j = 0; j < t; j++) {
                A[timeA] = A[timeA - 1] + v; // timaA초에서 이동거리 = 1초전 이동 거리 + 속도
                timeA++; // 1초 증가.
            }
        }

        // B입력
        int timeB = 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            // t초 동안 움직임
            for (int j = 0; j < t; j++) {
                B[timeB] = B[timeB - 1] + v; // timaB초에서 이동거리 = 1초전 이동 거리 + 속도
                timeB++; // 1초 증가
            }
        }

        int leader = 0; // A가 리더 1, B가 리더 2
        int ans = 0; // 순서가 바뀐 경우
        for (int t = 1; t <= MAX_TIME; t++) {
            if (A[t] > B[t]) { // A가 리더가 되거나, A가 계속 선두였던 경우
                if (leader == 2) // A가 리더가 되는 경우
                    ans++; // 바뀐 경우 체크

                // A가 계속 선두인 경우
                leader = 1;
                continue;
            }
            if (A[t] < B[t]) { // B가 리더가 되거나, B가 계속 선두였던 경우
                if (leader == 1) // B가 리더가 되는 경우
                    ans++; // 바뀐 경우 체크

                // B가 계속 선두인 경우
                leader = 2;
            }

        }

        System.out.println(ans);
    }
}
