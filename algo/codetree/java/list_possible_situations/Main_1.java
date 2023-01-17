package list_possible_situations;

import java.io.*;
import java.util.*;

/**
 * 순위 경쟁 2
 */
public class Main_1 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        char state = 'E'; // 명예의 전당 상태, 동점;E, A 1등; A, B 1등; B
        int[] score = new int[2]; // A, B의 점수 상태
        int cnt = 0; // 변경 횟수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char person = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken());

            if (person == 'A')
                score[0] += s;
            else
                score[1] += s;

            char res = ' ';
            if (score[0] > score[1]) {
                res = 'A';
            } else if (score[0] < score[1]) {
                res = 'B';
            } else {
                res = 'E';
            }

            if (state != res) {
                cnt++;
                state = res;
            }

        }

        System.out.println(cnt);

    }// end of main
}
