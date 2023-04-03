package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 21609 상어 중학교 g2
 * 
 * 일반 블록 M (M > 0)
 * 검은색 블록 -1
 * 무지개 블록 0
 * 빈 칸 -2
 */

public class Main_21609 {

    static int n, m;

    static int[][] map1, map2;

    static boolean[][] visited;

    static int ans = 0;

    static PriorityQueue<BlockGroup> pq;

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(st.nextToken());
            for (int j = 0; j < n; j++)
                map1[i][j] = Integer.parseInt(st.nextToken());
        }

    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }// end of canGo

    // 새로 찾은 x좌표, 새로 찾은 y좌표, 시작 컬러
    public static boolean canGo(int x, int y, int color) {
        if (outOfRange(x, y)) // 범위 밖인가
            return false;
        if (visited[x][y]) // 이미 방문을 했는가
            return false;
        if (map1[x][y] < 0) // 검은색 블록이나 빈 칸이면
            return false;
        if (map1[x][y] > 0 && map1[x][y] != color) // 일반 블록인데 다른 색이면
            return false;
        if (map1[x][y] == 0) // 무지개 블록이면
            return true;
        if (map1[x][y] == color) // 같은 색의 일반 블록이면
            return true;
        return true;
    }// end of canGo

    // 블록 그룹 찾는 함수
    public static void makeBlockGroup(int sx, int sy) {
        visited = new boolean[n][n];

        BlockGroup group = new BlockGroup();

        // bfs 탐색에 사용할 큐
        Queue<int[]> que = new ArrayDeque<>();

        int[] start = new int[] { sx, sy };
        que.offer(start);
        visited[sx][sy] = true;

        int color = map1[sx][sy]; // 탐색 시작 컬러
        int rainbowBlockCnt = 0;

        group.standardBlocks.offer(start);
        group.blocks.add(start);

        // bfs로 같은 그룹의 블록을 찾는다.
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny, color))
                    continue;

                // 블록 그룹내 무지개 블록 갯수 증가
                if (map1[nx][ny] == 0)
                    rainbowBlockCnt++;

                visited[nx][ny] = true;
                que.offer(new int[] { nx, ny });

                if (map1[nx][ny] != 0)
                    group.standardBlocks.offer(new int[] { nx, ny });
                group.blocks.add(new int[] { nx, ny });
            }
        } // end of while

        // 블록 그룹 내 기준 블록
        int[] standard_block = group.standardBlocks.peek();

        // 그룹 내 기준 블록 좌표
        group.x = standard_block[0];
        group.y = standard_block[1];

        // 그룹 내 무지개 블록 수
        group.rainbowBlockCnt = rainbowBlockCnt;

        // 블록 그룹들에 추가
        pq.offer(group);

    }// end of makeBlockGroup

    // 모든 격자에 대해 블록 그룹 찾기
    public static void findBlockGroup() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map1[i][j] > 0)
                    makeBlockGroup(i, j);
            }
        }
    }// end of findBlockGroup

    public static void deleteBlockGroup(BlockGroup group) {

    }// end of deleteBlockGroup

    public static void simulation() {
        while (true) {
            // 블록 그룹 저장 공간
            pq = new PriorityQueue<>();
            // 블록 그룹 찾기
            findBlockGroup();

            // 블록 그룹이 더 이상 존재하지 않으면 플레이 중단,
            if (pq.isEmpty())
                break;

            // 가장 큰 블록 그룹
            BlockGroup maxSizeBlockGroup = pq.peek();

            // 가장 큰 블록 그룹 제거
            deleteBlockGroup(maxSizeBlockGroup);

        } // end of while

        System.out.println(ans); // 점수 출력
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main

}// end of class

class BlockGroup implements Comparable<BlockGroup> {
    int x;
    int y;
    int rainbowBlockCnt;
    PriorityQueue<int[]> standardBlocks;
    ArrayList<int[]> blocks;
    int score;

    public BlockGroup() {
        this.x = 0;
        this.y = 0;
        this.rainbowBlockCnt = 0;
        this.standardBlocks = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        this.blocks = new ArrayList<>();
        this.score = 0;
    }

    @Override
    public int compareTo(BlockGroup b) {
        if (b.blocks.size() == this.blocks.size()) {
            if (b.rainbowBlockCnt == this.rainbowBlockCnt) {
                if (b.x == this.x)
                    return b.y - this.y; // 열이 가장 큰 것
                return b.x - this.x; // 행이 가장 큰 것
            }
            return b.rainbowBlockCnt - this.rainbowBlockCnt; // 무지개 블록이 가장 많은 것
        }
        return b.blocks.size() - this.blocks.size(); // 가장 큰 블록 그룹
    }

}// end of class
