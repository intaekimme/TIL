package Novice_mid.exhaustive_search_3.exhaustive_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

/**
 * A, B, C, D 찾기 2
 * 
 * 하드코딩이지만 맞는 것
 * 
 * 선택된 a, b, c, d로 구하려는 형식의 배열 생성
 * 생성된 원소가 모두 맞는 경우 출력
 * 
 * 
 */

public class Main_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[15];
        int max = 0;
        for (int i = 0; i < 15; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, input[i]);
        }

        Arrays.sort(input);

        for (int a = 1; a <= max; a++) {
            for (int b = a; b <= max; b++) {
                for (int c = b; c <= max; c++) {
                    for (int d = c; d <= max; d++) {
                        int[] gen = new int[] { a, b, c, d, a + b, b + c, c + d, d + a, a + c, b + d, a + b + c,
                                a + b + d, a + c + d, b + c + d, a + b + c + d };

                        Arrays.sort(gen);

                        boolean isAllTrue = true;
                        for (int i = 0; i < 15; i++) {
                            if (input[i] != gen[i])
                                isAllTrue = false;
                        }

                        if (isAllTrue) {
                            System.out.println(a + " " + b + " " + c + " " + d);
                            return;
                        }
                    }
                }
            }
        }

    }// end of main

}// end of class
