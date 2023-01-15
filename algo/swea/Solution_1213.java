import java.io.*;

/**
 * 1213. [S/W 문제해결 기본] 3일차 - String
 */

public class Solution_1213 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(n).append(" ");

            String find = br.readLine();
            String query = br.readLine();

            int ans = countSubString(find, query);
            sb.append(ans).append("\n");
        } // end of for

        System.out.println(sb.toString()); // 정답 출력
    }// end of main

    // 찾아야 하는 부분 문자열과 소스 문자열을 입력받아 부분 문자열의 갯수를 세서 반환
    // 완전탐색
    public static int countSubString(String find, String query) {
        int cnt = 0; // 찾은 부분 문자열의 갯수

        // 소스 문자열에서 부분 문자열과 일치하는 모든 문자열을 공백으로 치환
        // replace 함수는 String 값을 return
        String res = query.replace(find, " ");

        // 공백 갯수를 세서 누적
        for (int i = 0; i < res.length(); i++)
            cnt += res.charAt(i) == ' ' ? 1 : 0;

        return cnt;
    }

}// end of class
