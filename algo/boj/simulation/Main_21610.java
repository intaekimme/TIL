package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 마법사 상어와 비바라기, g5
 * 
 * somthing commit
 */

public class Main_21610 {

    static int N, M;
    static int[][] map;
    static int[][] copy;

    static Queue<int[]> cloud;
    static int[][] moveInfo;

    static int[][] isDisappear;

    static int[] dx = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dy = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        cloud = new ArrayDeque<>();
        moveInfo = new int[M][];

        // 구름 좌표 생성
        cloud.add(new int[] { N - 1, 0 });
        cloud.add(new int[] { N - 1, 1 });
        cloud.add(new int[] { N - 2, 0 });
        cloud.add(new int[] { N - 2, 1 });

        // 맵 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구름 방향 및 이동 거리 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            moveInfo[i] = new int[] { d, s };
        }

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        // 격자를 벗어났으면 카운트 하지 않음
        if (outOfRange(x, y))
            return false;
        // 물이 없으면 카운트 하지 않음
        if (copy[x][y] == 0)
            return false;
        return true;
    }// end of canGo

    public static void simulation() {
        int dir = 0;

        // M번 동안 이동
        while (dir++ < M) {
            // 물 증가여부 맵 생성
            int[][] copy = new int[N][N];

            // 기존 맵 복사
            for (int i = 0; i < N; i++)
                System.arraycopy(map[i], 0, copy[i], 0, N);

            isDisappear = new int[N][N];

            // 구름 이동 시작
            int c_size = cloud.size();
            int[] m = moveInfo[dir];

            int d = m[0];
            int s = m[1];

            for (int i = 0; i < c_size; i++) {
                int[] cur = cloud.poll();

                // 현재 구름 좌표
                int x = cur[0];
                int y = cur[1];

                // 구름 이동 후 좌표
                int nx = (x + (dx[d] * s) + N) % N;
                int ny = (y + (dy[d] * s) + N) % N;

                // 이동 후로 기록
                isDisappear[nx][ny] = 1;

                // 이동 후 좌표 기록
                cloud.add(new int[] { nx, ny });
            } // 구름 이동 끝

            // 구름 사라짐 + 물 증가
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isDisappear[i][j] == 1) {
                        // 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1증가
                        copy[i][j]++;
                        // 구름이 모두 사라짐
                        isDisappear[i][j] = 2;
                    }
                }
            }

            // 물 복사 시작
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    // 물이 증가하지 않은 칸은 제외
                    if (map[x][y] >= copy[x][y])
                        continue;
                    // 물이 증가한 칸이라면

                    // 대각선에 방향으로 거리가 1인 칸에 물이 있는 바구니 수 조사
                    int cnt = 0;
                    for (int k = 1; k < 8; k += 2) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if (!canGo(nx, ny))
                            continue;
                        // 조건 만족하는 바구니 카운트
                        cnt++;
                    }

                    // 물이 있는 바구니 수 만큼 (r, c)에 물 증가
                    copy[x][y] += cnt;
                }
            }

            // 구름 생성
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 바구니에 저장된 물의 양이 2보다 작거나 구름이 사라진 칸이라면 구름 생성되지 않음
                    if (copy[i][j] < 2 || isDisappear[i][j] == 2)
                        continue;

                    // 구름이 생성되고 물의 양이 2줄어듬
                    copy[i][j] = copy[i][j] - 2 >= 0 ? copy[i][j] - 2 : 0;

                }
            }

        } // end of while
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main
}// end of class
