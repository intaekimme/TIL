package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 청소년 상어 19236 g2 fail
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
 */

public class Main_19236 {

    // 8방 탐색 0 ~ 7이 1번에서 8번에 해당
    static int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = new int[] { 0, -1, -1, -1, 0, 1, 1, 1 };

    static ArrayList<Fish> fishes = new ArrayList<>();

    // 물고기와 상어가 있는 맵;
    // 1 ~ 16 : 물고기
    // 0 : 빈 칸
    // -1 : 상어
    static int[][] map;

    static Shark shark;

    // 초기화
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        map = new int[4][4];

        fishes.add(new Fish(-1, -1, 5, 5));

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int id = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                Fish fish = new Fish(id, dir, i, j);
                fishes.add(fish);

                map[i][j] = id;
            }
        }

        Collections.sort(fishes);

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= 4 || y < 0 || y >= 4;
    }// end of outOfRange

    // 상어가 이동할 수 있는 칸이 있는지 없는지 판단
    // 공간 내에서 상어가 바라보고 있는 방향으로 물고기가 한 마리라도 존재하면 이동할 수 있다.
    // 그렇지 않으면 이동할 수 없다.
    public static boolean canNotGo(Shark shark) {
        int cur_x = shark.x;
        int cur_y = shark.y;

        int dir = shark.dir;

        int fish_cnt = 0; // 상어가 바라보고 있는 방향에서 물고기 수
        for (int i = 0; i < 3; i++) {
            cur_x += dx[dir];
            cur_y += dy[dir];

            if (outOfRange(cur_x, cur_y))
                break;

            // 바라보는 방향에 물고기가 존재하면
            if (map[cur_x][cur_y] > 0)
                fish_cnt++;
        }

        // 바라보고 있는 방향에 물고기가 존재하지 않으면 이동할 수 없어 집으로 이동
        if (fish_cnt == 0)
            return true;
        return false; // 이동할 수 있음

    }// end of canNotGo

    public static void findAndMove(Fish fish) {
        int dir = fish.dir;

        int x = fish.x;
        int y = fish.y;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[(dir + i) % 8];
            int ny = y + dy[(dir + i) % 8];

            if (outOfRange(nx, ny))
                continue;
            // 빈 칸이거나 물고기가 있는 칸이면
            // 빈 칸이면
            if (map[nx][ny] == 0) {
                fish.dir = (dir + i) % 8;
                fish.x = nx;
                fish.y = ny;

                map[x][y] = 0;
                map[nx][ny] = fish.id;
                break;
            }
            if (map[nx][ny] > 0) {
                fish.dir = (dir + i) % 8;
                int another_id = map[nx][ny];
                Fish another = fishes.get(another_id);
                Fish tmp = another;

                map[x][y] = another_id;
                map[nx][ny] = fish.id;

                another = fish;
                fish = tmp;
                break;
            }
        }
    }// end of findAndMove

    // 재귀 함수
    public static void dfs(Shark shark) {

        // 기저 조건
        if (canNotGo(shark)) {
            return;
        }

        // 물고기 이동
        // 번호가 작은 물고기 중 살아있는 물고기만 이동
        for (int i = 1; i <= fishes.size(); i++) {
            Fish fish = fishes.get(i);
            // 죽은 물고기는 이동에서 제외
            if (!fish.alive)
                continue;

            System.out.println(fishes.toString());
            findAndMove(fish);
            System.out.println(fishes.toString());
        }

    }// end of dfs

    public static void simulation() {
        // (0, 0)에 상어 투입
        int id = map[0][0];

        Fish f = fishes.get(id);

        shark = new Shark(f.dir, 0, 0);
        f.alive = false;
        map[0][0] = -1;

        // System.out.println(fishes.toString());

        // fishes.remove(id);
        // fishes.add(id, null);
        // System.out.println(fishes.toString());

        dfs(shark);

    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main

}// end of class

class Shark {
    int dir;
    int x;
    int y;

    public Shark(int dir, int x, int y) {
        this.dir = dir;
        this.x = x;
        this.y = y;
    }
}// end of Shark

class Fish implements Comparable<Fish> {
    int id;
    int dir;
    int x;
    int y;
    boolean alive;

    public Fish(int id, int dir, int x, int y) {
        this.id = id;
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.alive = true;
    }

    @Override
    public int compareTo(Fish f) {
        return this.id - f.id; // 오름차순 정렬
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id).append(" ").append(this.dir);

        return sb.toString();
    }
}// end of class
