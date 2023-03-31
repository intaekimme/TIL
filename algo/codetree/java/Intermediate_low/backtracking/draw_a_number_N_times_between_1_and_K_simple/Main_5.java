package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_simple;

import java.io.*;
import java.util.*;

/**
 * 사다리 타기
 * 할 일
 * 
 * 1. 사다리를 구현하고 이를 시뮬레이션 해서 어떤 숫자가 배열되는지 확인하기
 * 1 - 1. 사다리 구현 시 유의 사항
 * 가로줄의 길이는 최소 2 이상
 * 가로줄과 가로줄 사이 띄어진 정도도 2 이상
 * 1 - 2. 가로줄 최소 높이와 최대 높이 기록하기 -> 최대 높이 - 최소 높이 + 1 이 가능한 가로줄 갯수 * 세로줄 수 - 1 =
 * 생길 수 있는 가로줄의 갯수 K
 * 
 * 2. 숫자가 나온다면
 * 2 - 1. 가로줄 1개부터 가로 줄 K개의 가로줄까지 뽑아보면서 시뮬레이션
 * 이 때, 주의사항
 * 두 개의 가로줄이 겹쳐서 등장할 수 없음, 이걸 감안하면서 가로줄 뽑아야함.
 */

public class Main_5 {

    static int n, m;
    static int min_h = 16;
    static int max_h = 0;

    static int[][] input;

    static int[][] ladder;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());

            min_h = Math.min(min_h, input[i][1]);
            max_h = Math.min(max_h, input[i][1]);
        }

        ladder = new int[max_h * 2][n * 2];

        //  사다리 가로줄
        for (int i = 0; i < n * 2; i += 2) {
            for (int j = 0; j < max_h * 2; j++)
                ladder[i][j] = 1;
        }

        for (int i = 0; i < m; i++) {
            int start = input[i][0] * 2;
            int end = start + 2;

            int h = input[i][1];
            for (int j = start; j <= end; j++) {
                ladder[][j] = 1;
            }
        }

    }// end of init

    public static void main(String[] args) throws IOException {
        init()
    }// end of main
}// end of class
