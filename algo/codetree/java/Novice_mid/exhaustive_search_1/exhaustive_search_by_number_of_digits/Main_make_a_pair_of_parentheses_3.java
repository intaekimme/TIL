package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;

/**
 * 뒤에서부터 괄호들을 센다.
 * 
 * 뒤에서부터 닫힌 괄호 (')')들의 갯수를 누적해 카운트 한다.
 * 이 후 열린 괄호 ('(')를 찾으면 지금까지 찾은 닫힌 괄호의 갯수를 정답에 누적한다.
 * 
 * 핵심 아이디어.
 * 열린 괄호를 하나 찾으면 지금까지 찾은 닫힌 괄호의 갯수만큼 괄호쌍을 만들 수 있다.
 */
public class Main_make_a_pair_of_parentheses_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String query = br.readLine();

        int ans = 0; // 정답 괄호쌍 갯수
        int closed_num = 0; // 뒤에서부터 찾은 닫힌 괄호 갯수
        // 뒤에서부터 찾는다.
        for (int i = query.length() - 1; i >= 0; i--) {
            if (query.charAt(i) == ')')
                closed_num += 1; // 닫힌 괄호를 발견하면 갯수를 누적하고
            else
                ans += closed_num; // 열린 괄호를 찾으면 그 갯수를 정답에 누적한다.
        }

        System.out.println(ans); // 정답 출력
    }
}
