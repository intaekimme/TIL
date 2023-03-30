package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 15685 g4 드래곤 커브 풀이 1
 * 시작 좌표에서 정해진 규칙에 따라 방향을 회전해가면서 확장
 * 점은 계속 누적해야 함
 * 
 * 점에 기록해야 할 것은 방향, 그 당시 방향이 다음세대에서 90도 회전한 방향으로 변경된다.
 * 점을 읽을 때는 역순으로 읽는다.
 */

public class Main_15685 {

    static int tc;

    static boolean[][] map = new boolean[101][101];

    // 다음 커브 방향, 인덱스가 현재 커브 방향, 값이 회전한 다음 방향
    static int[] curveDir = new int[] { 1, 2, 3, 0 };

    static int[] dy = new int[] { 0, -1, 0, 1 };
    static int[] dx = new int[] { 1, 0, -1, 0 };

    public static void makeCurve(int x, int y, int d, int g) {
        // 0세대
        // 출발점
        map[y][x] = true;

        // 0세대 끝점
        int endR = y + dy[d];
        int endC = x + dx[d];
        int endDir = curveDir[d];

        List<Point> points = new ArrayList<>();
        points.add(new Point(endR, endC, endDir));

        // 주어진 세대만큼 반복
        for (int i = 0; i < g; i++) {
            // 역순으로 조회
            for (int j = points.size() - 1; j >= 0; j--) {
                Point last = points.get(j);
                endR += dy[last.d];
                endC += dx[last.d];
                endDir = curveDir[last.d];

                points.add(new Point(endR, endC, endDir));
            }
        }
    }// end of makeCurve

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int x, y, d, g;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            makeCurve(x, y, d, g);
        }

        int cnt = 0;
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                if (map[r][c] && map[r][c + 1] && map[r + 1][c] && map[r + 1][c + 1])
                    cnt++;
            }
        }

        System.out.println(cnt);

    }// end of main

    static class Point {
        int r, c, d;

        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
            map[r][c] = true;
        }
    }// end of Point class

}// end of class
