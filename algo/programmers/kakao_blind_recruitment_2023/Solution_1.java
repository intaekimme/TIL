package programmers.kakao_blind_recruitment_2023;

import java.io.*;
import java.util.*;

/**
 * 2023 kakao blind recruitment
 * 개인정보 수집 유효기간
 * 
 * 시뮬레이션 풀이
 */
class Solution_1 {

    public static void main(String[] args) throws IOException {
        Solution_1 ps = new Solution_1();

        String today = "2022.05.19";
        String[] terms = new String[] { "A 6", "B 12", "C 3" };
        String[] privacies = new String[] { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };

        ps.solution(today, terms, privacies);
    }// end of main

    public int[] solution(String today, String[] terms, String[] privacies) {
        // System.out.println(y + " " + m + " " + d);

        List<Integer> res = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);

            String date = st.nextToken();

            String term = st.nextToken();

            for (int j = 0; j < terms.length; j++) {
                st = new StringTokenizer(terms[j]);

                String find_term = st.nextToken();
                int month = Integer.parseInt(st.nextToken());

                if (term.equals(find_term)) {
                    if (isValid(today, date, month))
                        res.add(i + 1);
                }

            } // end of inner for

        } // end of outter for

        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            answer[i] = res.get(i);

        return answer;
    }// end of sol

    public boolean isValid(String today, String date, int month) {
        StringTokenizer st = new StringTokenizer(today, ".");
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(date, ".");
        int d_y = Integer.parseInt(st.nextToken());
        int d_m = Integer.parseInt(st.nextToken());
        int d_d = Integer.parseInt(st.nextToken());

        int tot_d = month * 28;

        while (tot_d > 0) {
            tot_d--;

            d_d++;
            if (d_d > 28) {
                d_d = 1;
                d_m++;
            }
            if (d_m > 12) {
                d_m = 1;
                d_y++;
            }
        }

        if (d_y > y)
            return false;
        if (d_y >= y && d_m > m)
            return false;
        if (d_y >= y && d_m >= m && d_d > d)
            return false;
        return true;

    }// end of isValid

}// end of class