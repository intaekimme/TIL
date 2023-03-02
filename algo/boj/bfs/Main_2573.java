package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 2573 빙산, g4 bfs
 */
public class Main_2573 {

    static int n, m;
    static int ans = 0;
    static int[][] map, melt;

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }// end of init

    public static Queue<int[]> putIceberg(int[][] map, Queue<int[]> que) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0)
                    que.offer(new int[] { i, j });
            }
        }
        return que;
    }// end of putIceberg

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (map[x][y] != 0)
            return false;
        return true;
    }// end of canGo

    public static int[][] meltIceberg(int[][] map, Queue<int[]> que) {
        int[][] melt = new int[n][m];

        while (!que.isEmpty()) {
            // 현재 빙산의 위치
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];

            // 빙산 주위에 인접한 바닷물의 갯수
            int oceanCnt = 0;

            // 4방 탐색을 하며 바닷물 갯수 카운트
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny))
                    continue;
                oceanCnt++;
            }

            // 빙산을 녹임
            melt[x][y] = map[x][y] - oceanCnt > 0 ? map[x][y] - oceanCnt : 0;
        }

        // 녹은 결과 반환
        return melt;
    }// end of meltIceberg

    public static void copyMap(int[][] melt) {
        for (int i = 0; i < n; i++) {
            System.arraycopy(melt[i], 0, map[i], 0, m);
        }
    }// end of copyMap

    public static int countIceBerg(int[][] map) {
        Queue<int[]> que = new ArrayDeque<>();

        int icebergCnt = 0;

        // 방문 배열 생성
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || map[i][j] == 0)
                    continue;

                visited[i][j] = true;
                que.offer(new int[] { i, j });

                while (!que.isEmpty()) {
                    int[] cur = que.poll();

                    int x = cur[0];
                    int y = cur[1];

                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];

                        if (outOfRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 0)
                            continue;

                        visited[nx][ny] = true;
                        que.offer(new int[] { nx, ny });
                    }
                } // end of while(bfs)

                icebergCnt++;
            } // end of j loop

        } // end of i loop

        return icebergCnt;

    }// end of countIceBerg

    public static void sol() {
        Queue<int[]> que = new ArrayDeque<>();

        // 큐에 빙산을 넣어줌
        que = putIceberg(map, que);

        int icebergCnt = 0; // 빙산 덩어리 갯수
        while (true) {
            // 빙산이 녹은 결과
            melt = meltIceberg(map, que);

            // System.out.println("melt");
            // printMap(melt);
            // System.out.println("----------------");

            // 녹은 결과를 원래 맵에 복사
            copyMap(melt);

            // System.out.println("map");
            // printMap(map);
            // System.out.println("----------------");

            // 시간 1년 증가
            ans++;

            // 1년 후 빙산 덩어리 갯수 확인
            icebergCnt = countIceBerg(map);

            // 빙산 덩어리가 2개이면 종료
            if (icebergCnt >= 2)
                break;

            // 빙산이 다 녹았을때 까지 빙산 덩어리가 2개가 안되면
            if (icebergCnt == 0) {
                ans = 0;
                break;
            }

            // 빙산 덩어리가 2개가 안된다면 존재하는 빙산들을 que에 넣어줌
            que = new ArrayDeque<>();
            que = putIceberg(map, que);
        } // end of while

        // 정답 출력
        System.out.println(ans);

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

    static void printMap(int[][] map) {
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(map[i]));
    }// end of printMap

}// end of class
