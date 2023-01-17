package complete_search_by_number_of_digits;

import java.io.*;
import java.util.*;

/**
 * 구해야 하는 것 : 체크포인트 한개를 건너 뛴 완주 거리
 * 원래 완주 거리 = 1번 체크포인트부터 N번 체크 포인트까지 순서대로 구한 맨해튼 거리의 합
 * 
 * 제약사항
 * 1. 1번과 N번 체크포인트는 건너 뛰지 않는다.
 * 2. 체크포인트는 1개만 건너 뛸 수 있다. 그 이상은 안된다.
 * 3. 체크포인트는 겹쳐질 수 있다.
 * 
 */
public class Main_riding_a_taxi_in_the_middle_of_a_marathon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 체크 포인트 갯수

        StringTokenizer st;

        int[] x = new int[n + 1]; // x 좌표
        int[] y = new int[n + 1]; // y 좌표

        // 1번부터 n번까지의 체크포인트 입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());

        } // end of for

        int min = Integer.MAX_VALUE; // 정답 : 체크 포인트 한개 건너뛴 완주 거리 최솟값, 초기값 : int 최댓값

        // 1번 체크포인트와 n번 체크포인트는 건너 뛰지 않으므로
        // 2번부터 확인, n-1 까지확인
        // i : 현재 건너뛴 체크 포인트
        for (int i = 2; i < n; i++) {
            int dis = 0;

            // 빼먹은 코드
            int prevIdx = 1; //

            // 맨해튼 거리 계산.
            for (int j = 2; j <= n; j++) {
                // 빼기로한 체크 포인트
                if (i == j) {
                    continue;
                }
                dis += getDistance(x[j], y[j], x[prevIdx], y[prevIdx]);
                prevIdx = j;
            }
            min = Math.min(min, dis); // 이전 최대 거리보다 새로 계산한 거리가 최소인 경우 갱신
        }

        System.out.println(min); // 정답 출력

    }// end of main

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    } // end of getDistance

}// end of class

class Point {
    int x;
    int y;
    int cnt = 0; // 해당 좌표로 된 체크포인트 갯수, 초깃값 0

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }
}
