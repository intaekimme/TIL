
import java.io.*;

/**
 * 1989. 초심자의 회문 검사
 */
public class Solution_1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TC; tc++) {
            String query = br.readLine().trim();
            sb.append("#").append(tc).append(" ");

            if (isPalindrome(query))
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        } // end of TC

        System.out.println(sb.toString());

    }// end of main

    public static boolean isPalindrome(String query) {
        int n = query.length() - 1;
        for (int i = 0; i <= n / 2; i++) {
            if (query.charAt(i) != query.charAt(n - i))
                return false;
        }
        return true;
    }
}// end of class
