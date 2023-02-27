package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 스타트링크, 5014
 * 단순하게 한가지 연산으로만 이동가능한지를 판별 그래서 오답
 * 두가지 연산을 다 활용해서 갈 수 있는지를 확인해야 함
 */

public class Main_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int f, s, g, u, d;
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int dir = 0;
        if (s > g)
            dir = -1;
        else
            dir = 1;

        if ((dir < 0 && d == 0) || (dir > 0 && u == 0)) {
            System.out.println("use the stairs");
            return;
        }

        if ((dir < 0 && (Math.abs(s - g) % d != 0)) || (dir > 0 && (Math.abs(s - g) % u != 0))) {
            System.out.println("use the stairs");
            return;
        }

        if (dir < 0)
            System.out.println(Math.abs(s - g) % d);
        else
            System.out.println(Math.abs(s - g) % u);

    }// end of main
}
