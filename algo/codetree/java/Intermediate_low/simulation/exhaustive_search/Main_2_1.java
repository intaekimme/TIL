package Intermediate_low.simulation.exhaustive_search;

import java.io.*;
import java.util.*;

public class Main_2_1 {

    static int n, m;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행 검사 (반복문)

        // n - 1개의 자리 검사, 마지막 점(n - 1) 제외, 0 ~ n - 2까지 (반복문)

        // 검사하면서 일치한 갯수 변수 sCnt, 시작 1

        // 현재 위치와 다음 위치가 같으면 sCnt += 1

        // 다르면
        // sCnt의 현재까지 센 갯수가 m과 같은지 확인

        // 같으면 행복한 수열 갯수 += 1, 다음행 확인 (자리 반복 종료)

        // 다르면 sCnt = 1로 초기화

        // 열 검사
    }
}
