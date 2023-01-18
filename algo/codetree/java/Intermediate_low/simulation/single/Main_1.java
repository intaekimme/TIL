package Intermediate_low.simulation.single;

import java.io.*;
import java.util.*;

/**
 * 숫자가 더 큰 인접한 곳으로 이동
 */
public class Main_1 {

    static int n, r, c;
    static int[][] map;
    static final int[] dr = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
    static final int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map[r][c]).append(" "); // 초기 위치 입력

        while (true) {
            int cnt = 0; // 이동할 수 없을 경우 카운트
            // 4방 탐색 시작
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 나아갈 수 없는 방향이면 이동할 수 없는 경우 증가
                if (outOfRange(nr, nc)) {
                    cnt++;
                    continue;
                }

                // 이동할 수 있는 경우이면 기록후 좌표값 갱신 후 탐색 중단, 우선순위 때문에
                if (map[nr][nc] > map[r][c]) {
                    sb.append(map[nr][nc]).append(" ");
                    r = nr;
                    c = nc;
                    break;
                }

                // 탐색 중단이 안되었으면 이동할 수 없는 경우이므로 카운트 증가
                cnt++;
            }

            // 4방 탐색 후 상하좌우 모두 이동할 수 없으면 탐색 종료
            if (cnt == 4)
                break;
        }

        System.out.println(sb.toString());

    }// end of main

    public static boolean outOfRange(int r, int c) {
        return (r < 0 || r >= n || c < 0 || c >= n);
    }// end of outOfRange

}
