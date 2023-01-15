import java.io.*;
import java.util.StringTokenizer;

/**
 * 1961. 숫자 배열 회전
 */

public class Solution_1961 {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder(); // 출력 버퍼
        // 테스트 케이스만큼 반복
        for (int tc = 1; tc <= TC; tc++) {
            int n = Integer.parseInt(br.readLine()); // n by n 배열에서의 n
            int[][] map = new int[n][n]; // 숫자 배열 입력 공간

            inputMap(n, map, br); // 입력 버퍼에서 받은 내용을 map에 입력

            int[][][] res = new int[3][n][n]; // 회전 결과를 저장할 3차원 배열, n by n 짜리 3개(90, 180, 270)
            for (int i = 0; i < 3; i++) {
                map = rotate90(map); // 90도 회전 시킨 배열을 원래 배열에 기록, 차후 다시 90도 회전(180, 270도 효과)
                res[i] = copyMap(map); // 회전 결과를 결과 배열에 깊은 복사, 얕은 복사시 원 배열이 회전하면 결과도 회전됨.
            }

            printResult(tc, res, sb); // 출력 버퍼에 결과 출력

        } // end of TC

        System.out.println(sb.toString()); // 정답 출력
    }// end of main

    // 입력 버퍼에서 받은 내용을 map에 입력하는 함수
    // BufferedReader는 thread-safe 하지 않기 때문에 예외처리
    public static void inputMap(int n, int[][] map, BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); // 한 줄 입력, 구분자 공백(" ")
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // map에 입력
            }
        }
    }// end of inputMap

    // 배열 90도 회전함수
    public static int[][] rotate90(int[][] map) {
        int n = map.length; // 배열의 한 쪽 변 길이
        int[][] tmp = copyMap(map); // map을 회전 시킨 것을 다시 map에 저장하기 때문에, 호출 당시 원본 필요.

        // (i,j) -> (j, n-i-1)로 시계방향 90도 회전
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int nx = y;
                int ny = (n - 1) - x;
                map[nx][ny] = tmp[x][y]; // 원본 map(tmp) 값이 회전한 map에 들어감.
            }
        }

        return map; // map 반환
    }// end of rotate90

    // map 복사 함수
    public static int[][] copyMap(int[][] map) {
        int n = map.length; // 배열의 한 쪽 변 길이
        int[][] copyMap = new int[n][n]; // 복사본
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, n); // map[i][0]부터 길이 n 만큼을 복사해 copyMap[i][0]부터 붙여넣기
        }
        return copyMap; // 복사본 반환
    }

    // 결과 출력 함수
    public static void printResult(int tc, int[][][] res, StringBuilder sb) {
        sb.append("#").append(tc).append("\n"); // tc 형식 입력

        for (int j = 0; j < res[0].length; j++) {
            for (int i = 0; i < res.length; i++) {
                for (int k = 0; k < res[0][0].length; k++) {
                    sb.append(res[i][j][k]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
    }

}// end of class
