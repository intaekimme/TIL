package Past_Exam_Questions;

import java.io.*;
import java.util.*;

/**
 * 나무 박멸
 * 삼성 SW 역량테스트 2022 상반기 오후 2번 문제
 * g4 fail
 */

public class Main {

    static int n, m, k, c;

    static int ans = 0;

    static ArrayList<int[]> pos;

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, -1, 0 };

    static int[] cx = new int[] { -1, 1, 1, -1 };
    static int[] cy = new int[] { 1, 1, -1, -1 };

    static Node[][] map;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new Node[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = new Node(Integer.parseInt(st.nextToken()));
            }
        }

    }// end of init

    // 범위 탐색
    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }// end of outOfRange

    // x, y 지점이 나무인지 판별
    public static boolean canTree(int x, int y) {
        if (outOfRange(x, y)) // 범위 밖이면 제외
            return false;
        if (map[x][y].toxic || map[x][y].tree <= 0) // 제초제가 존재하거나 나무가 없거나 빈 칸이면 제외
            return false;
        return true;
    }// end of canTree

    // x, y 중심으로 나무가 있는 칸의 수를 반환
    public static int findTree(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!canTree(nx, ny))
                continue;
            cnt++;
        }

        return cnt;
    }// end of findTree

    // 맵 복사
    public static Node[][] copyMap(Node[][] origin, Node[][] copy) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Node node = origin[i][j];
                copy[i][j] = new Node(node.tree, node.toxic, node.t_time);
            }
        }
        return copy;
    }// end of copyMap

    // 나무 자라기
    public static void grow() {
        Node[][] copy = new Node[n][n];

        copy = copyMap(map, copy);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].toxic || map[i][j].tree <= 0) // 제초제가 존재하거나 나무가 없거나 벽이면
                    continue;

                int near_tree = findTree(i, j); // i, j에 인접한 칸 중 나무가 존재하는 칸의 수

                copy[i][j].tree += near_tree; // 존재하는 칸의 수 만큼 나무 자라기
            }
        }

        // 원본에 다시 복사
        map = copyMap(copy, map);

    }// end of grow

    // 번식이 가능한 곳
    public static boolean canBreed(int x, int y) {
        if (outOfRange(x, y)) // 격자 범위 밖
            return false;
        if (map[x][y].tree > 0 || map[x][y].toxic) // 다른 나무가 있거나, 제초제가 있으면 제외
            return false;
        return true;
    }// end of canBreed

    // x, y 기준으로 번식이 가능한 지역의 수 반환
    public static int findArea(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!canBreed(nx, ny))
                continue;
            cnt++;
        }

        return cnt;
    }// end of findArea

    // 파종
    public static int[][] sowing(int x, int y, int tot, int[][] breed) {
        Node node = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!canBreed(nx, ny))
                continue;
            breed[nx][ny] += node.tree / tot;
        }

        return breed;
    }// end of sowing

    // 번식
    public static void breed() {
        Node[][] copy = new Node[n][n];

        copy = copyMap(map, copy);

        int[][] breed = new int[n][n];

        // copy에 자랄 나무 기록
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Node node = map[i][j];

                // 제초제가 존재하거나 나무가 없거나(0) 벽이면(-1) 제외
                if (node.toxic || node.tree <= 0)
                    continue;

                // 번식이 가능한 칸의 수
                int tot_can_breed_area = findArea(i, j);

                // 파종 기록
                breed = sowing(i, j, tot_can_breed_area, breed);
            }
        }

        // 새 노드 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (breed[i][j] != 0)
                    copy[i][j] = new Node(breed[i][j]);
            }
        }

        // 원본에 다시 복사
        map = copyMap(copy, map);

    }// end of breed

    public static int getDeletedTree(int x, int y) {
        // 박멸되는 나무 수
        int cnt = map[x][y].tree;

        // 해당 방향으로 계속 찾을지
        boolean[] isKeepGoing = new boolean[4];
        Arrays.fill(isKeepGoing, true);

        // 대각선 k 방향 확인
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 4; j++) {
                if (!isKeepGoing[j]) // 해당 방향으로 계속 찾을지
                    continue;

                int nx = x + cx[j] * k;
                int ny = y + cy[j] * k;

                if (!canTree(nx, ny)) { // 나무가 없으면 제외
                    isKeepGoing[j] = false;
                    continue;
                }

                cnt += map[nx][ny].tree;
            }
        }
        return cnt;
    }// end of getDeletedTree

    // 제초제가 뿌려질 장소를 찾음
    public static int[] findToxicPos() {
        pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].toxic || map[i][j].tree <= 0) // 제초제가 뿌려져 있거나, 나무가 없거나 벽인 칸에는 뿌리지 않음
                    continue;

                int tot_deleted_tree = getDeletedTree(i, j);
                pos.add(new int[] { tot_deleted_tree, i, j });
            }
        }

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] == o2[1]) // 행이 같으면
                        return o1[2] - o2[2]; // 열 오름차순 정렬
                    return o1[1] - o2[1]; // 행 오름차순 정렬
                }
                return o2[0] - o1[0]; // 박멸되는 나무 수 내림차순 정렬
            }
        };

        // 가장 많이 나무가 박멸되는 장소 찾기
        Collections.sort(pos, comparator);

        return pos.get(0);
    }// end of findToxicPos

    public static void delete(int[] pos) {
        int x = pos[1];
        int y = pos[2];

        // 제초제를 뿌린 중심의 나무 박멸
        map[x][y].tree = 0;
        map[x][y].toxic = true;
        map[x][y].t_time = c;

        // 제초제를 뿌리기 전 제초제 년 수 감소
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 제초제가 뿌려져 있으면
                if (map[x][y].toxic) {
                    if (map[x][y].t_time > 0) // 제초제 시간이 남아 있으면
                        map[x][y].t_time--; // 1년씩 감소
                    else { // 제초제 시간을 다 썼으면
                        map[x][y].toxic = false;
                        map[x][y].t_time = 0;
                    }
                }
            }
        }

        // 해당 방향으로 계속 뿌릴지
        boolean[] isKeepGoing = new boolean[4];
        Arrays.fill(isKeepGoing, true);

        // 중심으로 대각 k방향까지 제초제 뿌리기
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < 4; j++) {
                if (!isKeepGoing[j]) // 해당 방향으로 계속 찾을지
                    continue;

                int nx = x + cx[j] * k;
                int ny = y + cy[j] * k;

                // 범위 밖이면 그만
                if (outOfRange(nx, ny))
                    continue;

                // 범위 내에서는 제초제를 일단 뿌림, 이미 뿌린 곳은 갱신됨
                map[nx][ny].toxic = true;
                map[nx][ny].t_time = c;

                // 벽 또는 나무가 없는 곳이라면 그 방향으로는 번지지 않음
                if (map[nx][ny].tree <= 0) {
                    isKeepGoing[j] = false;
                    continue;
                }

                // 박멸한 나무 수 기록
                ans += map[nx][ny].tree;

                // 나무 제거
                map[nx][ny].tree = 0;
            }
        }
    }// end of delete

    public static void main(String[] args) throws IOException {
        init();
        while (m-- > 0) {
            grow();
            breed();
            int[] deleted_pos = findToxicPos();
            delete(deleted_pos);
        }

        System.out.println(ans);
    }// end of main

}// end of class

class Node {
    int tree; // 나무

    boolean toxic; // 제초제 여부
    int t_time; // 제초제 남은 년 수

    public Node(int tree) {
        this.tree = tree;
        this.toxic = false;
        this.t_time = 0;
    }

    public Node(int tree, boolean toxic, int t_time) {
        this.tree = tree;
        this.toxic = toxic;
        this.t_time = t_time;
    }
}
