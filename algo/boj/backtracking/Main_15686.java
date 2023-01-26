package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * 치킨 배달, 15686
 * 격자 n * n
 * 구성 : 빈칸, 치킨집, 집
 * r, c는 1부터 시작
 * 
 * 치킨 거리 : 집과 가장 가까운 치킨집 사이 거리 (맨하튼 거리)
 * 도시의 치킨 거리 : 모든 집의 치킨 거리의 합
 * 
 * 일부 치킨 집을 폐업 -> M개의 치킨집이 최대 수익이기 때문
 * 
 * m개보다 많은 치킨집에서 m개를 적절히 선택해 도시의 치킨거리가 가장 작게하기
 * 
 * 출력 : 도시의 치킨거리 최소
 * 
 * 풀이
 * m개보다 많은 치킨집에서 m개를 고르는 조합 생각하기
 * 
 * 각 집별로 m개의 치킨집에서 치킨 거리 구하기
 * 도시의 치킨거리 구하기
 * 최솟값 갱신하기
 */

public class Main_15686 {

    static final int MAX_N = 50;
    static final int MAX_M = 13;

    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int chicken_idx = 0;
    static int house_idx = 0;

    static int[][] houses = new int[2 * MAX_N][];
    static int[][] chickens = new int[MAX_M][];
    static int[] selected = new int[MAX_M];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int info = Integer.parseInt(st.nextToken());
                if (info == 1)
                    houses[house_idx++] = new int[] { i, j };
                if (info == 2)
                    chickens[chicken_idx++] = new int[] { i, j };
            }
        }

    }// end of init

    public static int getManhattanDistance(int h_num, int c_num) {
        int house_x = houses[h_num][0];
        int house_y = houses[h_num][1];

        int chicken_x = chickens[c_num][0];
        int chicken_y = chickens[c_num][1];

        return Math.abs(house_x - chicken_x) + Math.abs(house_y - chicken_y);
    }// end of getManhattanDistance

    public static int getChickenDistanceOfCity() {
        int chicken_distance_of_city = 0;
        for (int i = 0; i < house_idx; i++) {
            int chicken_distance = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++)
                chicken_distance = Math.min(chicken_distance, getManhattanDistance(i, selected[j]));
            chicken_distance_of_city += chicken_distance;
        }
        return chicken_distance_of_city;
    }// end of getChickenDistanceOfCity

    public static void func(int selected_chicken, int start) {
        if (selected_chicken == m) {
            ans = Math.min(ans, getChickenDistanceOfCity());
            return;
        }

        for (int cand = start; cand < chicken_idx; cand++) {
            selected[selected_chicken] = cand;
            func(selected_chicken + 1, cand + 1);
        }
    }//

    public static void sol() {
        func(0, 0);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}// end of class
