package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 아기 상어 16236 g3
 * 
 * dfs로 접근하고 있었는데 이렇게 하면 문제에 주어진 조건대로 물고기를 찾을 수 가 없음
 */

public class Main_16236 {

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    static int N;

    static int[][] map;

    static int[] shark; // 0, 1 : 상어 위치, 2 : 상어 크기, 3 : 상어가 먹은 물고기 갯수

    static int ans = 0; // 최대 시간

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        shark = new int[4];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 9)
                    shark = new int[] { i, j, 2, 0 };
                map[i][j] = val;
            }
        }
    }// end of init

    public static void dfs(int[] shark, int[][] map, int time) {

        int cnt = 0; // 잡아 먹을 수 있는 물고기 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] < shark[2])
                    cnt++;
            }
        }

        if (cnt == 0) {
            ans = Math.max(ans, time);
            return;
        }

        // 먹을 수 있는 물고기 존재
        // 백트랙킹 위한 복사본 생성

        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++)
            System.arraycopy(map[i], 0, copy[i], 0, N);

        int[] shark_copy = new int[4];
        System.arraycopy(shark, 0, shark_copy, 0, 4);

        // 4방 탐색을 하며 갈 수 있는 곳을 가봄
        int x = shark[0];
        int y = shark[1];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 격자 밖은 제외
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            // 자신보다 큰 물고기가 있는 칸은 지나갈 수 없음
            if (map[nx][ny] > shark[2])
                continue;
        }

    }// end of dfs

    public static void simulation() {
        dfs(shark, map, 0);
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();

        System.out.println(ans);
    }// end of main
}// end of class
