package Intermediate_low.simulation.bomb_and_drop;

import java.io.*;
import java.util.*;

/**
 * 십자 모양 폭발
 */

public class Main_2 {

    static final int MAX_N = 200;

    static int n, r, c;
    static int[][] map = new int[MAX_N + 1][MAX_N + 1];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }// end of init

    public static boolean outOfRange(int x, int y) {
        return x < 1 || x > n || y < 1 || y > n;
    }// end of outOfRange

    /*
     * 폭발 함수
     * 폭발 영역의 값을 0으로 바꿈
     */
    public static void bomb() {
        int[] dr = new int[] { -1, 0, 1, 0 };
        int[] dc = new int[] { 0, 1, 0, -1 };

        int bomb_size = map[r][c];

        map[r][c] = 0;
        for (int i = 0; i < bomb_size; i++) {
            for (int j = 0; j < 4; j++) {
                int nr = r + dr[j] * i;
                int nc = c + dc[j] * i;

                if (outOfRange(nr, nc))
                    continue;
                map[nr][nc] = 0;
            }
        }
    }// end of bomb

    /*
     * 중력 작용
     * 열별로 진행한다.
     * 중력 작용 후의 모습을 담을 배열 선언
     * 아래부터 채우기 때문에 초기 인덱스 n으로 설정
     * 폭발로 인해 0이면 새로운 배열에 값을 채우지 않음
     */
    public static void gravity() {
        int[][] tmpArr = new int[MAX_N + 1][MAX_N + 1];
        for (int col = 1; col <= n; col++) {
            int tmpIndex = n;
            for (int row = n; row >= 1; row--) {
                if (map[row][col] == 0)
                    continue;
                tmpArr[tmpIndex][col] = map[row][col];
                tmpIndex--;
            }
        }

        for (int row = 1; row <= n; row++)
            System.arraycopy(tmpArr, 1, map, 1, n);
    }// end of gravity

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                sb.append(map[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }// end of print

    public static void simulate() {
        bomb();
        gravity();
        print();
    }// end of simulate

    public static void main(String[] args) throws IOException {
        init();
        simulate();
    }
}
