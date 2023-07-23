package Novice_mid.exhaustive_search_3.exhaustive_search_by_setting_a_new_standard;

import java.io.*;
import java.util.*;

/**
 * A, B, C, D 찾기 2
 * 
 * 하드코딩의 문제점. 인풋으로 주어진 결과의 1,2,3,4 인덱스가 a, b, c, d와 일치할 것이라고 생각한 것이 패착
 * 
 * input : 10 10 10 7 4 3 7 7 3 14 14 11 13 6 17
 * 정렬 : [3, 3, 4, 6, 7, 7, 7, 10, 10, 10, 11, 13, 14, 14, 17]
 * 
 * a=3, b=3, c=4, d=7 일 경우
 * 4번 index에서 맞지 않는 문제 발생
 * 
 * fail
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
                        boolean[] check = new boolean[15];

                        if (input[0] == a)
                            check[0] = true;
                        if (input[1] == b)
                            check[1] = true;
                        if (input[2] == c)
                            check[2] = true;
                        if (input[3] == d)
                            check[3] = true;

                        for (int i = 4; i < 15; i++) {
                            if (input[i] == a + b)
                                check[i] = true;
                            else if (input[i] == b + c)
                                check[i] = true;
                            else if (input[i] == c + d)
                                check[i] = true;
                            else if (input[i] == d + a)
                                check[i] = true;
                            else if (input[i] == a + c)
                                check[i] = true;
                            else if (input[i] == b + d)
                                check[i] = true;
                            else if (input[i] == a + b + c)
                                check[i] = true;
                            else if (input[i] == a + b + d)
                                check[i] = true;
                            else if (input[i] == a + c + d)
                                check[i] = true;
                            else if (input[i] == b + c + d)
                                check[i] = true;
                            else if (input[i] == a + b + c + d)
                                check[i] = true;
                            else
                                check[i] = false;
                        }

                        boolean isAllTrue = true;
                        for (int i = 0; i < 15; i++) {
                            if (!check[i])
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
