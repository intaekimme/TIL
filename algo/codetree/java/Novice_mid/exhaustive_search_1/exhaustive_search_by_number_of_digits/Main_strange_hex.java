package complete_search_by_number_of_digits;

import java.io.*;
import java.lang.Math;

/**
 * 가능한 숫자 N 중 최댓값을 찾는 프로그램
 * N을 찾기 위해서는 숫자 a중 어느 한 bit를 바꿔야 함.
 * 그리고 이렇게 바꾸었을 때 최댓값이 되어야 함.
 * 입력으로 주어진 문자열을 뒤에서부터 바꿔보며 최댓값을 갱신한다.
 * 
 */
public class Main_strange_hex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0 이상의 정수 N을 2진법으로 나타낸뒤, 그 숫자들 중 정확히 한 숫자만을 바꾼 숫자 a
        char[] query = br.readLine().toCharArray();

        int max = 0; // 정답.
        for (int i = query.length - 1; i > 0; i--) {
            // 원본 배열을 유지하며 확인하기 위해 복사본을 넘긴다.
            char[] copy = new char[query.length];
            System.arraycopy(query, 0, copy, 0, query.length);

            // 얕은 복사 주의
            max = Math.max(max, trans(copy, i));
        }

        System.out.println(max); // 정답 출력
    }// end of main

    // 2진수 -> 10진수 변환.
    // 뒤에서부터 한자리씩 누적한다
    public static int trans(char[] query, int i) {
        // 반전
        query[i] = query[i] == '1' ? '0' : '1';

        int len = query.length; // 입력 배열의 길이

        int res = 0; // 반환값

        // 1 or 0 * 2^n 누적
        for (int n = 0; n < len; n++) {
            res += (query[len - n - 1] - '0') * (int) Math.pow(2, n);
        }
        return res; // 10진수 반환
    } // end of trans

}// end of class
