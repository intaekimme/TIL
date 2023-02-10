package Intermediate_low.bfs.equal_weighted_graph;

import java.io.*;
import java.util.*;

/**
 * 비를 피하기, 시뮬레이션, bfs
 * 
 * 큐 : 더 움직일 수 있는 공간이 있는 사람
 * 
 * 풀이
 * 큐에 사람들을 넣음
 * 매 초마다 사람들이 움직일 수 있는 공간을 찾음(0, 3)
 * 비를 피할 수 있는 공간에 도착한 사람은 자신의 시작 위치에 이동 시간 기록 후 공간 탐색 종료
 * 더이상 움직일 곳이 없고 비를 피할 수 있는 곳에 도착하지 못한 사람은 시작 위치에 -1기록 후 공간 탐색 종료
 * 
 * 큐가 비면 모든 사람이 더이상의 공간 탐색이 필요없으므로 탐색 종료
 * 정답 출력
 * 
 * 실패
 * 원인 : 한 사람이 지나간 곳이 방문체크 되어서 다른사람이 지나가지 못함
 * 해결책 : 한 사람씩 시뮬레이션함
 */

public class Main_3 {

    static final int MAX_N = 100;
    static int n, h, m;

    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];
    static int[][] ans = new int[MAX_N + 1][MAX_N + 1];

    static Queue<int[]> que = new ArrayDeque<>();

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    visited[i][j] = true;
                    que.offer(new int[] { i, j, i, j, 0 });
                }
            }
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x][y] == 1)
            return false;
        return true;
    }// end of canGo

    public static void simulate() {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int sx = cur[0];
            int sy = cur[1];

            int x = cur[2];
            int y = cur[3];

            int time = cur[4];

            if (map[x][y] == 3) {
                ans[sx][sy] = time;
                continue;
            }

            int search_end = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny)) {
                    search_end++;
                    if (search_end == 4) {
                        ans[sx][sy] = -1;
                    }
                    continue;
                }

                if (map[nx][ny] != 3) {
                    visited[nx][ny] = true;
                    visited[x][y] = false;
                }
                que.offer(new int[] { sx, sy, nx, ny, time + 1 });
            }
        } // end of while

    }// end of simulate

    public static void printAns() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                sb.append(ans[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }// end of printAns

    public static void main(String[] args) throws IOException {
        init();
        simulate();
        printAns();
    }// end of main

}// end of class