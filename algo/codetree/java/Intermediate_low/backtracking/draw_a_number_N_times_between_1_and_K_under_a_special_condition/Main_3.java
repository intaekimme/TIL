package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_under_a_special_condition;

import java.io.*;
import java.util.*;

public class Main_3 {
    public static void main(String[] args) throws IOException {
        int[] test = new int[] { 4, 5, 6, 4, 4 };

        String res = makeString(test);

        // substring test
        String piece1 = res.substring(0, 3);

        String piece2 = res.substring(3, res.length());

        System.out.println(res + " " + piece1 + " " + piece2);

        // Long 최댓값 확인 : 9223372036854775807, 19자리
        Long test2 = Long.MAX_VALUE;
        System.out.println(test2);

        String test3 = "6666666666666";
        String test4 = "44444444";
        String test5 = "5555555555";
        String[] arr = new String[3];
        arr[0] = test5;
        arr[1] = test3;
        arr[2] = test4;

        // 문자열 sorting 전
        // [5555555555, 6666666666666, 44444444]
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);

        // 문자열 sorting 후
        // [44444444, 5555555555, 6666666666666]
        // 사전순으로 정렬됨
        System.out.println(Arrays.toString(arr));

        // 문자열 대소비교는 compareTo
        /**
         * 비교 대상에 문자열이 포함되어 있는 경우
         * 서로의 문자열 길이의 차이값을 리턴
         * 
         * 주의!
         * compareTo는 같은 위치의 문자만 비교하기 때문에, 첫번째 문자부터 순서대로 비교해서 다를 경우
         * 바로 아스키값을 기준으로 비교처리
         * 
         * 4와 5가 다르고
         * 4 - 5 = -1 < 0
         */

        if (test4.compareTo(test5) < 0)
            System.out.println("yes");

    }// end of main

    public static String makeString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
