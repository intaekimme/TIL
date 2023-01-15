
import java.io.*;
import java.util.*;

/**
 * 1209. [S/W 문제해결 기본] 2일차 - Sum
 */
public class Solution_1209 {

    static final int MAX_LEN = 100;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(n).append(" ");

            int[][] map = new int[MAX_LEN][MAX_LEN];

            for (int i = 0; i < MAX_LEN; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < MAX_LEN; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0; // 행, 열 ,대각선 합중 최댓값
            // 행별 합 중 최댓값
            for (int r = 0; r < MAX_LEN; r++) {
                max = Math.max(max, rowSum(r, map));
            }
            // 행, 열별 합 중 최댓값
            for (int c = 0; c < MAX_LEN; c++) {
                max = Math.max(max, colSum(c, map));
            }

            // 행, 열, 대각선별 합 중 최댓값
            max = Math.max(max, crossSum(map));

            sb.append(max).append("\n");

        } // end of TC

        System.out.println(sb.toString());
    }// end of main

    // 하나의 행의 합을 구해서 반환 -> 모든 열을 더한다.
    public static int rowSum(int r, int[][] map) {
        int sum = 0;
        for (int i = 0; i < MAX_LEN; i++)
            sum += map[r][i];
        return sum;
    }

    // 하나의 열의 합을 구해서 반환 -> 모든 행을 더한다.
    public static int colSum(int c, int[][] map) {
        int sum = 0;
        for (int i = 0; i < MAX_LEN; i++)
            sum += map[i][c];
        return sum;
    }

    // 두 대각선의 합 중 최댓값을 반환한다.
    public static int crossSum(int[][] map) {
        // 좌 -> 우 대각선
        int max = 0;
        int sum = 0;
        for (int i = 0, j = 0; i < MAX_LEN; i++, j++) {
            sum += map[i][j];
        }

        max = sum; // 좌우 대각선 먼저 기록
        sum = 0; // 합 초기화

        // 우 -> 좌 대각선
        for (int i = 0, j = MAX_LEN - 1; i < MAX_LEN; i++, j--) {
            sum += map[i][j];
        }

        // 최댓값 반환
        return Math.max(max, sum);
    }

}// end of class
