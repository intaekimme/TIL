
import java.io.*;
import java.util.*;

/**
 * 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
 */
public class Solution_1218 {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");

            int n = Integer.parseInt(br.readLine()); // 테스트 케이스 길이
            String query = br.readLine(); // 테스트 케이스

            sb.append(check(n, query)).append("\n"); // 테스트 케이스 체크 후 유효성 여부 기록
        } // end of tc

        System.out.println(sb.toString()); // 정답 출력

    }// end of main

    /**
     * 테스트 케이스의 유효성 여부 체크
     * 
     * @param length 테스트 케이스 길이
     * @param query  테스트 케이스
     * @return 1 테스트 케이스 유효
     * @return 0 테스트 케이스 유효하지 않음
     */
    public static int check(int length, String query) {
        Stack<Character> s = new Stack<>(); // 뒤에서부터 확인할 것, 먼저 들어온 괄호가 매칭이 되는 순서대로 나간다.

        s.add(query.charAt(length - 1)); // 스택이 비어 있지 않으면 검사를 하는 규칙이므로 처음에 값을 하나 채움

        // 테스트 케이스의 맨 마지막 바로 이전부터 처음까지 유효성 확인
        for (int i = length - 2; i >= 0; i--) {
            char cur = query.charAt(i); // 대상 괄호
            // 스택이 비어있지 않고, 현재 들어온 괄호와, 스택의 이전 입력이 매칭이 되면 스택에서 꺼내서 검사에서 제외시킨다.
            if (!s.isEmpty() && isMatch(cur, s.peek())) {
                s.pop();
                continue;
            }
            // 스택이 비어 있거나, 매칭이 되지 않은 경우 이후 매칭 여부를 확인하기 위해 스택에 넣는다.
            s.add(cur);
        }

        // 스택이 비어있으면 모든 괄호가 매칭이 됐으므로 유효성 통과
        if (s.empty())
            return 1;
        return 0; // 일부라도 남아있으면 유효성 통과 못함
    }// end of check

    /**
     * 괄호 매칭 여부 판단
     * 
     * @param cur // 현재 확인이 필요한 괄호
     * @param top // 바로 이전 입력에 들어온 괄호
     * @return true // 일치하면 true
     * @return false // 일치하지 않으면 false
     */
    public static boolean isMatch(char cur, char top) {
        // 앞서 테스트 케이스의 뒤에서부터 스택에 넣기 때문에
        // 현재 확인이 필요한 문자는 열린 괄호
        // 스택의 탑은 닫힌 괄호여야만 매칭이 성립한다.
        // 이 외의 경우는 모두 매칭이 되지 않는다.
        if ((cur == '(' && top == ')') || (cur == '[' && top == ']') || (cur == '{' && top == '}')
                || (cur == '<' && top == '>'))
            return true;
        return false;
    }

}// end of class
