package Intermediate_low.simulation.exhaustive_search;

import java.io.*;
import java.util.*;

/**
 * 사각형 1 크기 결정 : 5 * 5 = 25
 * 사각형 2 크기 결정 : 5 * 5 = 25
 * 사각형 1 위치 확인 : 5 * 5 = 25
 * 사각형 2 위치 확인 : 5 * 5 = 25
 * 
 * >> 9765625
 * 
 */

public class Main_6 {

    static int n, m;

    static int[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;

        // 사각형 1 크기 결정
        for (int x1 = 1; x1 <= n; x1++) {
            for (int y1 = 1; y1 <= m; y1++) {

                // 사각형 2 크기 결정
                for (int x2 = 1; x2 <= n; x2++) {
                    for (int y2 = 1; y2 <= m; y2++) {

                        // 사각형 1 시작위치 결정
                        for (int r1 = 1; r1 <= n; r1++) {
                            for (int c1 = 1; c1 <= m; c1++) {
                                if (outOfRange(r1, c1, x1, y1))
                                    continue;

                                // 사각형 2 시작 위치 결정
                                for (int r2 = 1; r2 <= n; r2++) {
                                    for (int c2 = 1; c2 <= m; c2++) {
                                        if (outOfRange(r2, c2, x2, y2))
                                            continue;

                                        visited = new int[n + 1][m + 1];
                                        mark(r1, c1, x1, y1);
                                        mark(r2, c2, x2, y2);

                                        if (isOverlap())
                                            continue;

                                        int sum = 0;

                                        for (int i = 1; i <= n; i++) {
                                            for (int j = 1; j <= m; j++) {
                                                if (visited[i][j] == 0)
                                                    continue;
                                                sum += map[i][j];
                                            }
                                        }

                                        max = Math.max(sum, max);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        } // end of for

        System.out.println(max);

    }// end of main

    public static boolean outOfRange(int r, int c, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if ((r + i) > n || (c + j) > m) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void mark(int r, int c, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                visited[r + i][c + j] += 1;
            }
        }

    }

    public static boolean isOverlap() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (visited[i][j] > 1)
                    return true;
            }
        }
        return false;
    }

}// end of class
