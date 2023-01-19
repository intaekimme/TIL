package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;

/**
 * 씨 오 더블유2
 * C가 발견되면 c_cnt에 기록
 * O가 발견되면 앞선 C의 개수만큼 'CO'를 만들 수 있으므로 o_cnt에 c_cnt 누적
 * W가 발견되면 앞선 O의 개수만큼 'CWO'를 만들 수 있으므로 w_cnt에 o_cnt 누적
 * 
 * 최종 정답은 w_cnt
 */
public class Main_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int c_cnt = 0;
        int o_cnt = 0;
        int w_cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'C') {
                c_cnt++;
                continue;
            }
            if (arr[i] == 'O') {
                o_cnt += c_cnt;
                continue;
            }
            if (arr[i] == 'W')
                w_cnt += o_cnt;
        }

        System.out.println(w_cnt);

    }// end of main
}
