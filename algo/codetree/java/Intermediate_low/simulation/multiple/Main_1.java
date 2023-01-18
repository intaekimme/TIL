package Intermediate_low.simulation.multiple;

import java.io.*;
import java.util.*;

public class Main_1 {
    static final int MAX_N = 20;

    static int n, m, t;
    static int nextX, nextY;

    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static int[][] current = new int[MAX_N + 1][MAX_N + 1];
    static int[][] nextCurrent = new int[MAX_N + 1][MAX_N + 1];

    // 초기화
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            current[x][y]++;
        }
    }

    // 최종 구슬 개수 반환
    public static int getMarvlesCount() {
        int cnt = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                if (current[i][j] == 1)
                    cnt++;

        return cnt;
    }

    // 범위 체크
    public static boolean inRange(int currX, int currY) {
        return 1 <= currX && currX <= n && 1 <= currY && currY <= n;
    }

    // 사방 탐색 후 좌표 반환
    // 조건에 맞으면 새좌표 반환
    public static Pair getNextPos(int currX, int currY) {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        int max = 0; // 사방 탐색 중 가장 큰 값, 초기값; 0

        int resX = 0; // 가장 큰 값의 x좌표
        int resY = 0; // 가장 큰 값의 y좌표

        for (int i = 0; i < 4; i++) {
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];

            if (inRange(nextX, nextY) && map[nextX][nextY] > max) {
                max = map[nextX][nextY];
                resX = nextX;
                resY = nextY;
            }
        }

        return new Pair(resX, resY);
    }

    // 구슬 하나를 이동 시킴
    public static void move(int currX, int currY) {
        // 조건에 맞는 다음 좌표 한개를 반환
        Pair nextPos = getNextPos(currX, currY);

        nextX = nextPos.x;
        nextY = nextPos.y;

        // 이동 후 배열의 해당 좌표에 이동한 구슬 기록
        nextCurrent[nextX][nextY]++;
    }

    // 모든 구슬을 이동시킴
    public static void moveAll() {
        // 이동 후 배열 초기화
        for (int i = 1; i <= n; i++)
            Arrays.fill(nextCurrent[i], 0);

        // 모든 구슬 이동
        for (int currX = 1; currX <= n; currX++)
            for (int currY = 1; currY <= n; currY++)
                if (current[currX][currY] == 1)
                    move(currX, currY);

        // 이동한 구슬을 현재로 복사
        for (int currX = 1; currX <= n; currX++)
            System.arraycopy(nextCurrent[currX], 1, current[currX], 1, n);

    }

    // 중복 구슬 제거
    public static void removeDuplicateMarvels() {
        for (int currX = 1; currX <= n; currX++)
            for (int currY = 1; currY <= n; currY++)
                if (current[currX][currY] >= 2)
                    current[currX][currY] = 0;
    }

    public static void simulate() {
        moveAll();
        removeDuplicateMarvels();
    }

    public static void main(String[] args) throws IOException {

        init();

        while (t-- > 0) {
            simulate();
        }

        System.out.println(getMarvlesCount());

    }// end of main

}// end of class

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}