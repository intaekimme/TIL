package Past_Exam_Questions;

import java.io.*;
import java.util.*;

/**
 * 예술성
 * 
 * 삼성 SW 역량테스트 2022 상반기 오전 2번 문제
 * g3
 * 
 * 예술점수 구하는 과정
 * 
 * 1. 예술 점수 구하기
 * 1-1. 그룹 구하기
 * 1-2. 그룹 쌍 구하기
 * 1-2-1. 그룹 쌍 중 조화로운 그룹 구하기
 * 1-3. 예술 점수 구하기
 * 
 * 2. 회전하기
 *
 */

public class Main_2 {

    static int n; // 항상 홀수
    static int half;

    static int[][] map;

    static int ans = 0; // 3회의 예술 점수 총점

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        half = n / 2;

        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }// end of init

    public static void rotateCross() {
        int[] tmp = new int[half];

        // 수직 부분 저장, 1
        for (int i = 0; i < half; i++) {
            tmp[i] = map[i][half];
        }

        // 4 -> 1에 저장
        for (int i = half + 1; i < n; i++) {
            map[n - half][half] = map[i][half];
        }

        // 3 -> 4에 저장
        for (int i = half + 1; i < n; i++) {
            map[i][half] = map[half][i];
        }

        // 2 -> 3애 저장
        for (int i = 0; i < half; i++) {
            map[n - i][half] = map[half][i];
        }

        // 1 -> 2 저장
        for (int i = 0; i < half; i++) {
            map[half][i] = tmp[i];
        }

    }// end of rotateCross

    public static void rotateCCW(int x1, int y1, int x2, int y2) {
        int[][] result = new int[half][half];

        for (int j = half - 1, x = x1; j >= 0 && x <= x2; j--, x++) {
            for (int i = 0, y = y1; i < half && y <= y2; i++, y++) {
                result[i][j] = map[x][y];
            }
        }

        for (int i = 0, x = x1; i < half && x <= x2; i++, x++) {
            for (int j = 0, y = y1; j < half && y <= y2; j++, y++) {
                map[x][y] = result[i][j];
            }
        }
    }// end of rotateCCW

    public static void rotateSquare(int area) {
        if (area == 0)
            rotateCCW(0, 0, half - 1, half - 1);
        if (area == 1)
            rotateCCW(0, half + 1, half - 1, n - 1);
        if (area == 2)
            rotateCCW(half + 1, 0, n - 1, half - 1);
        if (area == 3)
            rotateCCW(half + 1, half + 1, n - 1, n - 1);
    }

    public static void rotate() {
        // 십자 영역 반시계 회전
        rotateCross();

        // 정사각형 시계 방향 회전, 십자 기준으로 사분면 정함
        for (int i = 0; i < 4; i++) {
            rotateSquare(i);
        }
    }// end of rotate

    public static void sol() {
        // 초기 예술 점수 구하기
        doSomething();

        for (int i = 0; i < 3; i++) {
            // 회전
            rotate();

            // 예술 점수 구하기
            doSomething();
        }

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }
}
