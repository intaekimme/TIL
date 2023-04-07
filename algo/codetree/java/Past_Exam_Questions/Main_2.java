package Past_Exam_Questions;

import java.io.*;
import java.util.*;

/**
 * 
 * 예술점수 구하는 과정
 * 
 * 1. 예술 점수 구하기
 * 1-1. 그룹 구하기
 * 1-2. 그룹 쌍 구하기
 * 1-2-1. 그룹 쌍 중 조화로운 그룹 구하기
 * 1-3. 예술 점수 구하기
 * 
 * 2. 회전하기
 *
 */

public class Main_2 {

    static final int[] dx = new int[] { -1, 0, 1, 0 };
    static final int[] dy = new int[] { 0, 1, 0, -1 };

    static int n; // 항상 홀수
    static int half;

    static int[][] map;
    static boolean[][] visited;

    static int ans = 0; // 3회의 예술 점수 총점

    static ArrayList<Integer> group_value; // 그룹 값 정보
    static ArrayList<ArrayList<int[]>> group_pos_info; // 그룹 좌표 정보

    static int[] selected; // 조합 정보
    static int group_size; // 그룹 크기

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        half = n / 2;

        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }// end of init

    public static void rotateCross() {
        int[] tmp = new int[half];

        // 수직 부분 저장, 1
        for (int i = 0; i < half; i++) {
            tmp[i] = map[i][half];
        }

        // 4 -> 1에 저장
        for (int i = half + 1; i < n; i++) {
            map[n - 1 - i][half] = map[half][i];
        }

        // System.out.println("-------------------");
        // printMap();
        // 3 -> 4에 저장
        for (int i = half + 1; i < n; i++) {
            map[half][i] = map[i][half];
        }
        // System.out.println("-------------------");
        // printMap();
        // 2 -> 3애 저장
        for (int i = 0; i < half; i++) {
            map[n - 1 - i][half] = map[half][i];
            // System.out.println("[" + (n - 1 - i) + ", " + half + "] " + "[" + (half) + ",
            // " + i + "] " + map[n - 1 - i][half] + " " + map[half][i]);
        }
        // System.out.println("-------------------");
        // printMap();
        // 1 -> 2 저장
        for (int i = 0; i < half; i++) {
            map[half][i] = tmp[i];
        }
        // System.out.println("-------------------");
        // printMap();
    }// end of rotateCross

    public static void rotateCCW(int x1, int y1, int x2, int y2) {
        int[][] result = new int[half][half];

        for (int j = half - 1, x = x1; j >= 0 && x <= x2; j--, x++) {
            for (int i = 0, y = y1; i < half && y <= y2; i++, y++) {
                result[i][j] = map[x][y];
            }
        }

        for (int i = 0, x = x1; i < half && x <= x2; i++, x++) {
            for (int j = 0, y = y1; j < half && y <= y2; j++, y++) {
                map[x][y] = result[i][j];
            }
        }
    }// end of rotateCCW

    public static void rotateSquare(int area) {
        if (area == 0)
            rotateCCW(0, 0, half - 1, half - 1);
        if (area == 1)
            rotateCCW(0, half + 1, half - 1, n - 1);
        if (area == 2)
            rotateCCW(half + 1, 0, n - 1, half - 1);
        if (area == 3)
            rotateCCW(half + 1, half + 1, n - 1, n - 1);
    }

    public static void rotate() {
        // 십자 영역 반시계 회전
        rotateCross();

        // 정사각형 시계 방향 회전, 십자 기준으로 사분면 정함
        for (int i = 0; i < 4; i++) {
            rotateSquare(i);
        }
    }// end of rotate

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }// end of outOfRange

    public static boolean canGo(int x, int y, int val) {
        if (outOfRange(x, y))
            return false;
        if (visited[x][y] || map[x][y] != val)
            return false;
        return true;
    }// end of canGo

    public static boolean canGo(int x, int y) {
        if (outOfRange(x, y))
            return false;
        return true;
    }// end of canGo

    public static void bfs(int sx, int sy) {
        Queue<int[]> que = new ArrayDeque<>();

        visited[sx][sy] = true;
        que.offer(new int[] { sx, sy });

        // 그룹 값 정보 추가
        group_value.add(map[sx][sy]);

        // 그룹 좌표 정보 생성
        ArrayList<int[]> pos = new ArrayList<>();
        pos.add(new int[] { sx, sy });

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!canGo(nx, ny, map[sx][sy]))
                    continue;

                visited[nx][ny] = true;
                int[] new_pos = new int[] { nx, ny };
                pos.add(new_pos);
                que.offer(new_pos);

            }
        }

        // 추가된 좌표 정보 그룹에 추가
        group_pos_info.add(pos);

    }// end of bfs

    public static int getNearCnt() {

        int cnt = 0;

        ArrayList<int[]> group1 = group_pos_info.get(selected[0]); // 그룹 1
        ArrayList<int[]> group2 = group_pos_info.get(selected[1]); // 그룹 2

        // printGroup(group1);
        // printGroup(group2);

        // 그룹 1의 모든 좌표 중 하나의 좌표의
        for (int i = 0; i < group1.size(); i++) {

            int x = group1.get(i)[0];
            int y = group1.get(i)[1];

            // 인접한 영역의 좌표가
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 범위를 벗어나는 경우 제외
                if (!canGo(nx, ny))
                    continue;

                // 그룹 2의 좌표 중 하나라도
                for (int j = 0; j < group2.size(); j++) {
                    int x2 = group2.get(j)[0];
                    int y2 = group2.get(j)[1];

                    // 해당 된다면 두 그룹은 인접한 그룹이고
                    if (nx == x2 && ny == y2) {
                        cnt++;
                    }

                } // end of j loop

            } // end of k loop

        } // end of i loop

        // 그렇지 않으면 두 그룹은 인접한 그룹이 아니다
        return cnt;
    }// end of isNear

    public static int getScore(int cnt) {
        int score = 0;

        int group1_cnt = group_pos_info.get(selected[0]).size();
        int group2_cnt = group_pos_info.get(selected[1]).size();

        int group1_val = group_value.get(selected[0]);
        int group2_val = group_value.get(selected[1]);

        score = (group1_cnt + group2_cnt) * group1_val * group2_val * cnt;

        return score;

    }// end of getScore

    public static void comb(int depth, int start) {
        if (depth == 2) {
            // 두 그룹이 인접한지 확인하기, 인접하지 않으면 다음 조합으로
            // 인접한 경우, 인접한 면의 갯수 세기
            int nearCnt = getNearCnt();

            // 인접하지 않으면 반환된 면의 갯수가 0이다.
            if (nearCnt == 0)
                return;

            int score = getScore(nearCnt);

            ans += score;

            return;
        }

        for (int i = start; i < group_size; i++) {
            selected[depth] = i;
            comb(depth + 1, i + 1);
        }
    }// end of comb

    public static void getArtistryScore() {
        // 방문 배열 생성
        visited = new boolean[n][n];

        group_value = new ArrayList<>();
        group_pos_info = new ArrayList<>();

        // 1. 그룹 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j])
                    continue;
                bfs(i, j);
            }
        }

        selected = new int[2];
        group_size = group_value.size();

        // 가능한 그룹 조합 모두 구하기
        comb(0, 0);

    }// end of getArtistryScore

    public static void sol() {
        // 초기 예술 점수 구하기
        getArtistryScore();

        for (int i = 0; i < 3; i++) {
            // 회전
            rotate();

            // System.out.println();
            // printMap();

            // 예술 점수 구하기
            getArtistryScore();
        }

        System.out.println(ans);
    }// end of sol

    public static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                sb.append(map[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void printGroup(ArrayList<int[]> group) {
        StringBuilder sb = new StringBuilder();
        for (int[] pos : group) {
            sb.append(Arrays.toString(pos)).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }
}
