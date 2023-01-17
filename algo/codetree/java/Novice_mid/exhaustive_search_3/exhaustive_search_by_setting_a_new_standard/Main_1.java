package complete_search_by_setting_a_new_standard;

import java.io.*;

/**
 * 독서실의 거리두기 5
 */
public class Main_1 {

    static int n;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();

        int max = Integer.MIN_VALUE;
        // 한 자리 선택, 배치
        for (int i = 0; i < n; i++) {
            // 한 명 배치할 배열

            // 이미 사람이 앉아 있으면 pass
            if (arr[i] == '1')
                continue;
            arr[i] = '1'; // 인원 배치

            int dist = getMindist(); // 가장 가까운 두 사람 거리
            max = max < dist ? dist : max;

            arr[i] = '0'; // 원상 복구
        } // end of fori

        System.out.println(max);

    }// end of main

    // 가장 가까운 두사람 거리 반환
    public static int getMindist() {
        int min = Integer.MAX_VALUE;
        // 둘 다 1인 곳에 대해
        // 모든 쌍을 조사하여, 그 중 가장 가까운 거리를 구한다.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == '1' && arr[j] == '1')
                    min = j - i < min ? j - i : min;
            }
        }

        return min;
    }

}// end of class
