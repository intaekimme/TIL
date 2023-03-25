package programmers.backend_dev_matching;

import java.util.*;

/**
 * 중요한 사각형 구하기
 * 비정형 형태의 격자가 주어짐
 * 한 블록이 맞닿은 다른 블록의 갯수를 센다
 * 가장 많은 다른 블록과 맞닿은 블록이 가장 중요한 블록
 * 이 때 블록의 좌표를 구하는 문제
 * 
 * 
 * 결과 : 94.1 / 100
 * 테스트 케이스 9번 틀림
 */

class Solution_1 {

    int n;
    int m;

    int[] dx = new int[] { -1, 0, 1, 0 };
    int[] dy = new int[] { 0, 1, 0, -1 };

    int[][] map;

    boolean[][] visited;

    ArrayList<Block> list = new ArrayList<>();

    public void makeMap(String[] wall) {
        n = wall.length;
        StringTokenizer st = new StringTokenizer(wall[0]);

        while (st.hasMoreTokens()) {
            m += Integer.parseInt(st.nextToken());
        }

        // System.out.println(n + ", " + m);

        map = new int[n][m];

        int map_x = 0;
        int map_y = 0;

        int block_x = 0;
        int block_y = 0;
        int block_num = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(wall[i]);
            while (st.hasMoreTokens()) {
                int val = Integer.parseInt(st.nextToken());

                list.add(new Block(block_x, block_y++));

                for (int j = 0; j < val; j++) {
                    map[map_x][map_y++] = block_num;
                }

                block_num++;
            }

            block_x++;
            map_x++;
            block_y = 0;
            map_y = 0;
        }

        // for(int i = 0; i < n; i++) {
        // System.out.println(Arrays.toString(map[i]));
        // }
    }// end of makeMap

    public boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }// end of outOfRange

    public void findAdjBlock() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {

                int cur_block = map[x][y];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (outOfRange(nx, ny))
                        continue;

                    int next_block = map[nx][ny];

                    if (cur_block == next_block)
                        continue;

                    HashSet<Integer> adj_blocks = list.get(cur_block).adj;
                    if (!adj_blocks.contains(next_block)) {
                        adj_blocks.add(next_block);
                    }
                } // end of k loop
            } // end of y loop
        } // end of x loop
    }// end of findAdjBlock

    public int[][] solution(String[] wall) {

        makeMap(wall);

        findAdjBlock();

        Collections.sort(list);

        // for (int i = 0; i < list.size(); i++) {
        // System.out.println("no : " + (i + 1) + " // " +list.get(i).toString());
        // }

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i).adj.size());
        }

        ArrayList<int[]> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (max == list.get(i).adj.size()) {
                // System.out.println("no : " + (i + 1) + " // " +list.get(i).toString());
                int x = list.get(i).x;
                int y = list.get(i).y;
                ans.add(new int[] { x, y });
            }
        }

        int[][] answer = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            answer[i][0] = ans.get(i)[0];
            answer[i][1] = ans.get(i)[1];
            // System.out.println(Arrays.toString(answer[i]));
        }

        return answer;
    }// end of solution
}

class Block implements Comparable<Block> {
    int x;
    int y;
    HashSet<Integer> adj;
    int size = 0;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.adj = new HashSet<>();
    }

    @Override
    public int compareTo(Block b) {
        if (this.adj.size() == b.adj.size()) {
            if (this.x == b.x)
                return this.y - b.y; // y좌표 오름차순
            return this.x - b.y; // x좌표 오름차순
        }
        return b.adj.size() - this.adj.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x : ").append(x).append(" // y : ").append(y);
        sb.append(" // nodes : ").append(this.adj.toString()).append("\n");
        return sb.toString();
    }
}// end of class
