package Intermediate_low.dfs;

import java.io.*;
import java.util.*;

/**
 * 안전지대
 * 
 * 어느 한 지점 주위에 또다른 미방문한 안전지대가 존재하면 해당 지점 방문
 * 더이상 방문이 되지 않으면 다른 위치에서 안전지대 탐색
 * 새로 탐색 가능 지점 발견되면 안전지대 갯수 + 1
 * 
 * 높이 별로 확인필요
 * 높이 별로 확인 후 나온 안전지대 갯수가 기존의 갯수보다 많으면 갱신
 */

public class Main_4 {
    static final int MAX_N = 50;

    static int n, m;
    static int max_h = 0;
    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static boolean[][] visit;

    static List<Info> res = new ArrayList<>();

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (max_h < map[i][j])
                    max_h = map[i][j];
            }
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }// end of outOfRange

    public static boolean canGo(int x, int y, int h) {
        if (outOfRange(x, y))
            return false;
        if (visit[x][y] || map[x][y] <= h)
            return false;
        return true;
    }// end of canGo

    public static void dfs(int x, int y, int h) {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny, h)) {
                visit[nx][ny] = true;
                dfs(nx, ny, h);
            }
        }

    }// end of dfs

    public static void sol() {
        // 높이 별로 안전지대 탐색
        for (int h = 1; h <= max_h; h++) {
            int cnt = 0;
            visit = new boolean[MAX_N + 1][MAX_N + 1]; // 방문 배열 초기화

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (canGo(i, j, h)) {
                        cnt++;
                        visit[i][j] = true;
                        dfs(i, j, h);
                    }
                }
            }
            res.add(new Info(h, cnt));
        }

        Collections.sort(res);

        Info ans = res.get(0);
        System.out.println(ans.h + " " + ans.cnt);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class

class Info implements Comparable<Info> {
    int h;
    int cnt;

    public Info(int h, int cnt) {
        this.h = h;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Info cur) {
        if (cur.cnt == this.cnt)
            return this.h - cur.h; // 높이 오름차순 정렬
        return cur.cnt - this.cnt; // 갯수 내림차순 정렬
    }
}