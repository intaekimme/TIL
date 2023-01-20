package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

/**
 * 최고의 13 위치2
 * 완전탐색
 * 격자 하나를 놓을 수 있는 위치를 확인해 격자를 놓고 동전의 갯수를 센다.
 * (격자를 놓을 수 있는 위치 : 범위를 벗어나지 않고 이미 격자를 배치하지 않은 곳)
 * 
 * 격자 하나 배치 후 다음 격자를 놓을 수 있는 위치를 확인해 격자를 놓고 동전의 갯수를 센다.
 * 이후 앞서 센 동전의 갯수와 합하여 최댓값을 갱신한다.
 * 격자를 놓은 위치에서 제거하고 다음 격자를 놓을 수 있는 위치를 찾아 놓기를 반복한다.
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

    // 범위 체크 함수
    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }// end of outOfRange

    // 격자를 놓을 수 있는 위치인지 확인
    // 놓을 수 있는 위치 : 범위를 벗어나지 않고 격자를 이미 놓지 않은 곳
    public static boolean isPossible(int x, int y) {
        for (int i = y; i < y + 3; i++) {
            if (outOfRange(x, i) || visited[x][i])
                return false;
        }
        return true;
    }// end of isPossible

    // 격자를 놓고 동전의 갯수를 세서 반환
    public static int findCoin(int x, int y) {
        int res = 0; // 센 동전의 갯수
        for (int i = y; i < y + 3; i++) {
            res += map[x][i];
            visited[x][i] = true; // 격자 놓은 처리
        }
        return res;
    }// end of findCoin

    // 격자 회수
    public static void restoreVisited(int x, int y) {
        for (int i = y; i < y + 3; i++) {
            visited[x][i] = false;
        }
    }// end of restoreVisited

    public static void sol() {
        int cnt = 0;
        // 첫 번째 격자를 배치한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isPossible(i, j))
                    continue;
                cnt = findCoin(i, j);
                // 두 번째 격자를 배치한다
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (!isPossible(k, l))
                            continue;
                        max = Math.max(max, cnt + findCoin(k, l));
                        restoreVisited(k, l);
                    } // end of l
                } // end of k
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
