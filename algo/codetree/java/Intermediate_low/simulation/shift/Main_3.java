package Intermediate_low.simulation.shift;

import java.io.*;
import java.util.*;

public class Main_3 {

    static final int U = -1;
    static final int D = 1;

    static int N, M, Q;

    static int[][] map;

    static Info info;

    static Queue<Info> que = new ArrayDeque();

    public static void main(String[] args) throws Exception {
        process();
        printMap();
    }// end of main

    public static void process() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            info = new Info(Integer.parseInt(st.nextToken()) - 1, st.nextToken());
            que.offer(info);
            dfs();
        }
    }// end of init

    public static void dfs() throws Exception {
        // dfs
        while (!que.isEmpty()) {
            Info in = que.poll();

            int curRow = in.r;
            int nextRow = 0;

            String dir = in.dir;
            int ud = in.ud;

            // 1. 현재 행, 방향으로 이동
            shift(in);

            if (ud == 0) {
                nextRow = curRow + U;
                commonFunc(curRow, nextRow, dir, U);
                nextRow = curRow + D;
                commonFunc(curRow, nextRow, dir, D);
            } else {
                nextRow = curRow + ud;
                commonFunc(curRow, nextRow, dir, ud);
            }
        }
    }// end of process

    public static void shift(Info in) throws Exception {
        int row = in.r;
        String dir = in.dir;

        int[] arr = new int[M];
        System.arraycopy(map[row], 0, arr, 0, M);

        int tmp = 0;
        if ("L".equals(dir)) {
            tmp = arr[M - 1];
            for (int i = M - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;
        } else {
            // "R".equals(dir)
            tmp = arr[0];
            for (int i = 0; i < M - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[M - 1] = tmp;
        }

        System.arraycopy(arr, 0, map[row], 0, M);

    }// end of shift

    public static boolean outOfRange(int curRow, int ud) throws Exception {
        int nextRow = curRow + ud;

        return nextRow < 0 || nextRow >= N;
    }// end of outOfRange

    public static boolean isPossible(int sr, int nr) throws Exception {
        int cnt = getCountMatch(sr, nr);
        return cnt > 0;
    }// end of Exception

    public static int getCountMatch(int sr, int nr) {
        int cnt = 0;
        for (int c = 0; c < M; c++) {
            if (map[sr][c] == map[nr][c])
                cnt++;
        }
        return cnt;
    }// end of getCountMatch

    public static void commonFunc(int curRow, int nextRow, String dir, int ud) throws Exception {
        // 2. 전파 가능 범위인지 확인
        if (outOfRange(curRow, ud))
            return;
        else {
            // 3. 전파 가능한지 확인
            if (!isPossible(curRow, nextRow))
                return;

            // 4. 가능한 경우 큐 추가
            String nextDir = "L".equals(dir) ? "R" : "L";
            que.offer(new Info(nextRow, nextDir, ud));
        }
    }// end of commomFunc

    public static void printMap() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }// end of printMap

}// end of class

class Info {
    int r;
    String dir;
    int ud; // up : -1, down : 1

    public Info(int r, String dir) {
        this.r = r;
        this.dir = dir;
        this.ud = 0;
    }

    public Info(int r, String dir, int ud) {
        this.r = r;
        this.dir = dir;
        this.ud = ud;
    }
}// end of Info