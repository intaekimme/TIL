package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 아기 상어 16236 g3
 * 
 * 1시간 30분
 * 25236kb, 248ms
 */

public class Main_16236 {

    static final int MAX = (int) 1e9;

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    static int N;

    static int[][] map;

    static int[] shark; // 0, 1 : 상어 위치, 2 : 상어 크기, 3 : 상어가 먹은 물고기 갯수

    static int time = 0; // 시간

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

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }// end of outOfRange

    public static int[] getMinDistFish() {

        int cnt = 0; // 먹을 수 있는 물고기 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || map[i][j] == 9)
                    continue;
                if (map[i][j] < shark[2])
                    cnt++;
            }
        }

        if (cnt == 0) {
            return new int[] { -1, -1 };
        }
        // -------------------------------------

        Queue<int[]> que = new ArrayDeque<>();

        boolean[][] visited = new boolean[N][N];
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++)
            Arrays.fill(dist[i], MAX);

        int sx = shark[0];
        int sy = shark[1];

        dist[sx][sy] = 0;

        visited[sx][sy] = true;
        que.offer(new int[] { sx, sy });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 격자 벗어나면 못지나감
                if (outOfRange(nx, ny))
                    continue;
                // 이미 방문한 곳이거나 물고기 크기가 상어 크기보다 크면 못 지나감
                if (visited[nx][ny] || map[nx][ny] > shark[2])
                    continue;
                dist[nx][ny] = dist[x][y] + 1;
                visited[nx][ny] = true;
                que.offer(new int[] { nx, ny });
            }
        } // end of while

        // -------------------------------------

        ArrayList<int[]> cand = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == sx && j == sy)
                    continue;
                if (map[i][j] == 0 || map[i][j] == 9)
                    continue;
                // 상어보다 작은 물고기이고, 갈 수 있는 곳이면
                if (map[i][j] < shark[2] && dist[i][j] != MAX)
                    cand.add(new int[] { i, j, dist[i][j] });
            }
        }

        Collections.sort(cand, (o1, o2) -> {
            if (o1[2] == o2[2]) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1]; // 열 오름차순 정렬
                return o1[0] - o2[0]; // 행 오름차순 정렬
            }
            return o1[2] - o2[2]; // 거리 오름 차순 정렬
        });
        // -------------------------------------

        if (cand.size() == 0)
            return new int[] { -1, -1 };

        int[] pray = cand.get(0);

        time += pray[2];

        int px = pray[0];
        int py = pray[1];

        shark[0] = px;
        shark[1] = py;

        map[sx][sy] = 0;
        map[px][py] = 9;

        if (shark[3] + 1 >= shark[2]) {
            shark[2]++;
            shark[3] = 0;
        } else {
            shark[3]++;
        }

        return pray;

    }// end of getMinDistFish

    public static void simulation() {
        while (true) {
            int[] pos = new int[] { -1, -1 };

            pos = getMinDistFish();

            if (pos[0] == -1 && pos[1] == -1)
                break;
        }
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();

        System.out.println(time);
    }// end of main
}// end of class
