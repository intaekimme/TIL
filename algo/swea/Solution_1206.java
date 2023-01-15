import java.io.*;
import java.util.*;

/**
 * 1206. [S/W 문제해결 기본] 1일차 - View
 */
public class Solution_1206 {

    static final int MAX_LEN = 1004; // 2 + 1000 + 2, 맨 왼쪽 두 칸과 맨 오른쪽 두 칸에는 건물이 지어지지 않는다.
    static final int MAX_HEIGHT = 255; // 빌딩 높이 최대 255

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        // 총 10개의 테스트 케이스가 주어짐
        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" "); // 출력 형식 출력

            int n = Integer.parseInt(br.readLine()); // 아파트 갯수

            int[][] map = new int[MAX_HEIGHT + 1][MAX_LEN]; // 아파트, 건물이 있으면 1, 없으면 0, 초깃값 0
            int[] height = new int[MAX_LEN]; // 아파트 높이 기록 배열
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 아파트 입력
            // n개의 건물만큼 반복
            // 예제 그림을 180도 뒤집은 모습으로 기록중
            for (int i = 2; i < n + 2; i++) {
                int h = Integer.parseInt(st.nextToken()); // 아파트 높이
                height[i] = h; // 높이 기록
                // 아파트 높이 기록
                for (int j = 0; j < h; j++) {
                    map[j][i] = 1; // 기록 주의
                }
            }

            int ans = 0; // 조망권이 확보된 세대 수
            // 각 아파트 층마다 조망권에 해당하는지 확인
            for (int i = 2; i < n + 2; i++) {
                for (int j = 0; j < height[i]; j++) {
                    // 현재 위치에 세대가 있고 조망권이 확보되었으면 조망권 확보된 세대 수 증가
                    if (map[j][i] == 1 && check(j, i, map)) // 위와 마찬가지로 인덱스 주의
                        ans++;
                }
            }

            sb.append(ans).append("\n"); // 정답 기록

        } // end of tc

        System.out.println(sb.toString()); // 정답 출력

    }// end of sol

    // 조망권 확보 확인 함수
    // 조망권이 확보되려면 현재 층에서 좌우로 최소 2이내에 아파트가 존재하지 않아야 한다.
    public static boolean check(int r, int c, int[][] map) {
        // c에서 -2, -1, 1, 2 칸을 확인
        for (int d = -2; d <= 2; d++) {
            // 자기 자신을 제외하고 아파트가 존재하면
            if (d != 0 && map[r][c + d] != 0)
                return false; // 조망권 확보 실패
        }
        return true; // 모두 확인 후 조망권 확보 확인
    }

}// end of class
