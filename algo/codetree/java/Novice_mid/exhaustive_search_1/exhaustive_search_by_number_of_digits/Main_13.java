package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

/**
 * 오목 fail
 * check early return 으로 우상단 대각선만 확인 후 종료
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

        for (int i = 0; i < 4; i++) {
            int[] stone_cnt = new int[3];

            for (int j = 1; j <= 5; j++) {
                int nx = x + dx[i] * j;
                int ny = x + dy[i] * j; // y에다 더해야 하는데 x에 더함

                if (!inRange(nx, ny))
                    return UNDECIDED;
                stone_cnt[map[nx][ny]]++;
            }

            //
            if (stone_cnt[0] > 0)
                return UNDECIDED;
            if (stone_cnt[1] == 5)
                return new int[] { 1, x + 2, y + 2 };
            if (stone_cnt[2] == 5)
                return new int[] { 2, x + 2, y + 2 };
        }

        return UNDECIDED;
    }// end of check

    public static int[] sol() {
        int[] res = new int[3];
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                res = check(i, j);
                if (res[0] != 0)
                    break;
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
