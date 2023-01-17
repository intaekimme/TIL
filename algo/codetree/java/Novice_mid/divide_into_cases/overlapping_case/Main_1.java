package overlapping_case;

import java.io.*;
import java.util.*;

public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());

        if (check(x1, x2, x3, x4))
            System.out.println("intersecting");
        else
            System.out.println("nonintersecting");

    }// end of main

    // 두 선분이 겹치는지 확인하고 그 결과를 반환하는 함수
    // 겹치면 true, 안 겹치면 false
    public static boolean check(int x1, int x2, int x3, int x4) {
        // 선분 1에 선분 2가 포함된다?
        if ((x1 <= x3 && x3 <= x2) || (x1 <= x4 && x4 <= x2))
            return true;
        // 선분 2에 선분 1이 포함된다?
        if ((x3 <= x1 && x1 <= x4) || (x3 <= x2 && x2 <= x4))
            return true;
        return false;
    }// end of check

    // 두 선분이 겹치는지 확인하고 그 결과를 반환하는 함수2
    // 겹치면 true, 안 겹치면 false
    public static boolean check2(int x1, int x2, int x3, int x4) {
        // 겹치지 않는 경우 먼저 처리
        if (x2 < x3 || x4 < x1)
            return false;
        // 겹치는 경우
        return true;
    }

}// end of class
