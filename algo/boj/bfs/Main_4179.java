package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 불 4179
 * 57272KB, 640ms
 * 
 * bfs, 큐 2개 사용, 불 큐, 사람 큐
 * g4
 */

public class Main_4179 {

    static final int MAX = (int) 1e9;

    static int R, C;
    static char[][] map;
    static int[][] time;

    static int[] jihun = new int[2];
    static Queue<int[]> que = new ArrayDeque<>();

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J')
                    jihun = new int[] { i, j };
                if (map[i][j] == 'F')
                    que.offer(new int[] { i, j });
            }
        }

        time = new int[R][C];
        for (int i = 0; i < R; i++)
            Arrays.fill(time[i], -1);

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (map[x][y] == 'F' || map[x][y] == '#')
            return false;
        return true;
    }// end of canGo

    public static void simulation() {

        Queue<int[]> p = new ArrayDeque<>();

        p.offer(jihun);
        time[jihun[0]][jihun[1]] = 1;

        int size = que.size();
        int p_size = p.size();

        while (!p.isEmpty()) {
            // 불 전파
            int cnt = 0;
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();

                int x = cur[0];
                int y = cur[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (!canGo(nx, ny))
                        continue;
                    que.offer(new int[] { nx, ny });
                    cnt++;
                    map[nx][ny] = 'F';
                }
            }

            size = cnt;

            // 사람 이동
            int p_cnt = 0;
            for (int i = 0; i < p_size; i++) {
                int[] ji = p.poll();

                int x = ji[0];
                int y = ji[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (!canGo(nx, ny))
                        continue;
                    if (time[nx][ny] > 0)
                        continue;
                    p.offer(new int[] { nx, ny });
                    time[nx][ny] = time[x][y] + 1;
                    p_cnt++;
                }
            }

            p_size = p_cnt;

            printMap();

        } // end of while

        int min = MAX;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((i == 0 || i == R - 1 || j == 0 || j == C - 1) && time[i][j] > 0)
                    min = Math.min(min, time[i][j]);
            }
        }

        if (min == MAX)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(min);

    }// end of simulation

    public static void printMap() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        sb.append("\n");

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(time[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }// end of printMap

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main
}// end of class
