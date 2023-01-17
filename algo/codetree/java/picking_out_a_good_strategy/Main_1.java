package picking_out_a_good_strategy;

import java.io.*;
import java.util.*;

/**
 * 순간 이동
 * 요구사항 : '이동 거리'를 구하라
 * 위치 간 대소관계는 나오지 않았다!
 */
public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int dist = Integer.MAX_VALUE;

        // case 1 ; a -> b
        dist = Math.min(dist, Math.abs(b - a));

        // case 2; a -> x -> y -> b
        dist = Math.min(dist, Math.abs(a - x) + Math.abs(y - b));

        // case 3; a -> y -> x -> b
        dist = Math.min(dist, Math.abs(a - y) + Math.abs(x - b));

        System.out.println(dist);
    }// end of main
}
