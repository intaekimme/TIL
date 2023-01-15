package boj;

import java.io.*;
import java.util.*;

/**
 * a, 겹치는 부분이 영역인 경우
 * 
 * b, 겹치는 부분이 선분인 경우
 * 
 * c, 겹치는 부분이 점인 경우
 * 
 * d, 공통부분이 없는 경우
 */
public class Main_2527_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            int[] x_coord = new int[4];
            int[] y_coord = new int[4];

            for (int j = 0; j < 8; j++) {
                if (j % 2 == 0)
                    x_coord[j / 2] = Integer.parseInt(st.nextToken());
                else
                    y_coord[(j + 1) / 2 - 1] = Integer.parseInt(st.nextToken());
            }
            Rect A = new Rect(x_coord[0], y_coord[0], x_coord[1], y_coord[1]);
            Rect B = new Rect(x_coord[2], y_coord[2], x_coord[3], y_coord[3]);

            sb.append(solve(A, B, x_coord, y_coord)).append("\n");

        }
        System.out.println(sb.toString());

    }// end of main

    public static String solve(Rect A, Rect B, int[] x_coord, int[] y_coord) {
        // 사각형 A와 B의 x, y원소 모두 정렬
        Arrays.sort(x_coord);
        Arrays.sort(y_coord);

        // 1. 정렬이 유지되지 않는다.
        // = 다음 원소가 같은 사각형의 x 좌표가 아니다. 다른 사각형의 x 좌표이다.
        if ((x_coord[0] == A.x && x_coord[1] != A.p) || (x_coord[0] == B.x && x_coord[1] != B.p))
            return "a";

        // 2. A와 B의 순서가 유지된다.
        // 선분, 점, 겹치지 않는다.
        // 선분 : x와 y 중 같은게 1개만 있다, cnt = 1
        // 점 : x와 y 모두 같은게 1개씩 있다, cnt = 2
        // 겹치지 않는다. : 아무것도 없다, cnt = 0
        int cnt = 0;
        for (int i = 1; i < 4; i++) {
            if ((x_coord[i] == x_coord[i - 1]) || (y_coord[i] == y_coord[i - 1]))
                cnt++;
        }
        if (cnt == 0)
            return "d";
        if (cnt == 1)
            return "b";
        return "c";
    }

}// end of class

class Rect {
    int x;
    int y;
    int p;
    int q;

    public Rect(int x, int y, int p, int q) {
        this.x = x;
        this.y = y;
        this.p = p;
        this.q = q;
    }
}
