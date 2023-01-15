
import java.io.*;
import java.util.*;

/**
 * 1210. [S/W 문제해결 기본] 2일차 - Ladder1
 */
public class Solution_1210 {

    static final int MAX_LEN = 100;
    static final int[] dx = { -1, 0, 0 }; // 북, 동, 서
    static final int[] dy = { 0, 1, -1 };// 북, 동, 서

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(n).append(" ");

            int[][] map = new int[MAX_LEN + 1][MAX_LEN + 2];

            // 도착지가 있는 마지막 줄 전까지만 입력, 조건 확인횟수 줄이기 위해
            for (int i = 1; i <= 99; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 도착지 있는 마지막 줄
            st = new StringTokenizer(br.readLine());
            int x = 100; // 시작점 x좌표, 100 고정
            int y = 0; // 시작점 y좌표

            // 마지막 줄 탐색하면서 도착지인 지점의 y좌표는 기록 -> 이분탐색으로 개선 가능
            for (int i = 1; i <= 100; i++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 2)
                    y = i;
            }

            // 출발지 찾기 시작
            while (true) {
                if (x == 1) {
                    break; // 출발지를 찾았으므로 탐색 중단.
                }
                // 3방 탐색 시작
                for (int i = 0; i < 3; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    // 0은 사다리가 없는 공간이거나 이미 방문한 공간이면
                    if (map[nx][ny] == 0 || map[nx][ny] == -1) {
                        // 방향 회전후 다시 탐색
                        continue;
                    }
                    // 사다리가 있는 경우
                    map[x][y] = -1; // 현재 위치는 방문했으므로 방문 기록
                    x = nx; // 다음 사다리 x좌표로 이동 == nx값
                    y = ny; // 다음 사다리 y좌표로 이동 == ny값
                }
            } // end of while

            sb.append(y - 1).append("\n"); // 테두리를 위해 열을 하나 추가했으므로 빼줘야함.
        } // end of tc

        System.out.println(sb.toString()); // 정답 출력

    }// end of main

}// end of class
