package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 2146 다리 만들기 g3
 * 
 * 1. 입력
 * 2. 섬 표시
 * 3. 해안을 따로 관리 or 섬의 육지 중 해안에 해당하면
 * 4. 다른 섬의 육지를 찾을 때까지 bfs 시행 (4방 탐색, 방문처리)
 * 5. 모든 해안에 대해 시행하며 최솟값 갱신
 * 6. 이 후 결과가 정답
 */

public class Main_2146 {

    static int n;

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, -1, 0, 1 };

    static int[][] map, input, dist;
    static boolean[][] visited;

    static int ans = Integer.MAX_VALUE;

    static ArrayList<int[]> shore = new ArrayList<>();

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }// end of outOfRange

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || input[x][y] == 0)
            return false;
        return true;
    }// end of canGo

    public static void makeIsland(int sx, int sy, int kind) {
        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[] { sx, sy });
        visited[sx][sy] = true;
        map[sx][sy] = kind;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny))
                    continue;
                visited[nx][ny] = true;
                map[nx][ny] = kind;
                que.offer(new int[] { nx, ny });
            }

        } // end of while

    }// end of makeIsland

    public static void makeShore(int sx, int sy) {
        Queue<int[]> que = new ArrayDeque<>();

        visited[sx][sy] = true;
        que.offer(new int[] { sx, sy });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (outOfRange(nx, ny))
                    continue;
                if (map[nx][ny] == 0) {
                    shore.add(cur);
                    break;
                }
                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    que.offer(new int[] { nx, ny });
                }

            }
        }
    }// end of makeShore

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        input = new int[n][n];
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];

        int kind = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || input[i][j] == 0)
                    continue;
                makeIsland(i, j, kind++);

            }
        }

        for (int i = 0; i < n; i++)
            Arrays.fill(visited[i], false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || map[i][j] == 0)
                    continue;
                makeShore(i, j);
            }
        }

    }// end of init

    public static int findShortDist(int sx, int sy, int kind) {
        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[] { sx, sy });
        visited[sx][sy] = true;
        dist[sx][sy] = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (outOfRange(nx, ny) || visited[nx][ny])
                    continue;
                if (map[nx][ny] != 0 && map[nx][ny] != kind) {
                    return dist[x][y];
                }
                dist[nx][ny] = dist[x][y] + 1;
                visited[nx][ny] = true;
                que.offer(new int[] { nx, ny });
            }
        }
        return (int) 1e4;
    }// end of findShortDist

    public static void sol() {

        for (int i = 0; i < shore.size(); i++) {
            dist = new int[n][n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[j], (int) 1e4);
                Arrays.fill(visited[j], false);
            }

            int[] cur = shore.get(i);
            int x = cur[0];
            int y = cur[1];

            int kind = map[x][y];
            ans = Math.min(ans, findShortDist(x, y, kind));
        } // end of for

        System.out.println(ans);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main
}
