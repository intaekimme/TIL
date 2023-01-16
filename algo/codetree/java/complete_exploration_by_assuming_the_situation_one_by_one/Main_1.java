package complete_exploration_by_assuming_the_situation_one_by_one;

import java.io.*;
import java.util.*;

/**
 * 야바위
 */
public class Main_1 {

    static int n;
    static int[] cup;
    static int[][] query;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        query = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                query[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;
        // 조약돌 넣을 컵 선택
        for (int i = 1; i <= 3; i++) {
            cup = new int[4];
            cup[i] = 1; // i번 컵에 조약돌 넣음
            int score = 0; // i번 컵에 조약돌을 넣고 야바위를 한 최종 점수

            // n번의 명령 수행
            for (int j = 0; j < n; j++) {
                swap(query[j][0], query[j][1]); // a컵과 b컵을 교환
                if (cup[query[j][2]] == 1) // c번 컵을 열어서 조약돌이 있으면
                    score++; // 점수 획득
            }

            // 최대 점수 갱신
            max = max < score ? score : max;
        }

        System.out.println(max);

    }// end of main

    // 컵 교환
    public static void swap(int i, int j) {
        int tmp = cup[i];
        cup[i] = cup[j];
        cup[j] = tmp;
    }// end of swap

}// end of class