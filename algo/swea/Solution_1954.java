import java.io.*;

/**
 * 1954 달팽이 숫자
 */
public class Solution_1954 {
    static final int[] dx = { 0, 1, 0, -1 };
    static final int[] dy = { 1, 0, -1, 0 };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            int n = Integer.parseInt(br.readLine());
            // 2차원 배열 생성, 크기 n * n
            int[][] map = new int[n][n];
            // 달팽이 입력
            snail(n, map);
            // 달팽이 출력
            printSnail(tc, n, map);
        } // end of TC

        System.out.println(sb.toString());

    }// end of main

    // 2차원 배열의 한 변 크기 n, 2차원 배열을 입력받아 배열에 달팽이를 입력하는 함수
    public static void snail(int n, int[][] map) {
        int[] seq = new int[2 * n - 1];
        seq[0] = n--;
        // seq 배열 입력
        for (int i = 1, j = 0; i < seq.length; i++, j++) {
            if (j > 1) {
                n--;
                j = 0;
            }
            seq[i] = n;
        } // end of seq 배열 입력

        // 달팽이 입력 시작
        int x = 0; // 입력 시작 x좌표
        int y = -1; // 입력 시작 y좌표
        int val = 1; // 입력 시작 값
        // seq 배열의 값만큼 씩 입력하면 달팽이를 모두 채움
        for (int i = 0; i < seq.length; i++) {
            // 배열값 만큼 같은 방향으로 이동
            for (int j = seq[i]; j > 0; j--) {
                x = x + dx[i % 4]; // x 방향 갱신
                y = y + dy[i % 4]; // y 방향 갱신
                map[x][y] = val++; // 이동한 방향 입력
            }
        } // end of 달팽이 입력

    }// end of snail

    // tc와, 2차원 배열의 한 변 크기 n, 배열을 입력받아 출력 버퍼에 저장하는 함수
    public static void printSnail(int tc, int n, int[][] map) {
        sb.append("#").append(tc).append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        } // end of 출력
    }// end of printSnail
}// end of class
