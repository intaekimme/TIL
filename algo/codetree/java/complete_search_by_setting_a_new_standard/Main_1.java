package complete_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

/**
 * 독서실의 거리두기 5
 */
public class Main_1 {

    static int n;
    static char[] origin, copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        origin = br.readLine().toCharArray();

        int max = Integer.MIN_VALUE;
        // 한 자리 선택, 배치
        for (int i = 0; i < n; i++) {
            // 한 명 배치할 배열
            copy = new char[n];
            System.arraycopy(origin, 0, copy, 0, n);

            // 이미 사람이 앉아 있으면 pass
            if (copy[i] == '1')
                continue;
            copy[i] = '1'; // 인원 배치

            int dist = Integer.MAX_VALUE;
            int cnt = 0;
            // 인원 배치 후 가장 가까운 두 사람 거리 계산

            // todo
            // 여기 어떻게 하는게 좋지..?

            max = max < dist ? dist : max;
        } // end of fori

        System.out.println(max);

    }// end of main

}// end of class
