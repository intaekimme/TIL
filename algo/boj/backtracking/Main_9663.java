package boj.backtracking;

import java.io.*;

/**
 * N-Queen, 9663
 * 
 * N * N 체스판에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 * 
 * N이 주어졌을 때, 퀸을 노흔 방법의 수 출력
 * 
 * 풀이 1. 메모리 초과남, 시간 초과도 예상됨
 * 1. 크기 N*N인 1차원 배열에서 N개를 선택하는 조합 생각
 * 2. 조합에서 퀸을 체스판에 하나씩 놓을 때마다 공격 범위를 표시
 * 3. 조합에서 그 다음 퀸이 공격 범위에 놓이면 만족하지 않는 조합
 * 4. 조합 내 모든 퀸이 체스판 위에 놓이면 서로 공격할 수 없게 놓는 경우이므로 정답 카운트
 * 
 * 
 * 풀이 2.
 * 하나씩 놓을 수 있을 때만 놓는다
 */

public class Main_9663 {
    static final int MAX_N = 14;

    static int n;
    static int ans = 0;

    static boolean[][] map;
    static int[] selected;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new boolean[n][n];
        selected = new int[n * n];
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }// outOfRange

    public static void putQueen(int x, int y) {
        int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };

        map[x][y] = true;

        for (int i = 0; i < 8; i++) {
            for (int j = 1; j <= n - 1; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (outOfRange(nx, ny))
                    continue;
                map[nx][ny] = true;
            }
        }
    }// end of putQueen

    public static void fallBackQueen(int x, int y) {
        int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };

        map[x][y] = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 1; j <= n - 1; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (outOfRange(nx, ny))
                    continue;
                map[nx][ny] = false;
            }
        }
    }// end of fallBackQueen

    public static void func(int depth, int start) {
        if (depth == n) {
            ans++;
            return;
        }

        for (int i = start; i < n * n; i++) {
            int x = i / n;
            int y = i % n;
            if (map[x][y])
                continue;
            selected[depth] = i;
            putQueen(x, y);
            func(depth + 1, i + 1);
            fallBackQueen(x, y);
        }
    }// end of func

    public static void sol() {
        func(0, 0);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}// end of class
