package programmers.algorithm_practice_kit.stack_que;

import java.io.*;
import java.util.*;

/**
 * 주식가격
 * 테케 모두 통과, 효율성은 통과 x
 */
class Solution_5 {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j])
                    continue;
                answer[i]++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution_5 ps = new Solution_5();
        int[] prices = new int[] { 1, 2, 3, 2, 4 };
        ps.solution(prices);
    }// end of main
}