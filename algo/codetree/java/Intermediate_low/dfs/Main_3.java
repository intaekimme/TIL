package Intermediate_low.dfs;

import java.io.*;
import java.util.*;

/**
 * 마을 구분하기
 */
public class Main_3 {

    static final int MAX_N = 25;

    static int n;

    static int[][] map = new int[MAX_N + 1][MAX_N + 1];
    static boolean[][] visit = new boolean[MAX_N + 1][MAX_N + 1];

    static List<Integer> res = new ArrayList<>();
    static int people;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (!outOfRange(x, y) && !visit[x][y] && map[x][y] == 1)
            return true;
        return false;
    }// end of canGo

    public static void dfs(int x, int y) {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canGo(nx, ny)) {
                visit[nx][ny] = true;
                people++;
                dfs(nx, ny);
            }
        }

    }// end of dfs

    public static void sol() {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (canGo(i, j)) {
                    visit[i][j] = true;
                    people = 1;
                    dfs(i, j);
                    res.add(people);
                }
            }
        }

        Collections.sort(res);

        System.out.println(res.size());
        for (int num : res)
            System.out.println(num);

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }
}