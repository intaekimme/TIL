package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 20055 컨베이어 벨트 위의 로봇, g5
 * 1시간 5분
 * 17720kb, 372ms
 * 
 * simulation
 */

public class Main_20055 {

    static int N, K;
    static int[] up;
    static int[] down;

    static boolean[] robot;

    static int ans = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        up = new int[N];
        down = new int[N];

        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            up[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            down[i] = Integer.parseInt(st.nextToken());
        }

    }// end of class

    public static int getDurability() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (up[i] == 0)
                cnt++;
            if (down[i] == 0)
                cnt++;
        }
        return cnt;
    }// end of class

    public static void rotate() {
        // 위 이동
        int up_end = up[N - 1]; // 위 마지막(N인 지점)

        for (int i = N - 1; i >= 1; i--) {
            up[i] = up[i - 1]; // 내구도 이동
            robot[i] = robot[i - 1]; // 로봇 이동
        }
        // 마지막 지점은 true, false에 상관 없이 무조건 false 왜냐하면 로봇을 무조건 내리므로
        robot[N - 1] = false;
        // 시작 지점도 로봇이 올라가고 바로 다음에 이동하므로 false
        robot[0] = false;

        // 아래 이동
        int down_start = down[0];
        for (int i = 0; i < N - 1; i++) {
            down[i] = down[i + 1];
        }

        // 양 끝
        down[N - 1] = up_end;
        up[0] = down_start;
    }// end of rotate

    public static void moveRobot() {
        // 가장 먼저 벨트에 올라간 로봇은 뒤에 인덱스에 있을 것이다.
        for (int i = N - 1; i >= 0; i--) {
            // i번째에 로봇이 있고, 범위 내에서 한 칸 앞으로 갈 수 있다면(앞에 로봇이 없고, 내구도가 1 이상)
            if (robot[i] && (i + 1 < N && !robot[i + 1] && up[i + 1] >= 1)) {
                robot[i] = false; // i 칸에서 로봇이 떠남
                robot[i + 1] = true; // i + 1 칸으로 로봇이 움직임
                up[i + 1] = up[i + 1] > 0 ? up[i + 1] - 1 : 0; // i + 1칸의 내구도가 감소
            }
        }

        // 로봇이 떠나는 자리에 위치한 로봇을 제거한다
        robot[N - 1] = false;
    }// end of moveRobot

    public static void putRobot() {
        if (up[0] != 0) {
            up[0] = up[0] > 0 ? up[0] - 1 : 0;
            robot[0] = true;
        }
    }// end of putRobot

    public static void simulation() {
        while (true) {
            // 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
            if (getDurability() >= K)
                break;

            // 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            rotate();

            // 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
            // 만약 이동할 수 없다면 가만히 있는다.
            moveRobot();

            // 올리는 위치에 있는 칸의 내구도가 0이 아니라면 올리는 위치에 로봇을 올린다.
            putRobot();

            ans++;
        }

        System.out.println(ans);
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main
}// end of class
