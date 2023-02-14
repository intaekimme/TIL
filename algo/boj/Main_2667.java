package boj;

import java.io.*;
import java.util.*;

/**
 * 단지번호붙이기
 * bfs, dfs 둘다 가능
 */

public class Main_2667 {

    static final int MAX_N = 25;

    static int n, cnt;

    static String[] map = new String[MAX_N + 1];
    static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];
    static List<Integer> ans = new ArrayList<>();

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            map[i] = br.readLine();
        }

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 0 || y >= n;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x].charAt(y) == '0')
            return false;
        return true;
    }// end of canGo

    public static void dfs(int x, int y) {
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!canGo(nx, ny))
                continue;
            visited[nx][ny] = true;
            cnt++;
            dfs(nx, ny);
        }
    }// end of dfs

    public static void sol() {
        StringBuilder sb = new StringBuilder();
        for (int x = 1; x <= n; x++) {
            for (int y = 0; y < n; y++) {
                if (visited[x][y] || map[x].charAt(y) == '0')
                    continue;
                cnt = 1;
                visited[x][y] = true;
                dfs(x, y);
                ans.add(cnt);
            }
        }

        Collections.sort(ans);
        sb.append(ans.size()).append("\n");
        for (int num : ans)
            sb.append(num).append("\n");
        System.out.print(sb.toString());
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main
}
