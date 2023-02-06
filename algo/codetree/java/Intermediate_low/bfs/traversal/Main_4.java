package Intermediate_low.bfs.traversal;

import java.io.*;
import java.util.*;

/**
 * 돌 잘 치우기
 * backtracking + bfs
 */
public class Main_4 {

    static final int MAX_N = 100;

    static int n, k, m;
    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static int[][] copy;
    static boolean[][] visited;
    static int[] sr = new int[MAX_N * MAX_N];
    static int[] sc = new int[MAX_N * MAX_N];

    static List<int[]> blocks = new ArrayList<>();
    static int[][] selected;

    static Queue<int[]> que = new ArrayDeque<>();

    static int ans = Integer.MIN_VALUE;

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || copy[x][y] == 1)
            return false;
        return true;
    }// end of canGo

    public static void push(int x, int y) {
        que.offer(new int[] { x, y });
        visited[x][y] = true;
    }// end of push

    public static void bfs() {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        copy = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            System.arraycopy(map[i], 1, copy[i], 1, n);

        for (int i = 0; i < m; i++) {
            int[] remove_pos = selected[i];
            int x = remove_pos[0];
            int y = remove_pos[1];
            copy[x][y] = 0;
        }

        visited = new boolean[MAX_N + 1][MAX_N + 1];

        for (int i = 0; i < k; i++) {
            push(sr[i], sc[i]);
        }

        int cnt = k;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (canGo(nx, ny)) {
                    push(nx, ny);
                    cnt++;
                }
            }
        }

        ans = Math.max(ans, cnt);

    }// end of bfs

    public static void func(int depth, int start) {
        if (depth == m) {
            bfs();
            return;
        }

        for (int i = start; i < blocks.size(); i++) {
            selected[depth] = blocks.get(i);
            func(depth + 1, i + 1);
        }
    }// end of func

    public static void sol() {
        func(0, 0);
        System.out.println(ans);
    }// end of sol

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    blocks.add(new int[] { i, j });
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            sr[i] = Integer.parseInt(st.nextToken());
            sc[i] = Integer.parseInt(st.nextToken());
        }

        selected = new int[m][];
    }// end of init

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class