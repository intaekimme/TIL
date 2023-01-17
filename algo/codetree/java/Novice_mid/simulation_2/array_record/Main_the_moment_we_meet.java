package array_record;

import java.io.*;
import java.util.*;
import java.lang.Math;

/**
 * 만나는 그 순간
 * 
 * 로직
 * A와 B의 움직임을 각각 매 초마다 기록한다(배열에)
 * 두 배열을 동시에 순회하며 위치가 같은 순간이 정답이다.
 * 
 * 기록할 배열 사이즈, 단위 초
 * 가능한 최대의 이동 명령 : 1000개
 * 하나의 명령에 가능한 최대 초 : 1000초
 * 
 * 따라서 배열의 사이즈 = 1000 * 1000 = 1_000_000 (백만)
 * 시작위치를 0으로 준다.
 * 
 * R 이면 +1 하고 '기록할 배열[초] = 이동위치' 로 기록
 * L 이면 -1 하고 '기록할 배열[초] = 이동위치' 로 기록
 */

public class Main_the_moment_we_meet {

    static final int MAX_TIME = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[MAX_TIME + 1];
        int[] B = new int[MAX_TIME + 1];

        int start = 0;
        int time = 1;
        int a_time = 0;
        // A 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            a_time += val;

            if (dir.equals("R"))
                for (int t = 0; t < val; t++)
                    A[time++] = ++start;
            else
                for (int t = 0; t < val; t++)
                    A[time++] = --start;
        }

        start = 0;
        time = 1;
        int b_time = 0;
        // B 입력
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            b_time += val;

            if (dir.equals("R"))
                for (int t = 0; t < val; t++)
                    B[time++] = ++start;
            else
                for (int t = 0; t < val; t++)
                    B[time++] = --start;
        }

        int ans = -1;
        int limit = Math.max(a_time, b_time);
        for (int i = 1; i <= MAX_TIME; i++) {
            if (i > limit)
                break;
            if (A[i] == B[i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);

    }
}
