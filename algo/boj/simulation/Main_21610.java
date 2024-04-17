package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 21610 마법사 상어와 비바라기
 * 
 */

public class Main_21610 {

    static int N, M;
    static int[][] map;

    // 명령
    static int[][] op;

    // dxdy
    static int[] dx = new int[] { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dy = new int[] { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

    // 구름
    static ArrayList<int[]> node;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 물바구니 입력
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령 입력
        op = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            op[i] = new int[] { d, s };
        }

    }// end of init

    public static void move(int m) {
        for (int i = 0; i < node.size(); i++) {
            int[] cur = node.get(i);

            int x = cur[0];
            int y = cur[1];

            x = (x + dx[m] + N) % N;
            y = (y + dy[m] + N) % N;

            node.get(i)[0] = x;
            node.get(i)[1] = y;
        }
    }// end of move

    public static void rain() {
        for (int i = 0; i < node.size(); i++) {
            int[] cur = node.get(i);

            int x = cur[0];
            int y = cur[1];

            map[x][y] += 1;
        }
    }// end of rain

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }// end of oufOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (map[x][y] == 0)
            return false;
        return true;
    }// end of canGo

    public static void magic() {

        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, N);
        }

        int[] dx = new int[] { -1, -1, 1, 1 };
        int[] dy = new int[] { -1, 1, 1, -1 };

        for (int i = 0; i < node.size(); i++) {
            int[] cur = node.get(i);

            int x = cur[0];
            int y = cur[1];

            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (!canGo(nx, ny))
                    continue;
                cnt++;
            }

            copy[x][y] += cnt;
        }

        for (int i = 0; i < N; i++) {
            System.arraycopy(copy[i], 0, map[i], 0, N);
        }

    }// end of magic

    public static void create() {
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < node.size(); i++) {
            int[] cur = node.get(i);

            int x = cur[0];
            int y = cur[1];

            visited[x][y] = true;
        }

        node = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (map[x][y] >= 2 && !visited[x][y]) {
                    map[x][y] = map[x][y] - 2 >= 0 ? map[x][y] - 2 : 0;
                    node.add(new int[] { x, y });
                }
            }
        }

    }// end of create

    public static void operation(int step) {
        // 구름 이동
        move(step);

        // 물의 양 1증가
        rain();

        // 물복사 마법
        magic();

        // 구름 생성
        create();
    }// end of operation

    public static void simulation() {
        // 비바라기 시전
        node = new ArrayList<>();
        node.add(new int[] { N - 1, 0 });
        node.add(new int[] { N - 1, 1 });
        node.add(new int[] { N - 2, 0 });
        node.add(new int[] { N - 2, 1 });

        for (int i = 0; i < M; i++) {
            // 명령 시전
            operation(i);
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main

}// end of class
