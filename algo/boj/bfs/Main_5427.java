package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 5427 불 g4
 * 23.04.11
 * 1시간 10분
 * 92780kb, 820ms
 * 
 * 상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다.
 * = 불은 상근이가 있는 자리도 빈칸으로 여기고 퍼짐.
 * = 상근이는 불이 있는 곳으로 못가기 때문에 상근이가 먼저 움직여야 한다.
 * 대신 이 후 상근이가 움직일 수 있는 자리가 불이 번져서 갈 수 없는 공간이면 추가 탐색을 생략한다.
 *
 * 상근이가 탈출하는데 가장 빠른 시간을 확인해야 하므로 bfs 사용
 * 
 */

public class Main_5427 {

    static int tc;
    static int w, h;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
            }

            simulation();
        }

        System.out.println(sb.toString());
    }// end of solve

    public static int[] findSurviver() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '@')
                    return new int[] { i, j };
            }
        }
        return new int[] { -1, -1 };
    }// end of findSurvior

    public static ArrayList<int[]> findFire() {
        ArrayList<int[]> pos = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '*')
                    pos.add(new int[] { i, j });
            }
        }

        return pos;
    }// end of findFire

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= h || y < 0 || y >= w;
    }// end of outOfRange

    public static boolean canGo(int x, int y, boolean[][] visited) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x][y] == '*' || map[x][y] == '#')
            return false;
        return true;
    }// end of canGo

    public static int bfs(int[] pos, ArrayList<int[]> fire_pos) {
        int[] dx = new int[] { -1, 0, 1, 0 };
        int[] dy = new int[] { 0, 1, 0, -1 };

        // 상근이 움직임 관리
        Queue<int[]> que = new ArrayDeque<>();

        boolean[][] visited = new boolean[h][w];
        int[][] dist = new int[h][w];

        for (int i = 0; i < h; i++)
            Arrays.fill(dist[i], -1);

        dist[pos[0]][pos[1]] = 1;
        visited[pos[0]][pos[1]] = true;

        que.offer(pos);

        // 불 번짐 관리
        Queue<int[]> fire_que = new ArrayDeque<>();
        boolean[][] fire_visited = new boolean[h][w];

        for (int i = 0; i < fire_pos.size(); i++) {
            int[] fire = fire_pos.get(i);
            fire_visited[fire[0]][fire[1]] = true;
            fire_que.offer(fire_pos.get(i));
        }

        // 상근이가 더 이상 움직이지 못하면 종료
        while (!que.isEmpty()) {

            int size = que.size();

            // 상근이 움직임
            for (int i = size; i > 0; i--) {
                int[] cur = que.poll();

                int x = cur[0];
                int y = cur[1];

                // 상근이가 움직인 공간에 불이 번진거면 못가는 공간이므로 추가 탐색 생략
                if (map[x][y] == '*')
                    continue;

                if (x == 0 || x == h - 1 || y == 0 || y == w - 1)
                    return dist[x][y];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (!canGo(nx, ny, visited))
                        continue;

                    dist[nx][ny] = dist[x][y] + 1;
                    visited[nx][ny] = true;
                    que.offer(new int[] { nx, ny });
                }
            } // end of for

            // 불 번지기
            int fire_size = fire_que.size();
            for (int i = fire_size; i > 0; i--) {
                int[] fire = fire_que.poll();

                int x = fire[0];
                int y = fire[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                        continue;
                    if (fire_visited[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == '#')
                        continue;
                    map[nx][ny] = '*';
                    fire_visited[nx][ny] = true;
                    fire_que.offer(new int[] { nx, ny });
                }
            } // end of for

        } // end of while

        return -1;

    }// end of bfs

    public static void simulation() {
        // 생존자 위치 확인
        int[] pos = findSurviver();

        // 불 위치 확인
        ArrayList<int[]> fire_pos = findFire();

        // 생존자 위치에서부터 bfs 시작
        int ans = bfs(pos, fire_pos);

        sb.append(ans != -1 ? ans : "IMPOSSIBLE").append("\n");
    }// end of simulation

    public static void main(String[] args) throws IOException {
        solve();
    }// end of main
}// end of class
