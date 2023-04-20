package programmers.algorithm_practice_kit.kakao_blind_recruitment_2020;

import java.util.*;

/**
 * 2020 kakao blind
 * 문자열 압축 fail
 */

class Solution {
    public int solution(String s) {

        int s_len = s.length() - 1;

        int ans = (int) 1e9; // 가장 짧게 압축한 문자열의 길이
        int cnt = 0; // 같은 문자의 갯수 카운트

        StringBuilder sb = null;
        // 문자열 S를 길이 l - 1부터 s.length() - 1 길이 단위로 잘라봄
        for (int l = 1; l <= s_len; l++) {
            sb = new StringBuilder();
            // 문자열 S의 0부터 길이 l - 1까지 잘라본다.(=길이 l 만큼 자름)
            // 이렇게 자른 문자열을 srr이라 한다.
            String srr = s.substring(0, l);

            // 인덱스 l부터 s_len - l까지 인덱스를 l씩 증가시키며
            // 인덱스 0부터 l - 1까지 증가시키며
            boolean isNotSame = false;
            for (int i = l; i < s_len - l; i++) {
                for (int j = 0; j < l; j++) {
                    // srr[j] 와 s[i + j]가 같은지 확인한다
                    // 같지 않으면 중단
                    if (srr.charAt(j) != s.charAt(i + j)) {
                        if (cnt > 1)
                            sb.append(cnt).append(srr);
                        else
                            sb.append(srr);
                        isNotSame = true;
                        srr = s.substring(i, i + l);
                        i = i - 1 + l;
                        break;
                    }

                }
                if (!isNotSame)
                    cnt++;
            }

            ans = Math.min(ans, sb.toString().length());
        } // end of for

        System.out.println(sb.toString());
        return ans;
    }// end of solution

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] input = new String[] { "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd" };

        for (int i = 0; i < input.length; i++) {
            System.out.println(sol.solution(input[i]));
        }
    }

}// end of class
