package Intermediate_low.simulation.single;

import java.io.*;
import java.util.*;

/**
 * 숫자가 더 큰 인접한 곳으로 이동
 */
public class Main_1 {
    static final int DIR_NUM = 4;
    static final int MAX_N = 100;

    static int n;
    static int currX, currY; // 현재 위치
    static int[][] map = new int[MAX_N + 1][MAX_N + 1];

    // 범위가 격자 안에 들어가는가
    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= n;
    }

    // 범위가 격자 안이고, 해당 위치 값이 더 큰지 확인
    public static boolean canGo(int x, int y, int currNum) {
        return inRange(x, y) && map[x][y] > currNum;
    }

    // 조건에 맞게 움직여 봄
    // 조건에 맞으면 true 반환
    // 조건에 맞지않으면 false 반환
    public static boolean simulate() {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        // 각각의 방향에 대해 갈 수 있는지 탐색
        for (int i = 0; i < 4; i++) {
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];

            // 갈 수 있으면
            // 이동하고 true 반환
            if (canGo(nextX, nextY, map[currX][currY])) {
                currX = nextX;
                currY = nextY;
                return true;
            }
        }
        // 갈 수 없으므로
        // false 반환
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        currX = Integer.parseInt(st.nextToken());
        currY = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 위치 기록
        StringBuilder sb = new StringBuilder();
        sb.append(map[currX][currY]).append(" ");

        while (true) {
            // 조건에 맞춰 움직여봄
            boolean greaterNumberExist = simulate();

            // 인접한 곳에 더 큰 숫자가 없다면 종료
            if (!greaterNumberExist)
                break;

            // 움직이고 난 후 위치 기록
            sb.append(map[currX][currY]).append(" ");
        }

        // 출력
        System.out.println(sb.toString());

    }// end of main

}
