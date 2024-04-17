package Intermediate_low.simulation.shift;

import java.io.*;
import java.util.*;

/**
 * 돌아가는 방향 시작 지점의 직전 지점부터 반대 방향으로 시작한다. 그래야 유실 없이 가능
 * 예시
 * 
 * 1. 오른쪽, 아래, 왼쪽, 위 -> 위, 왼쪽, 아래, 오른쪽
 * 2. 아래, 왼쪽, 위, 오른쪽 -> 오른쪽, 위, 왼쪽, 아래
 * 
 */

public class Main_1_1 {

    static int n, T;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[2][n];

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            map[0][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = n - 1; j >= 0; j--) {
            map[1][j] = Integer.parseInt(st.nextToken());
        }

        for (int t = 0; t < T; t++) {
            int tmp = map[0][0];
            // 위
            map[0][0] = map[1][0];
            // 왼쪽
            for (int i = 0; i < n - 1; i++) {
                map[1][i] = map[1][i + 1];
            }

            // 아래
            map[1][n - 1] = map[0][n - 1];

            // 오른쪽
            for (int i = n - 1; i > 0; i--) {
                map[0][i] = map[0][i - 1];
            }

            map[0][1] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append(map[0][j]).append(" ");
        }
        sb.append("\n");
        for (int j = n - 1; j >= 0; j--) {
            sb.append(map[1][j]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
