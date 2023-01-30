package programmers.kakao_blind_recruitment_2023;

import java.io.*;
import java.util.*;

/**
 * 2023 kakao blind recruitment
 * 이모티콘 할인행사
 * 
 * 완전탐색, 순열
 */
class Solution_3 {

    public static void main(String[] args) throws IOException {
        Solution_3 ps = new Solution_3();
        int[][] users = { { 40, 10000 }, { 25, 10000 } };
        int[] emoticons = { 7000, 9000 };
        ps.solution(users, emoticons);
    }// end of main

    private int[] discount = new int[] { 10, 20, 30, 40 };
    private int[] selected; // 선택한 이모티콘 별 할인율
    private int max_subscribers = 0;
    private int max_earn = 0;

    public void userPerchase(int[][] users, int[] emoticons) {
        int subscribers = 0;
        int earn = 0;

        // 유저 한명씩 이모티콘 구매
        for (int i = 0; i < users.length; i++) {
            int user_discount = users[i][0];
            int user_price = users[i][1];
            // 이모티콘 구매 시작

            int tot = 0;
            for (int j = 0; j < selected.length; j++) {
                if (selected[j] < user_discount)
                    continue;
                tot += emoticons[j] * ((double) (100 - selected[j]) / 100);
            }
            if (tot >= user_price)
                subscribers++;
            else
                earn += tot;
        }

        if (max_subscribers < subscribers) {
            max_subscribers = subscribers;
            max_earn = earn;
        }
        if (max_subscribers == subscribers) {
            if (max_earn < earn)
                max_earn = earn;
        }

    }// end of userPerchase

    public void perm(int cnt, int end, int[][] users, int[] emoticons) {
        if (cnt == end) {
            userPerchase(users, emoticons);
            return;
        }

        for (int i = 0; i < discount.length; i++) {
            selected[cnt] = discount[i];
            perm(cnt + 1, end, users, emoticons);
        }
    }// end of perm

    public int[] solution(int[][] users, int[] emoticons) {
        selected = new int[emoticons.length];
        perm(0, emoticons.length, users, emoticons);

        int[] answer = new int[2];
        answer[0] = max_subscribers;
        answer[1] = max_earn;

        return answer;
    }// end of solution
}
