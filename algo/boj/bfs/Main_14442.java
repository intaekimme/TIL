package boj.bfs;

import java.io.*;
import java.util.*;

/*
 * 벽 부수고 이동하기 2
 * 
 * 구하는 것 : 최단 경로의 길이
 * 
 * 최단 경로를 구할 수 있다면 최대 k개 까지 벽을 깨도 됨.
 * 
 * 1 <= n <= 1000, 1 <= m <= 1000, 1 <= k <= 10 이기 때문에 
 * 조합을 이용한 백트랙킹 + bfs로는 무조건 시간초과 발생
 * 1000C10 = 263,409,560,461,970,212,832,400
 * 
 * 벽 부수고 이동하기 1에서는 벽을 최대 1개까지 밖에 못 부심
 * 하지만 이 문제에서는 최대 k개 까지 가능
 * 
 * k + 1개의 방문배열을 관리
 * 1에서 코드를 한 번 실행했다면
 * 2에서는 코드를 k번 실행
 */

public class Main_14442 {

    static int n, m, K;

    static char[][] map;

    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };

    static boolean[][][] visited;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();

        visited = new boolean[n][m][K + 1];
    }// end of init

    public static void sol() {
        Queue<int[]> que = new ArrayDeque<>();

        visited[0][0][0] = true;
        que.offer(new int[] { 0, 0, 1, 0 });

        while (!que.isEmpty()) {
            int[] coord = que.poll();
            int x = coord[0];
            int y = coord[1];
            int dist = coord[2];

            if (x == n - 1 && y == m - 1) {
                System.out.println(dist);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (map[nx][ny] == '0' && !visited[nx][ny][coord[3]]) {
                    visited[nx][ny][coord[3]] = true;
                    que.add(new int[] { nx, ny, dist + 1, coord[3] });
                } else {
                    if (coord[3] < K && !visited[nx][ny][coord[3] + 1]) {
                        visited[nx][ny][coord[3] + 1] = true;
                        que.add(new int[] { nx, ny, dist + 1, coord[3] + 1 });
                    }
                }
            }
        } // end of while

        System.out.println(-1);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of sol
