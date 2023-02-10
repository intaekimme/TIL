package Intermediate_low.bfs.traversal;

import java.io.*;
import java.util.*;

/**
 * k번 최대값으로 이동하기
 * 특정 위치에서 시작하여 아래 조건을 만족하는 숫자의 위치를 찾아 상하좌우로만 이동
 * 이렇게 이동하는 것 k번 반복한 이후의 위치를 구하는 프로그램
 */

public class Main_3 {

    static final int MAX_N = 100;

    static int n, k, er, ec;
    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static boolean[][] visited;

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x][y] >= map[er][ec])
            return false;
        return true;
    }// end of canGo

    public static void bfs() {
        visited = new boolean[MAX_N + 1][MAX_N + 1];

        List<Pair> possible = new ArrayList<>();
        Queue<Pair> que = new ArrayDeque<>();

        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        que.offer(new Pair(er, ec, map[er][ec]));
        visited[er][ec] = true;

        while (!que.isEmpty()) {
            Pair cur = que.poll();

            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canGo(nx, ny)) {
                    Pair next = new Pair(nx, ny, map[nx][ny]);
                    que.offer(next);
                    visited[nx][ny] = true;
                    possible.add(next);
                }
            }
        }

        Collections.sort(possible);

        if (possible.size() > 0) {
            Pair next = possible.get(0);
            er = next.x;
            ec = next.y;
        }
    }// end of bfs

    public static void sol() {
        while (k > 0) {
            bfs();
            k--;
        }

        System.out.println(er + " " + ec);
    }// end of sol

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        er = Integer.parseInt(st.nextToken());
        ec = Integer.parseInt(st.nextToken());

    }// end of init

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class

class Pair implements Comparable<Pair> {
    int x;
    int y;
    int val;

    public Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.val == p.val) {
            if (this.x == p.x)
                return this.y - p.y; // 열 오름차순
            return this.x - p.x; // 행 오름차순
        }
        return p.val - this.val; // 값 내림차순
    }// end of compareTo

}// end of Pair