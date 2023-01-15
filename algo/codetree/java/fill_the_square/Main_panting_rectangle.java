package fill_the_square;

import java.io.*;
import java.util.*;
// import java.lang.Math;

public class Main_panting_rectangle {

    static final int MAX_LEN = 2000;
    static final int OFFSET = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int[][] rect = new int[3][4];

        // 사각형 입력
        // 0행 : A, 1행 : B, 2행 : M
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                rect[i][j] = Integer.parseInt(st.nextToken()) + OFFSET;
            }
        }

        int A = (rect[0][2] - rect[0][0]) * (rect[0][3] - rect[0][1]);
        int B = (rect[1][2] - rect[1][0]) * (rect[1][3] - rect[1][1]);

        // int min_x = Integer.MAX_VALUE;
        // int max_x = Integer.MIN_VALUE;
        // int min_y = Integer.MAX_VALUE;
        // int max_y = Integer.MIN_VALUE;

        // for (int i = 0; i < 2; i++) {
        // for (int j = 0; j < 4; j++) {
        // if (j % 2 == 0) {
        // min_x = Math.min(min_x, rect[i][j]);
        // max_x = Math.max(max_x, rect[i][j]);
        // } else {
        // min_y = Math.min(min_y, rect[i][j]);
        // max_y = Math.max(max_y, rect[i][j]);
        // }
        // }
        // }

        int[][] map = new int[MAX_LEN][MAX_LEN];

        for (int i = 0; i < 2; i++) {
            for (int x = rect[i][0]; x < rect[i][2]; x++) {
                for (int y = rect[i][1]; y < rect[i][3]; y++) {
                    map[x][y] = 1;
                }
            }
        }

        int overRapping = 0;
        for (int x = rect[2][0]; x < rect[2][2]; x++) {
            for (int y = rect[2][1]; y < rect[2][3]; y++) {
                if (map[x][y] == 1)
                    overRapping++;
            }
        }

        int ans = A + B - overRapping;
        System.out.println(ans);

    }
}
