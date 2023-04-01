package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 드래곤 커브 복습~
 * 15685 g4
 * 
 * 시키는 대로 구현하기
 * 좌표와 배열 위치 잘 확인하기
 * 
 * 확장 개념 시 역순
 * 
 */

public class Main_15685_2 {

    static int n;

    static int[][] map = new int[101][101];

    static int[] dx = new int[] { 1, 0, -1, 0 };
    static int[] dy = new int[] { 0, -1, 0, 1 };

    public static void makeCurve(int x, int y, int d, int g) {
        ArrayList<Integer> list = new ArrayList<>();

        // 시작점 표시
        map[y][x] = 1;

        // 0세대 표시
        x += dx[d];
        y += dy[d];

        map[y][x] = 1;

        d = (d + 1) % 4;
        list.add(d);

        // 0세대 이후 세대 표시
        for (int i = g; i > 0; i--) {
            int len = list.size() - 1;
            for (int j = len; j >= 0; j--) {
                d = list.get(j);

                x += dx[d];
                y += dy[d];

                map[y][x] = 1;

                d = (d + 1) % 4;
                list.add(d);
            }
        }

    }// end of makeCurve

    public static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            makeCurve(x, y, d, g);
        }

        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        sol();
    }// end of main
}// end of class