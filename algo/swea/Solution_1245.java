import java.io.*;
import java.util.*;

/**
 * 1245. [S/W 문제해결 응용] 2일차 - 균형점
 * 
 * n개의 자성체가 존재할 때 n-1개의 균형점, 즉 물체에 작용하는 양쪽이 힘이 같은 지점이 존재한다
 * 인력을 구하는 공식 F = G*m1*m2/(d*d), G는 양의 상수 값
 * 
 * 구하는 인력은 자성체와 물체사이에 작용하는 인력이다.
 * 예를들어 4개의 물체가 존재할 때
 * 
 * 
 * |---------d4-------|
 * |-----d3----|
 * |-d1-|-d2-|
 * ------|----|----|------|------|------
 * m1 t m2 m3 m4
 * x1 x2 x3 x4
 * 와 같은 상황이면
 * F1 = sum(F1...F4)
 * m1/|t-x1|^2 = m2/|t-x2|^2 + m3/|t-x3|^2 + m4/|t-x4|^2
 * 인 t를 x1과 x2 사이에서 찾아야 한다.
 * 
 * 좌표값의 오차가 1e-12 이내이므로 시간 내에 찾기 위해서는 시간복잡도가 O(logN)인 이진탐색을 이용한다.
 */
public class Solution_1245 {
    static int n; // n개의 자성체
    static double[] px; // 자성체 x 좌표
    static int[] m; // 자성체 질량

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine()); // TC 케이스 입력
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            n = Integer.parseInt(br.readLine());
            px = new double[n];
            m = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++)
                px[i] = Double.parseDouble(st.nextToken()); // 좌표 입력
            for (int i = 0; i < n; i++)
                m[i] = Integer.parseInt(st.nextToken()); // 질량 입력

            // 1 / 2...n
            // 1,2 / 3...n
            // 1...n-1 / n으로 n개의 자성체를 2그룹으로 나눠 사이마다 균형점 찾기
            for (int i = 0; i < n - 1; i++) {
                // 균형점을 찾는 법은 이진탐색
                String ans = String.format("%.10f", binarySearch(i, px[i], px[i + 1]));
                sb.append(ans).append(" ");
            }
            sb.append("\n");
        } // end of tc

        System.out.println(sb.toString());

    }// end of main

    // 이진탐색
    public static double binarySearch(int pivot, double lo, double hi) {
        double x = 0; // 미지의 균형점 x
        double sum; // 균형점으로 나뉜 좌, 우 자성체들의 인력 합
        int cnt = 0; // 실수 연산이므로 무한루프에 빠질 수 있기에 일정 수 이내로만 연산, double형은 100~200사이면 충분
        while (cnt <= 100) {
            x = (lo + hi) / 2.0; // mid

            sum = 0;
            for (int i = 0; i <= pivot; i++) {
                sum += getForce(i, x); // 좌측 자성체 인력 누적
            }
            for (int i = n - 1; i > pivot; i--) {
                sum -= getForce(i, x); // 우측 자성체 인력으로 상쇄
            }

            if (sum > 0) { // 좌측 인력이 강하므로 균형점을 우측으로 이동시킴
                lo = x;
            } else if (sum < 0) { // 우측인력이 강하므로 좌측으로 이동시킴
                hi = x;
            }
            cnt++; // 연산 횟수 카운트
        }
        return x; // 균형점 반환
    }

    // 인력 계산 함수
    public static double getForce(int i, double x) {
        return m[i] / ((px[i] - x) * (px[i] - x));
    }

}// end of class
