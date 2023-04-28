package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 마법사 상어와 파이어볼, 20056, g4
 * 
 * 1번 행, N번 행 연결
 * 1번 열, N번 열 연결
 * 
 * 
 * 가능한 파이어볼의 갯수 : max 2500
 * 가능한 명령 갯수 : 1000
 * 
 * 메모리 (2500 * 2500) / (1024 * 1024) = 5MB
 */

public class Main_20056 {

    static final int MAX_N = 50;
    static final int MAX_M = MAX_N * MAX_N;

    static int N, M, K;

    static int[] dx = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
    static ArrayList<int[]>[][] map;

    public static ArrayList<int[]>[][] initMap() {
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        return map;
    }// end of init();

    public static void copyMap(ArrayList<int[]>[][] copy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < copy[i][j].size(); k++) {
                    int[] fire = copy[i][j].get(k);

                    map[i][j].add(new int[] { fire[0], fire[1], fire[2] });
                }
            }
        }
    }// end of copyMap

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = initMap();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[r][c].add(new int[] { m, s, d });
        }
    }// end of init

    public static void move() {
        ArrayList<int[]>[][] copy = initMap();

        // 각 격자 칸에 대해서 수행
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                // 격자에 불의 갯수에
                for (int k = 0; k < map[x][y].size(); k++) {
                    int[] fire = map[x][y].get(k);

                    int d = fire[2];
                    int s = fire[1];

                    int nx = ((x + dx[d] * s) + N) % N;
                    int ny = ((y + dy[d] * s) + N) % N;

                    copy[nx][ny].add(fire);
                }
            }
        }

        map = initMap();

        copyMap(copy);
    }// end of move

    public static void combAndDivide() {
        ArrayList<int[]>[][] copy = initMap();

        // 각 격자 칸에 대해 수행
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int m_sum = 0; // 하나로 합쳐진 파이어볼 질량
                int s_sum = 0; // 하나로 합쳐진 파이어볼 속력

                int isOdd = 1;

                for (int k = 0; k < map[x][y].size(); k++) {
                    int[] fire = map[x][y].get(k);

                    m_sum += fire[0];
                    s_sum += fire[1];

                    isOdd *= fire[2];
                }

                m_sum /= 5; // 나누어진 질량 = (내림) 합쳐진 파이어볼 질량의 합 / 5

                // 질량이 0인 파이어볼은 소멸되어 없어진다.
                if (m_sum == 0)
                    continue;

                s_sum /= map[x][y].size(); // 나누어진 속력 = (내림) 합쳐진 파이어볼 속력의 합 / 합쳐진 파이어볼 개수

                // 방향이 모두 홀수이거나 짝수이면 방향, 0, 2, 4, 6
                int start = 0;

                // 그렇지 않으면 1, 3, 5, 7
                if (isOdd % 2 == 1)
                    start = 1;

                // x, y 중심으로 파이어볼 정해진 방향으로 보냄
                for (int i = start; i < 8; i += 2) {
                    int nx = (x + dx[i] + N) % N;
                    int ny = (y + dy[i] + N) % N;

                    copy[nx][ny].add(new int[] { m_sum, s_sum, i });
                }
            }
        }
    }// end of combAndDivide

    public static void simulation() {
        for (int i = 0; i < K; i++) {
            // 이동
            move();

            // 합쳐지고 쪼개짐
            combAndDivide();
        }
    }// end of simulation

    public static void main(String[] args) throws IOException {
        init();
        simulation();
    }// end of main

}// end of class
