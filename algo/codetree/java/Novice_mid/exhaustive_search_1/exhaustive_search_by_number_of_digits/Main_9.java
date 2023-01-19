package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;

/**
 * 괄호 쌍 만들어주기 2
 * 뒤에서부터 괄호를 센다
 * )) 나오면 나온 횟수를 누적한다
 * (( 나올 때마다 정답에 앞서 기록한 닫힌 괄호 횟수를 더한다.
 */
public class Main_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int cnt = 0;
        int ans = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == ')' && arr[i - 1] == ')') {
                cnt++;
                continue;
            }
            if (arr[i] == '(' && arr[i - 1] == '(')
                ans += cnt;
        }

        System.out.println(ans);
    }// end of main
}
