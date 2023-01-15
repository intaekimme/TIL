package show_me_the_code;

import java.io.*;
import java.util.*;

public class Main_b_timeout {

    static int n; // n행
    static int m; // m열

    static final int[] dx = { 0, -1, 0, 1 }; // 4방탐색
    static final int[] dy = { 1, 0, -1, 0 };

    static int[][] map; // n * m 맵
    static boolean[][] visited; // 방문 배열
    static int area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        // 맵 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 영역 찾기 시작
        area = 2; // 영역표시는 2부터 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || map[i][j] == 1) // 이미 방문한 곳이거나 벽은 pass
                    continue;
                bfs(i, j); // i, j 좌표에서 같은 영역 bfs 탐색
                area++; // 같은 영역은 다 찾았으므로 다음영역 표시를 위해 1증가
            }
        } // end of search

        System.out.println(area - 2); // 센 영역의 갯수 - 2이 행성에 존재하는 영역의 갯수

        // 검산
        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // sb.append(map[i][j]).append(" ");
        // }
        // sb.append("\n");
        // }
        // System.out.println(sb.toString());

    }// end of main

    public static void bfs(int xs, int ys) {
        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[] { xs, ys });

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            map[x][y] = area; // 영역 표시
            visited[x][y] = true; // 방문 표시

            // 새로운 점 탐색시작
            if (isSpecial(x, y)) { // 4방 탐색시 특별한 좌표인가?
                for (int i = 0; i < 4; i++) {
                    int[] nxny = getCoord(x, y, i);
                    int nx = nxny[0];
                    int ny = nxny[1];

                    if (isValid(nx, ny))
                        continue;
                    que.offer(new int[] { nx, ny });
                }
            } else { // 아니면 일반 좌표인가, 일반 좌표는 범위체크 필요 없음, 4방 탐색이면 됨.
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // 이미 방문한 점이거나, 벽이면 pass
                    if (isValid(nx, ny))
                        continue;
                    // 새로 방문이 가능한 점이므로 que에 넣어줌
                    que.offer(new int[] { nx, ny });
                }
            }

        } // end of while

    }// end of bfs

    // (0,0)부터 시계방향으로 8개 구역에 대한 4방탐색 좌표 반환
    // dir : 0; 상, 1; 우, 2; 하, 3; 좌
    public static int[] getCoord(int x, int y, int dir) {
        // 1번 구역
        if (x == 0 && y == 0) {
            if (dir == 0)// 상
                return new int[] { n - 1, y };
            if (dir == 1)// 우
                return new int[] { x, y + 1 };
            if (dir == 2)// 하
                return new int[] { x + 1, y };
            if (dir == 3)// 좌
                return new int[] { x, m - 1 };
        }
        // 2번 구역
        if (x == 0 && (0 < y && y < m - 1)) {
            if (dir == 0)// 상
                return new int[] { n - 1, y };
            if (dir == 1)// 우
                return new int[] { x, y + 1 };
            if (dir == 2)// 하
                return new int[] { x + 1, y };
            if (dir == 3)// 좌
                return new int[] { x, y - 1 };
        }
        // 3번 구역
        if (x == 0 && y == m - 1) {
            if (dir == 0)// 상
                return new int[] { n - 1, y };
            if (dir == 1)// 우
                return new int[] { x, 0 };
            if (dir == 2)// 하
                return new int[] { x + 1, y };
            if (dir == 3)// 좌
                return new int[] { x, y - 1 };
        }
        // 4번 구역
        if ((0 < x && x < n - 1) && y == m - 1) {
            if (dir == 0)// 상
                return new int[] { x - 1, y };
            if (dir == 1)// 우
                return new int[] { x, 0 };
            if (dir == 2)// 하
                return new int[] { x + 1, y };
            if (dir == 3)// 좌
                return new int[] { x, y - 1 };
        }
        // 5번 구역
        if (x == n - 1 && y == m - 1) {
            if (dir == 0)// 상
                return new int[] { x - 1, y };
            if (dir == 1)// 우
                return new int[] { x, 0 };
            if (dir == 2)// 하
                return new int[] { 0, y };
            if (dir == 3)// 좌
                return new int[] { x, y - 1 };
        }
        // 6번 구역
        if (x == n - 1 && (0 < y && y < m - 1)) {
            if (dir == 0)// 상
                return new int[] { x - 1, y };
            if (dir == 1)// 우
                return new int[] { x, y + 1 };
            if (dir == 2)// 하
                return new int[] { 0, y };
            if (dir == 3)// 좌
                return new int[] { x, y - 1 };
        }
        // 7번 구역
        if (x == n - 1 && y == 0) {
            if (dir == 0)// 상
                return new int[] { x - 1, y };
            if (dir == 1)// 우
                return new int[] { x, y + 1 };
            if (dir == 2)// 하
                return new int[] { 0, y };
            if (dir == 3)// 좌
                return new int[] { x, m - 1 };
        }
        // 8번 구역
        // if ((0 < x && x < n-1) && y == 0)
        if (dir == 0)// 상
            return new int[] { x - 1, y };
        if (dir == 1)// 우
            return new int[] { x, y + 1 };
        if (dir == 2)// 하
            return new int[] { x + 1, y };
        // 좌
        return new int[] { x, m - 1 };
    }

    public static boolean isSpecial(int x, int y) {
        return (x == 0 || x == n - 1 || y == 0 || y == m - 1);
    }// end of isSpecial

    public static boolean isValid(int x, int y) {
        return (visited[x][y] || map[x][y] == 1);
    }

}// end of class
