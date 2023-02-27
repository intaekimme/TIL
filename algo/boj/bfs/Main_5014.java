package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 스타트링크, 5014
 * 두가지 연산을 다 이용, 대신 수학적으로 판별하려 해봄
 * 하지만 잘 되지 않음
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

        if ((dir > 0 && (Math.abs(s - g) % u) < d) || (dir < 0 && (Math.abs(s - g) % d) < u)) {
            System.out.println("use the stairs");
            return;
        }

        if ((dir < 0 && ((Math.abs(s - g) % d) % u != 0)) ||
                (dir > 0 && ((Math.abs(s - g) % u) % d != 0))) {
            System.out.println("use the stairs");
            return;
        }

        if (dir < 0)
            System.out.println((Math.abs(s - g) / d) + ((Math.abs(s - g) / d) / u));
        else
            System.out.println((Math.abs(s - g) / u) + ((Math.abs(s - g) / u) / d));

    }// end of main
}
