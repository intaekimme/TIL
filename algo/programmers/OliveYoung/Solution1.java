package programmers.OliveYoung;

import java.util.*;

public class Solution1 {

    int[] buffer;
    int len;

    public int solution(String number) {
        buffer = new int[102];
        Arrays.fill(buffer, -1);

        len = number.length();

        int cnt = 0;
        for (int idx = 0; idx < len; idx++) {
            // 아무것도 없는 값일 때
            int num = Integer.parseInt(new String(new char[] { number.charAt(idx) }));
            if (buffer[idx] == -1) {
                doSomething();
            } else {

            }
        }

        return cnt;
    }// end of solution

    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        String[] tc = new String[] { "12156", "321", "1234567", "100" };

        for (int i = 0; i < tc.length; i++) {
            System.out.println(sol.solution(tc[i]));
        }
    }
}// end of class
