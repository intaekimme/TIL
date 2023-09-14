package Intermediate_low.dfs;

import java.io.*;
import java.util.*;

public class Main_3_1 {

    static int n;
    static int cnt = 0;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    static ArrayList<Integer> peopleCnt = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n + 2][n + 2];
        visited = new boolean[n + 2][n + 2];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    cnt = 1;
                    dfs(i, j);
                    peopleCnt.add(cnt);
                }
            }
        }

        Collections.sort(peopleCnt);

        System.out.println(peopleCnt.size());
        for (int i = 0; i < peopleCnt.size(); i++) {
            System.out.println(peopleCnt.get(i));
        }
    }// end of main

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y])
            return false;
        if (map[x][y] == 0)
            return false;
        return true;
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                cnt++;
                dfs(nx, ny);
            }
        }
    }// end of dfs

}// end of class