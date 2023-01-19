package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

/**
 * 오목
 * 로직 구현 시 check에서 구현 잘못한 것 수정 +
 * sol에서 리턴 후 종료로 수정
 */
public class Main_13 {

    static final int MAX_N = 19;
    static final int[] UNDECIDED = new int[] { 0, 0, 0 }; // 오목의 승자가 없는 경우
    static int[][] map = new int[MAX_N][MAX_N];

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < MAX_N && 0 <= y && y < MAX_N;
    }// end of inRange

    // ↗︎, →, ↘︎, ↓ 방향 탐색
    // 배열의 인덱스가 좌상단에서 우하단으로 이동하기 때문에 1, 4 사분면만 확인하면 됨.
    // 탐색 시작 위치로부터 발견되는 빈칸 및 돌을 기록
    // 한 방향 탐색이 끝나면 오목이 존재하는지 확인
    // 오목이 존재하면 해당 정보 리턴
    // 오목이 존재하지 않고 탐색할 방향이 남아있으면 탐색 계속
    // 모든 방향 탐색 후 오목이 발견되지 않으면 undecided 리턴
    public static int[] check(int x, int y) {
        int[] dx = new int[] { -1, 0, 1, 1 };
        int[] dy = new int[] { 1, 1, 1, 0 };

        int[] stone_cnt = new int[3];
        // 방향 결정
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

    // (1,1) ~ (19,19)까지 탐색
    // 유효성 통과하면 [우승한 돌, 중심 x좌표, 중심 y좌표 반환]
    // 유효성 실패 시 [0,0,0] 반환
    public static int[] sol() {
        int[] res = new int[3];
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                res = check(i, j);
                if (res[0] != 0)
                    return res;
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
