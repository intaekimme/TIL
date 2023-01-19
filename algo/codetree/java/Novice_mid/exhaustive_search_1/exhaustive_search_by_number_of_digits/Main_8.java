package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;

/**
 * 원 모양으로 되어있는 방
 * 반시계 방향으로 방의 순번이 정해져 있고, 모든 사람도 반시계 방향으로 돈다.
 * 
 */
public class Main_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] rooms = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            rooms[i] = Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) { // 시작방 선택
            int sum = 0;
            for (int j = 1; j <= n; j++) { // 거리합 구하기, 반시계 방향으로 돌기에 경우를 나눠줌, 2항 항상 양수
                sum += rooms[j] * ((n + j - i) % n);
            }
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
}
