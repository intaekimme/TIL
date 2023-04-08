package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 청소년 상어 19236 g2
 * 
 * 물고기 -> 상어 순으로 이동
 * 
 * 8방 탐색
 * 
 * 물고기의 이동
 * 번호가 작은 물고기부터 순서대로 이동 (pq로 관리?)
 * 
 * 한 칸만 이동 가능
 * 이동가능한 칸 : 빈 칸, 물고기가 있는 칸
 * 
 * 탐색 시작 당시 방향으로부터 8방 탐색하며 이동 가능한 칸 탐색
 * 없으면 탐색 시작 방향으로 돌아오며 현재 위치 고수
 * 
 * 빈 칸 : 찾은 방향 유지하며 해당 칸으로 이동
 * 물고기 있는 칸 : 찾은 방향 유지하며 해당 칸의 물고기와 위치만 교환
 * 
 * 실패 원인 : 재귀함수를 이용한 백트래킹 문제를 푼 경험이 많이 없어
 * 자료형의 원복이 서툴러 시간이 너무 오래 걸림
 */

public class Main_19236 {

    // 8방 탐색 0 ~ 7이 1번에서 8번에 해당
    static int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };

    static Fish[] fishes = new Fish[16];

    // 물고기와 상어가 있는 맵;
    // 1 ~ 16 : 물고기
    // 0 : 빈 칸
    // -1 : 상어
    static int[][] map;

    static int ans = 0; // 최종 정답

    // 초기화
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        map = new int[4][4];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int id = Integer.parseInt(st.nextToken()) - 1;
                int dir = Integer.parseInt(st.nextToken()) - 1;

                fishes[id] = new Fish(dir, i, j, false);

                map[i][j] = id;
            }
        }

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= 4 || y < 0 || y >= 4;
    }// end of outOfRange

    // 재귀 함수
    // 상어의 이동과 물고기의 이동이 반복되는 함수
    // 상어 x, y, 먹은 먹이
    public static void dfs(int[][] origin_map, Fish[] origin_fishes, int shark_x, int shark_y, int sum) {
        // 백트랙킹을 위한 백업
        // 어느 지점이 최적인지 모름, 그 동안 상태가 변경됨, 아니면 이전 상태로 돌려야함 그래서 로컬로 백업함
        int[][] map = new int[4][4];
        for (int i = 0; i < 4; i++)
            System.arraycopy(origin_map[i], 0, map[i], 0, 4);

        Fish[] fishes = new Fish[16];
        for (int i = 0; i < 16; i++) {
            Fish f = origin_fishes[i];
            fishes[i] = new Fish(f.dir, f.x, f.y, f.isDead);
        }

        // 상어가 물고기를 먹는다.
        int fish_number = map[shark_x][shark_y];
        int shark_dir = fishes[fish_number].dir;

        // 죽은 물고기는 -1 처리
        fishes[fish_number].x = -1;
        fishes[fish_number].y = -1;
        fishes[fish_number].dir = -1;
        fishes[fish_number].isDead = true;
        map[shark_x][shark_y] = -1;

        sum += fish_number + 1;
        ans = Math.max(ans, sum);

        // 물고기가 이동한다.
        // 모든 물고기에 대해
        for (int i = 0; i < 16; i++) {
            if (fishes[i].isDead)
                continue;

            int cx = fishes[i].x;
            int cy = fishes[i].y;
            int cd = fishes[i].dir;

            int nx = cx + dx[cd];
            int ny = cy + dy[cd];
            int nd = cd;

            // 범위 밖이거나 상어가 있으면
            while (outOfRange(nx, ny) || (nx == shark_x && ny == shark_y)) {
                nd = (nd + 1) % 8;
                nx = cx + dx[nd];
                ny = cy + dy[nd];
            }

            if (map[nx][ny] != -1) {
                int target = map[nx][ny];
                fishes[target].x = cx;
                fishes[target].y = cy;
                fishes[i].x = nx;
                fishes[i].y = ny;
                fishes[i].dir = nd;

                map[nx][ny] = i;
                map[cx][cy] = target;
            } else {
                fishes[i].x = nx;
                fishes[i].y = ny;
                fishes[i].dir = nd;

                map[nx][ny] = i;
                map[cx][cy] = -1;
            }
        }

        // 상어가 이동한다. -> 상어가 물고기를 먹는다.
        for (int step = 1; step < 4; step++) {
            int nx = shark_x + dx[shark_dir] * step;
            int ny = shark_y + dy[shark_dir] * step;

            if (outOfRange(nx, ny))
                break;
            if (map[nx][ny] != -1)
                dfs(map, fishes, nx, ny, sum);
        }

    }// end of dfs

    public static void simulation() {
        dfs(map, fishes, 0, 0, 0);
        System.out.println(ans);
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main

}// end of class

class Fish {
    int dir;
    int x;
    int y;
    boolean isDead;

    public Fish(int dir, int x, int y, boolean isDead) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.isDead = isDead;
    }
}// end of class
