package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

/**
 * 최고의 13위치 2
 * 격자 하나를 배치 가능한 공간에 배치 후 방문 처리
 * 다음 격자 배치 후 최대값 갱신
 * 이 후 다음 격자 배치를 위해 방문 해ㅈ[
 */
public class Main_15 {

    static final int MAX_LEN = 20;

    static int n;
    static int[][] map = new int[MAX_LEN][MAX_LEN];
    static boolean[][] visited = new boolean[MAX_LEN][MAX_LEN];
    static int max = Integer.MIN_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }// end of outOfRange

    public static boolean isPossible(int x, int y) {
        for (int i = y; i < y + 3; i++)
            if (outOfRange(x, i) || visited[x][i])
                return false;
        return true;
    }// end of isPossible

    public static int findCoin(int x, int y) {
        if (!isPossible(x, y))
            return 0;

        int cnt = 0;
        for (int i = y; i < y + 3; i++) {
            visited[x][i] = true;
            if (map[x][i] == 1)
                cnt++;
        }
        return cnt;
    }// end of findCoin

    public static void restoreVisited(int x, int y) {
        for (int i = y; i < y + 3; i++)
            visited[x][i] = false;
    }// end of resotreVisited

    public static void sol() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt = findCoin(i, j);
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        max = Math.max(max, cnt + findCoin(k, l));
                    } // l
                } // k
                restoreVisited(i, j);
            } // j
        } // i
    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(max);
    }// end of main
}
