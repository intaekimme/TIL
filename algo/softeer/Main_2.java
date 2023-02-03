package softeer;

import java.io.*;
import java.util.*;

/**
 * 21년 재직자 대회 예선
 * 좌석 관리
 */

public class Main_2 {

    static final int MAX_N = 20;
    static final int MAX_Q = (int) Math.pow(10, 4);

    static int n, m, q;

    static int[][] map = new int[MAX_N + 2][MAX_N + 2]; // 앉아 있는 사원 id, 없으면 0
    static int[][] id = new int[MAX_Q + 1][3]; // 0 : before, 1 : ing, 2 : after

    static String[] cmd_query;
    static int[] cmd_emp_num;

    static StringBuilder sb = new StringBuilder(); // 출력 버퍼

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        cmd_query = new String[q];
        cmd_emp_num = new int[q];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            cmd_query[i] = st.nextToken();
            cmd_emp_num[i] = Integer.parseInt(st.nextToken());
        }

    }// end of init

    public static int getDist(int x1, int y1, int x2, int y2) {
        return (int) Math.pow(x1 - x2, 2) + (int) Math.pow(y1 - y2, 2);
    }

    // 해당 좌석에서 가장 안전도가 높은 좌석 반환
    public static int findNearest(int x, int y) {
        int nearest = 1000;

        // x, y에 대해 모든 좌표 검사
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x == i && y == j)
                    continue;
                // 해당 좌표가 사람이 있는 좌석이면
                if (map[i][j] != 0) {
                    int dist = getDist(x, y, i, j);
                    nearest = Math.min(dist, nearest);
                }
            }
        }
        return nearest;
    }// end of findNearest

    // 전체 좌석에서 가장 안전도가 높은 좌석 반환
    public static int[] findSeat() {
        int min_dist = 1000;

        int min_x = 21;
        int min_y = 21;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= m; y++) {
                // 빈 좌석이면
                if (map[x][y] == 0 && map[x - 1][y] == 0 && map[x + 1][y] == 0 && map[x][y - 1] == 0
                        && map[x][y + 1] == 0) {
                    int nearest = findNearest(x, y); // 해당 좌석에서 가장 안전도가 높은 좌석 반환
                    if (nearest <= min_dist) { // 앞서 구한 다른 좌석보다 안전도가 높거나 같다면
                        min_dist = nearest;
                        min_x = Math.min(min_x, x); // 그 중에서 x가 가장 낮은 좌석
                        min_y = Math.min(min_y, y); // x도 같다면 y가 가장 낮은 좌석
                    }
                }
            }
        }

        if (min_dist == 1000)
            return new int[] { 1, 1 }; // 갱신이 된 적이 없다면 1,1 반환
        return new int[] { min_x, min_y };

    }// end of findSeat

    public static void sol() {
        for (int i = 0; i < q; i++) {

            if (cmd_query[i].equals("In")) {
                // 들어가기 명령
                int cur_emp_num = cmd_emp_num[i];
                if (id[cur_emp_num][0] == 1)
                    sb.append(cur_emp_num).append(" already seated.\n");
                if (id[cur_emp_num][0] == 2)
                    sb.append(cur_emp_num).append(" already ate lunch.\n");
                if (id[cur_emp_num][0] == 0) {
                    int[] pos = findSeat();
                    int x = pos[0];
                    int y = pos[1];

                    if (map[x][y] != 0) {
                        sb.append("There are no more seats. \n");
                        continue;
                    }

                    id[cur_emp_num][0] = 1;
                    map[x][y] = cur_emp_num;
                    id[cur_emp_num][1] = x;
                    id[cur_emp_num][2] = y;
                    sb.append(cur_emp_num).append(" gets the seat (").append(x).append(", ").append(y).append(").\n");
                }
            } else {
                // 떠나기 명령
                int cur_emp_num = cmd_emp_num[i];
                if (id[cur_emp_num][0] == 0)
                    sb.append(cur_emp_num).append(" didn't eat lunch. \n");
                if (id[cur_emp_num][0] == 2)
                    sb.append(cur_emp_num).append(" already left seat. \n");
                if (id[cur_emp_num][0] == 1) {
                    int x = id[cur_emp_num][1];
                    int y = id[cur_emp_num][2];

                    map[x][y] = 0;
                    id[cur_emp_num][0] = 2;
                    sb.append(cur_emp_num).append(" leaves from the seat (").append(x).append(", ")
                            .append(y).append(").\n");
                }

            }

        } // end of for

        System.out.println(sb.toString());

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
