package Past_Exam_Questions;

import java.io.*;
import java.util.*;

/**
 * 술래잡기 fail
 */

public class Main_3 {

    static int[] dx = new int[] { -1, 0, 1, 0 };
    static int[] dy = new int[] { 0, 1, 0, -1 };

    static int n; // 격자 크기
    static int m; // m명의 도망자
    static int h; // 나무의 갯수
    static int k; // 턴의 횟수

    static int ssx, ssy; // 술래의 좌표
    static int ssd = 0; // 술래 시작 방향
    static boolean flag = false; // 역방향
    static int[] ssdx = new int[] { -1, 0, 1, 0 }; // 술래 이동 x
    static int[] ssdy = new int[] { 0, 1, 0, -1 }; // 술래 이동 y

    static int padd_cnt = 0; // 달팽이 변화량
    static int padd_idx = 0; // 변화량 인덱스
    static int[] padding; // 달팽이 변화량 배열
    static int padd_len; // 달팽이 길이

    static int[][] sulae; // 술래용 맵, 빈칸 0, 술래 1
    static int[][] tree; // 나무용 맵, 빈칸 0, 나무 1

    static Runner[] runners;// 사람 관리

    static int ans = 0; // 최종 점수

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 달팽이 배열 만들기
        padd_len = ((n - 1) * 2) + 1;
        padding = new int[padd_len];
        int padd = 1;
        for (int i = 0, j = 0; i < padding.length && j <= 2; i++, j++) {
            if (j == 2) {
                j = 0;
                padd++;
            }
            padding[i] = padd;
        }
        padding[padd_len - 1] = n - 1;

        // System.out.println(Arrays.toString(padding));

        // 술래의 시작 좌표
        ssx = n / 2;
        ssy = n / 2;
        sulae = new int[n][n];
        sulae[ssx][ssy] = 1;

        // 도망자 입력
        runners = new Runner[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int d = Integer.parseInt(st.nextToken());

            Runner p = new Runner(x, y, d);
            runners[i] = p;
        }

        // 나무 입력
        tree = new int[n][n];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x][y] = 1;
        }
    }

    public static int getDistance(Runner r) {
        return Math.abs(ssx - r.x) + Math.abs(ssy - r.y);
    }

    public static boolean outOfRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }// end of outOfRange

    public static void moveRunner() {
        // 거리가 3 이하인 도망자만 선택
        ArrayList<Runner> cand = new ArrayList<>();

        // 도망자들 중
        for (int i = 0; i < m; i++) {
            // 이미 잡혔거나 거리가 3 초과면 제외
            if (runners[i].isCap || getDistance(runners[i]) > 3)
                continue;

            // 조건을 만족하는 도망자의
            int cx = runners[i].x; // 현재 x
            int cy = runners[i].y; // 현재 y
            int cd = runners[i].d; // 현재 방향

            // 바라보고 있는 방향으로 한 칸 움직임
            int nx = cx + dx[cd];
            int ny = cy + dy[cd];
            int nd = cd;

            // 격자를 벗어나는 경우
            if (outOfRange(nx, ny)) {
                // 바라보는 방향 반대로
                nd = (nd + 2) % 4;
                runners[i].d = nd; // 방향 전환 기록

                // 방향 전환 후 1칸 움직임
                nx = cx + dx[nd];
                ny = cy + dy[nd];

                // 해당 칸에 술래가 없다면
                if (sulae[nx][ny] != 1) {
                    // 해당 위치로 이동
                    runners[i].x = nx;
                    runners[i].y = ny;
                }
            } else // 격자를 벗어나지 않는 경우
            // 해당 칸에 술래가 있다면 움직이지 않음
            if (sulae[nx][ny] == 1)
                continue;
            // 술래가 없다면 해당 방향으로 이동
            runners[i].x = nx;

        }
    }// end of moveRunner

    public static boolean isCenter(int x, int y) {
        return x == n / 2 && y == n / 2;
    }// end of isCenter

    public static void moveSulae() {
        // 현재 바라보는 방향으로 이동
        // ssx, ssy
        int nx = ssx + ssdx[ssd];
        int ny = ssy + ssdy[ssd];

        // 달팽이 변화량 증가
        padd_cnt++;

        // 이전 이동이 순방향이고
        if (!flag) {
            // 범위를 벗어나지 않았다면
            if (padd_idx < padd_len) {
                sulae[ssx][ssy] = 0;
                sulae[nx][ny] = 1;

                ssx = nx; // 위치 갱신
                ssy = ny; // 위치 갱신

                // 방향 전환 해야하면
                if (padd_cnt == padding[padd_idx]) {
                    ssd = (ssd + 1) % 4; // 방향 전환
                    padd_idx++; // 패딩 배열 인덱스 증가
                    padd_cnt = 0; // 패딩 변화량 카운트 초기화
                }
            } else {// 역방향으로 바뀌어야할 시점이면
                flag = true; // 역방향으로

                padd_cnt = 0;
                padd_idx = padd_len - 1;

                System.out.println(ssd);
                ssd = 2; // 아래 방향으로 전환
                System.out.println(ssd);

                nx = ssx + ssdx[ssd];
                ny = ssy + ssdy[ssd];

                sulae[ssx][ssy] = 0;
                sulae[nx][ny] = 1;

                ssx = ny;
                ssy = ny;

            }
        } else { // 역방향이면
            // 중심이 아니면
            if (padd_idx > 0) {
                sulae[ssx][ssy] = 0;
                sulae[nx][ny] = 1;

                ssx = nx; // 위치 갱신
                ssy = ny; // 위치 갱신

                // 방향 전환 해야하면
                if (padd_cnt == padding[padd_idx]) {
                    ssd = (ssd + 3) % 4; // 방향 전환
                    padd_idx--; // 패딩 배열 인덱스 감소
                    padd_cnt = 0; // 패딩 변화량 카운트 초기화
                }
            } else {// 중심이라 다시 순방향으로 바뀌어야할 시점이면
                flag = true;

                padd_cnt = 0;
                padd_idx = 0;

                ssd = 0; // 방향 180도 전환

                nx = ssx + ssdx[ssd];
                ny = ssy + ssdy[ssd];

                sulae[ssx][ssy] = 0;
                sulae[nx][ny] = 1;

                ssx = ny;
                ssy = ny;

            }
        }

    }// end of moveSulae

    public static void captureRunner() {

        // 한 턴에 잡은 도망자 수
        int cnt = 0;

        // 해당 방향으로 3칸
        for (int i = 0; i < 3; i++) {
            int nx = ssx + ssdx[ssd] * i;
            int ny = ssy + ssdy[ssd] * i;

            // 격자 밖이면 제외
            if (outOfRange(nx, ny))
                continue;

            // 나무가 있으면 제외
            if (tree[nx][ny] == 1)
                continue;

            // 도망자들 중
            for (int j = 0; j < m; j++) {
                // 이미 붙잡혔거나 해당 위치에 있는 도망자가 아니면 제외
                if (runners[j].isCap || runners[j].x != nx || runners[j].y != ny)
                    continue;
                runners[j].isCap = true;
                cnt++;
            }
        }

        ans += k * cnt;

    }// end of captureRunner

    public static void simulation() {
        // k턴 진행
        printMap();
        while (k-- > 0) {
            // 도망자 움직인다
            // moveRunner();

            // 술래 움직인다.
            moveSulae();
            printMap();

            // 술래가 도망자 잡는다
            // captureRunner();
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main

    public static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(sulae[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }// end of pringMap

}// end of class

class Runner {
    int x;
    int y;
    int d;
    boolean isCap;

    public Runner(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.isCap = false;
    }
}
