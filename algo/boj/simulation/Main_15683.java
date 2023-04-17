package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 15683 감시, g4
 * 
 * 1시간 37분
 * 49536KB, 360ms
 * 
 * 사무실 : N * M
 * 사무실에 총 K개의 CCTV 설치 (정확한 위치는 모름)
 * 
 * CCTV 감시 방법 5개
 * CCTV가 바라보는 방향은 일직선으로 전체 감시
 * 단, 벽 통과 감시 안됨, CCTV끼리는 통과해서 감시 가능
 * 
 * CCTV는 회전 가능
 * 
 * 구하는 것 : CCTV를 적절히 회전해서 사각지대의 최소 크기를 구하라
 * 
 * 풀이
 * 경우의 수 구하면 할 일
 * 
 * 인덱스 i일 때
 * selected[i]의 값 : i번째 cctv의 방향 (0 ~ 4)
 * 
 * pos.get(i) : i 번째 cctv의 위치
 * 
 * map[pos.get(i)[0]][pos.get(i)[1]] : i번째 cctv의 유형
 * 
 * cctv[pos.get(i)[2] - 1] : i번째 cctv의 유형 (ArrayList<int[]>)
 * 
 * cctv[pos.get(i)[2] - 1].get(selected[i]) cctv가 바라보는 방향, dxdy 인덱스 (int[])
 * 
 */

public class Main_15683 {

    static int N, M;

    static int[][] map;

    static ArrayList<int[]> pos;

    static int[] selected; // CCTV가 바라 볼 수 있는 방향 경우의 수, 인덱스 : CCTV 번호

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    static ArrayList<int[]>[] cctv = new ArrayList[5];

    static int ans = 65; // 최소 사각지대 갯수, N, M <= 8이므로 가능한 최대 사각지대 갯수는 64개

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        pos = new ArrayList<>(); // CCTV 위치

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (0 < val && val < 6)
                    pos.add(new int[] { i, j, val });
                map[i][j] = val;
            }
        }

        selected = new int[pos.size()];

        for (int i = 0; i < 5; i++)
            cctv[i] = new ArrayList<>();

        // 1번 cctv
        for (int i = 0; i < 4; i++)
            cctv[0].add(new int[] { i });

        // 2번 cctv
        cctv[1].add(new int[] { 0, 2 });
        cctv[1].add(new int[] { 1, 3 });
        cctv[1].add(new int[] { 0, 2 });
        cctv[1].add(new int[] { 1, 3 });

        // 3번 cctv
        cctv[2].add(new int[] { 0, 1 });
        cctv[2].add(new int[] { 1, 2 });
        cctv[2].add(new int[] { 2, 3 });
        cctv[2].add(new int[] { 3, 0 });

        // 4번 cctv
        cctv[3].add(new int[] { 0, 1, 3 });
        cctv[3].add(new int[] { 0, 1, 2 });
        cctv[3].add(new int[] { 1, 2, 3 });
        cctv[3].add(new int[] { 2, 3, 0 });

        // 5번 cctv
        for (int i = 0; i < 4; i++)
            cctv[4].add(new int[] { 0, 1, 2, 3 });

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }// end of outOfRange

    public static int getBlindSpot() {

        // System.out.println(Arrays.toString(selected));

        // 시뮬레이션할 복사본 생성
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++)
            System.arraycopy(map[i], 0, copy[i], 0, M);

        for (int cur_cctv = 0; cur_cctv < selected.length; cur_cctv++) {

            int sel_dir = selected[cur_cctv]; // i번째 cctv의 방향 (0 ~ 4)

            int[] cur_cctv_pos = pos.get(cur_cctv); // i 번째 cctv의 위치

            int x = cur_cctv_pos[0]; // cctv x 좌표
            int y = cur_cctv_pos[1]; // cctv y 좌표

            int kind = cur_cctv_pos[2]; // i번째 cctv의 유형

            ArrayList<int[]> cctv_kind_dir = cctv[kind - 1]; // i번째 cctv의 유형

            // for (int i = 0; i < cctv_kind_dir.size(); i++) {
            // System.out.print(Arrays.toString(cctv_kind_dir.get(sel_dir)) + " ");
            // }
            // System.out.println();

            int[] dir = cctv_kind_dir.get(sel_dir); // cctv가 바라보는 방향, dxdy 인덱스

            // 찾은 dxdy 인덱스를 기반으로 cctv를 배치해봄

            for (int j = 0; j < dir.length; j++) {
                int d = dir[j];

                int nx = x;
                int ny = y;
                while (true) {
                    nx += dx[d];
                    ny += dy[d];

                    // 격자를 벗어나면 중단
                    if (outOfRange(nx, ny))
                        break;
                    // 벽을 만나면 중단
                    if (copy[nx][ny] == 6)
                        break;
                    // 다른 cctv면 제외
                    if (1 <= copy[nx][ny] && copy[nx][ny] <= 6)
                        continue;
                    copy[nx][ny] = -1; // 감시영역
                } // end of while
            } // end of for

        } // end of for (cctv)

        // 배치 후 사각지대 갯수 확인
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0)
                    cnt++;
            }
        }

        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < N; i++) {
        // sb.append(Arrays.toString(copy[i])).append("\n");
        // }
        // System.out.println(sb.toString());

        return cnt;
    }// end of getBlindSpot

    public static void perm(int depth, int n) {
        if (depth == n) {
            // cctv 방향 결정됨
            int cnt = getBlindSpot();

            ans = Math.min(ans, cnt); // 최소 사각지대 갯수 갱신
            return;
        }

        for (int i = 0; i < 4; i++) {
            selected[depth] = i;
            perm(depth + 1, n);
        }

    }// end of perm

    public static void simulation() {
        perm(0, pos.size()); // 경우의 수 생성

        // 모든 경우의 수 확인
        System.out.println(ans);
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main
}// end of class
