package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 16234, 인구이동, g5, sol
 * 298176KB 716ms
 * 
 * bfs
 */

public class Main_16234 {

    static int N, L, R;
    static int[][] map; // 인구수 맵
    static int[][] copy; // 연합 발생 후 분배된 인구수 맵
    static int[][] visited; // 연합인 국가 기록

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }// end of outOfRange

    public static boolean canGo(int sx, int sy, int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] > 0 || Math.abs(map[sx][sy] - map[x][y]) < L || Math.abs(map[sx][sy] - map[x][y]) > R)
            return false;
        return true;
    }// end of canGo

    /**
     * r, c를 기점으로 인구수 차이가 L이상 R 이하(조건)인 나라 찾기
     * 
     * @param r
     * @param c
     * @param id
     */
    public static void bfs(int r, int c, int id) {
        Queue<int[]> que = new ArrayDeque<>();
        ArrayList<int[]> rec = new ArrayList<>(); // 조건 만족하는 좌표 기록, 인구 수 분배 기록위해
        int sum = 0; // 조건 만족하는 국가들의 총 인구 수 합
        int cnt = 0; // 조건 만족하는 국가들의 수

        que.offer(new int[] { r, c });
        rec.add(new int[] { r, c });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            sum += map[x][y];
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(x, y, nx, ny))
                    continue;

                visited[nx][ny] = id;
                que.offer(new int[] { nx, ny });
                rec.add(new int[] { nx, ny });
            }
        } // end of while

        // 조건 만족하는 국가들 인구 수 분배
        for (int i = 0; i < rec.size(); i++) {
            int[] cur = rec.get(i);

            int x = cur[0];
            int y = cur[1];

            copy[x][y] = sum / cnt;
        }

    }// end of bfs

    public static int simulation() {
        int day = 0;

        // 조건 만족 할 때까지 반복
        while (true) {
            visited = new int[N][N];
            copy = new int[N][N];

            int id = 1;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    // 이미 표시한 곳이면 pass
                    if (visited[x][y] > 0) {
                        continue;
                    }
                    visited[x][y] = id;
                    bfs(x, y, id);
                    id++;
                }
            }

            // 인구 이동이 발생하지 않으면 id의 크기가 격자의 크기와 동일
            if (id - 1 == N * N) {
                return day;
            }

            // 인구 이동 발생하였으므로 결과 복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = copy[i][j];
                }
            }

            day++; // 하루 경과
        }
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(simulation());
    }// end of main
}// end of class
