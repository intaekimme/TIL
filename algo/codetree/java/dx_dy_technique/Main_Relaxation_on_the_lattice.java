package dx_dy_technique;

import java.io.*;
import java.util.*;

/**
 * 입력이 들어올 때마다 확인하기, 다 입력받고 확인하면 정답이 다르다.₩
 */

public class Main_Relaxation_on_the_lattice {

    static final int[] dr = { 0, -1, 0, 1 };
    static final int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 초기값 0 : 색칠이 되지 않은 상태, 1 : 색칠된 상태.
        int[][] map = new int[n][n];

        StringBuilder sb = new StringBuilder();
        // m개의 입력 시작
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            // (r, c) 칸에 색칠을 함.
            map[r][c] = 1;

            int cnt = 0; // 색이 칠해진 칸 카운트
            for (int j = 0; j < 4; j++) {
                int nr = r + dr[j];
                int nc = c + dc[j];

                if (outOfRange(nr, nc, n))
                    continue;

                if (map[nr][nc] == 1)
                    cnt++;
            }

            if (cnt == 3)
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        } // end of m loop

        // 정답 출력
        System.out.println(sb.toString());

    }// end of main

    public static boolean outOfRange(int x, int y, int n) {
        return (x < 0 || x >= n || y < 0 || y >= n);
    }// end of outOfRange

}// end of class
