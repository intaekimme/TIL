package programmers.algorithm_practice_kit.stack_que;

import java.util.*;

/**
 * 주식가격
 * 테케 모두 통과, 효율성은 통과 x
 */
public class Solution_5 {
    public int[] solution(int[] prices) {

        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            arr.add(new int[] { prices[i], -1, 0 });

            for (int j = 0; j < arr.size(); j++) {
                int[] cur = arr.get(j);
                if (cur[2] == 0) {
                    if (cur[0] > arr.get(arr.size() - 1)[0])
                        arr.get(j)[2] = 1;
                    arr.get(j)[1]++;

                }
            }

        }

        int[] answer = new int[prices.length];
        int idx = 0;
        for (int[] price : arr)
            answer[idx++] = price[1];

        return answer;
    }
}