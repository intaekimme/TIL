import java.io.*;

/**
 * 2005. 파스칼의 삼각형
 */
public class Solution_2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine()); // TC 케이스 수
        StringBuilder sb = new StringBuilder(); // 출력 버퍼

        // TC 수 만큼 반복
        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append("\n"); // 테케 출력 입력

            int n = Integer.parseInt(br.readLine()); // 파스칼의 삼각형 크기 n

            int[][] dp = new int[n + 1][n + 1]; // 파스칼의 삼각형 담을 배열, 행과열 1부터 시작하기 위해 n+1 by n+1로 선언, 초기 0
            dp[1][1] = 1;// 파스칼의 삼각형 규칙 1. 첫 번째 줄은 항상 숫자 1이다.

            // 파스칼의 삼각형 채우기, 범위; 행; [1, n], 열; [1, n]
            for (int i = 2; i < dp.length; i++) { // 1열 채웠으므로 2열부터 시작
                for (int j = 1; j < dp[0].length; j++) {
                    // 파스칼의 삼각형 규칙 2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성된다.
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            // 파스칼의 삼각형 출력버퍼 입력 함수
            printPascal(dp, sb);
        } // end of tc

        System.out.println(sb.toString()); // 정답 출력
    }// end of main

    // 파스칼의 삼각형 출력버퍼 입력 함수
    // 0이 아닌 값만 입력
    public static void printPascal(int[][] dp, StringBuilder sb) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i][j] != 0)
                    sb.append(dp[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }// end of printPascal

}// end of class
