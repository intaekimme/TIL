import java.io.*;
import java.util.StringTokenizer;

/**
 * 2001. 파리퇴치
 */
public class Solution_2001 {

    static int n, m; // 입력 n, m
    static int[][] map; // 파리 배열

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine()); // TC 수
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 배열 크기 n
            m = Integer.parseInt(st.nextToken()); // 파리채 크기 m

            map = new int[n][n];
            // 파리 입력
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 죽은 최대 파리 수
            int ans = 0;
            // 파리 배열을 한 칸씩 순회하며 파리채로 죽은 파리 수를 구하고 최댓값 갱신
            // 범위 : (0,0) ~ (n-m, n-m)
            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {
                    // 파리채로 죽은 파리 수
                    int val = getFlyCount(i, j);
                    // 기존에 죽은 파리 수보다 새로 구한 값이 크면 갱신
                    if (ans < val)
                        ans = val;
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");

        } // end of tc

        System.out.println(sb.toString());

    }// end of main

    // 죽은 파리수 반환함수
    public static int getFlyCount(int r, int c) {
        int fly = 0;
        // 파리채의 크기만큼 순회하며 파리 수 누적
        for (int i = r; i < r + m; i++) {
            for (int j = c; j < c + m; j++) {
                fly += map[i][j];
            }
        }
        // 죽은 파리 수 반환
        return fly;
    }// end of getFlyCount

}// end of class
