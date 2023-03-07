package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 2206 벽 부수고 이동하기 1
 * 
 * 벽을 한 번이라도 부순 경우와 한 번도 부수지 않은 경우를 나누어서 관리
 * 
 * 벽을 부수지 않은 경우는 벽을 부순 경우로 갈 수 있고
 * 벽을 부순 경우는 벽을 부수지 않은 경우 그리고 벽을 추가로 부수는 경우로 갈 수 없기 때문
 */

public class Main_2206 {

    private static int N, M;
    private static char[][] map;

    private static int[] dx = { 0, 1, 0, -1 };
    private static int[] dy = { 1, 0, -1, 0 };
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<int[]> que = new LinkedList<int[]>();
        visited = new boolean[N][M][2];
        que.add(new int[] { 0, 0, 1, 0 });

        int x = 0;
        int y = 0;
        while (!que.isEmpty()) {
            int[] coord = que.poll();
            x = coord[0];
            y = coord[1];
            int dist = coord[2];

            if (x == N - 1 && y == M - 1) {
                System.out.println(dist);

                printMap(visited);

                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (map[nx][ny] == '0') {
                    if (coord[3] == 0 && !visited[nx][ny][0]) {
                        que.add(new int[] { nx, ny, dist + 1, 0 });
                        visited[nx][ny][0] = true;
                    } else if (coord[3] == 1 && !visited[nx][ny][1]) {
                        que.add(new int[] { nx, ny, dist + 1, 1 });
                        visited[nx][ny][1] = true;

                    }
                } else {
                    if (coord[3] == 0) {
                        que.add(new int[] { nx, ny, dist + 1, 1 });
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }// end of main

    public static void printMap(boolean[][][] map) {
        System.out.println(map.length + ", " + map[0].length + ", " + map[0][0].length);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                for (int k = 0; k < map[i][j].length; k++)
                    System.out.print(map[i][j][k] + " ");
                System.out.println();
            }
            System.out.println("----------------------------");
        }
    }

}// end of class