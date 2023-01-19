package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

/**
 * 오목
 * 로직 구현 시 check에서 구현 잘못한 것 수정 +
 * sol에서 inner loop만 탈출하던 것 outter loop까지 탈출하도록 종료
 */
public class Main_13 {

    static final int MAX_N = 19;
    static final int[] UNDECIDED = new int[] { 0, 0, 0 };
    static int[][] map = new int[MAX_N][MAX_N];

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < MAX_N && 0 <= y && y < MAX_N;
    }// end of inRange

    public static int[] check(int x, int y) {
        int[] dx = new int[] { -1, 0, 1, 1 };
        int[] dy = new int[] { 1, 1, 1, 0 };

        int[] stone_cnt = new int[3];
        for (int i = 0; i < 4; i++) {
            stone_cnt = new int[3];

            for (int j = 0; j < 5; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (!inRange(nx, ny))
                    break;
                stone_cnt[map[nx][ny]]++;
            }

            if (stone_cnt[1] == 5)
                return new int[] { 1, (x + dx[i] * 2) + 1, (y + dy[i] * 2) + 1 };
            if (stone_cnt[2] == 5)
                return new int[] { 2, (x + dx[i] * 2) + 1, (y + dy[i] * 2) + 1 };
        }

        return UNDECIDED;
    }// end of check

    public static int[] sol() {
        int[] res = new int[3];
        here: for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                res = check(i, j);
                if (res[0] != 0)
                    break here;
            }
        }
        return res;

    }// end of sol

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < MAX_N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAX_N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }// end of init

    public static void main(String[] args) throws IOException {
        init();

        int[] ans = sol();

        if (ans[0] == 0)
            System.out.println(0);
        else {
            System.out.println(ans[0]);
            System.out.println(ans[1] + " " + ans[2]);
        }

    }// end of main
}
