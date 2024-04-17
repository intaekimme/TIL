package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_15_1 {

    static int N;

    static int[][] map;
    static int[][] visited;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;

        // 1행 선정
        for (int i = 0; i < N; i++) {
            // 2행 선정
            for (int j = 0; j < N; j++) {
                // 1행의 열 선정
                for (int k = 0; k < N - 2; k++) {
                    // 2행의 열 선정
                    here: for (int l = 0; l < N - 2; l++) {
                        visited = new int[N][N];

                        // 겹치는 지 확인 첫번째 상자
                        for (int m = 0; m < 3; m++) {
                            if (map[i][k + m] == 1)
                                visited[i][k + m]++;
                        }

                        // 겹치는 지 확인 두번째 상자
                        for (int n = 0; n < 3; n++) {
                            if (map[j][l + n] == 1)
                                visited[j][l + n]++;
                        }

                        for (int m = 0; m < N; m++) {
                            for (int n = 0; n < N; n++)
                                if (visited[m][n] == 2)
                                    break here;
                        }

                        int cnt = 0;
                        // 1행 3칸 확인
                        for (int m = 0; m < 3; m++) {
                            if (map[i][k + m] == 1)
                                cnt++;
                        }
                        // 2행 3칸 확인
                        for (int n = 0; n < 3; n++) {
                            if (map[j][l + n] == 1)
                                cnt++;
                        }
                        res = Math.max(res, cnt);
                    }
                }
            }
        }

        System.out.println(res);

    }// end of main
}
