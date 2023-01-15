
import java.io.*;
import java.util.*;

/**
 * 1211. [S/W 문제해결 기본] 2일차 - Ladder2
 */
public class Solution_1211 {

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

            int[][] map = new int[MAX_LEN + 1][MAX_LEN + 2]; // 테스트 케이스 별 맵 생성

            // 도착지가 있는 마지막 줄 전까지만 입력, 조건 확인횟수 줄이기 위해
            for (int i = 1; i <= 99; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()); // 맵 기록
                }
            }

            // 도착지 있는 마지막 줄
            st = new StringTokenizer(br.readLine());
            int[] y_coord = new int[MAX_LEN + 1]; // 시작점 y좌표

            // 마지막 줄 탐색하면서 도착지로 가능한 지점의 y좌표는 기록
            for (int i = 1; i <= MAX_LEN; i++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1)
                    y_coord[i] = i; // 찾은 열을 기록
            }

            Point[] points = new Point[MAX_LEN + 1]; // 모든 도착점
            // 도착점 배열 초기화
            for (int i = 0; i <= MAX_LEN; i++)
                points[i] = new Point(0, Integer.MAX_VALUE); // 이동 거리의 경우 최소로 정렬하므로 초기화 최댓값으로 설정

            // y배열에서 0이 아닌 값은 출발지이므로 탐색의 대상
            for (int i = 0; i < MAX_LEN; i++) {
                if (y_coord[i] == 0)
                    continue;

                // 출발지 찾기 시작
                // 초기화 작업
                int x = 100; // 시작점 x좌표, 100 고정
                int y = y_coord[i]; // 찾은 출발점
                int cnt = 0; // 출발지까지 도착하는데 걸린 횟수

                int[][] copyMap = new int[MAX_LEN + 1][MAX_LEN + 2]; // 원본 맵 복사본
                for (int r = 0; r < MAX_LEN; r++) {
                    System.arraycopy(map[r], 1, copyMap[r], 1, MAX_LEN); // 복사
                }

                while (true) {
                    if (x == 1) {
                        points[y].x = y;// 출발지이므로 기록, y좌표로 기록, 다른 정렬기준으로 정렬할 것이기에 상관없음
                        points[y].cnt = cnt;
                        break; // 출발지를 찾았으므로 탐색 중단.
                    }
                    // 3방 탐색 시작
                    for (int j = 0; j < 3; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        // 0은 사다리가 없는 공간이거나 이미 방문한 공간이면
                        if (copyMap[nx][ny] == 0 || copyMap[nx][ny] == -1) {
                            // 방향 회전후 다시 탐색
                            continue;
                        }
                        // 사다리가 있는 경우
                        copyMap[x][y] = -1; // 현재 위치는 방문했으므로 방문 기록
                        x = nx; // 다음 사다리 x좌표로 이동 == nx값
                        y = ny; // 다음 사다리 y좌표로 이동 == ny값
                        cnt++; // 이동 거리 + 1
                    }
                } // end of while
            } // end of for

            Arrays.sort(points); // 도착점들을 조건 기준으로 정렬, points[0]가 정답에 해당
            sb.append(points[0].x - 1).append("\n"); // 테두리를 위해 열을 하나 추가했으므로 빼줘야함.

        } // end of tc

        System.out.println(sb.toString()); // 정답 출력

    }// end of main

}// end of class

// x좌표 (실질적 열, y좌표)와 이동 거리를 기록한 클래스
class Point implements Comparable<Point> {
    int x; // x좌표
    int cnt; // 이동 거리

    public Point(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point p) {
        if (this.cnt == p.cnt)
            return p.x - this.x; // 복수의 개수 경우 가장 큰 x좌표를 반환 -> 내림차순 정렬
        return this.cnt - p.cnt; // 그 외, 가장 짧은 이동거리 순으로 정렬 -> 오름차순 정렬
    }
}