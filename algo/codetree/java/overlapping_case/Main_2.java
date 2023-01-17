package overlapping_case;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        if (check(x1, y1, x2, y2, a1, b1, a2, b2))
            System.out.println("overlapping");
        else
            System.out.println("nonoverlapping");

    }// end of main

    // 두 사각형이 겹치는지 판단 후 그 결과를 반환
    // 겹치면 true, 겹치지 않으면 false
    public static boolean check(int x1, int y1, int x2, int y2, int a1, int b1, int a2, int b2) {
        if (x2 < a1 || a2 < x1 || y2 < b1 || b2 < y1)
            return false;
        return true;
    }
}// end of class
