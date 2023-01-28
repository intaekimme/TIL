package programmers.algorithm_practice_kit.stack_que;

import java.io.*;
import java.util.*;

/**
 * 기능 개발
 */
public class Solution_3 {

    static Queue<Feat> que = new LinkedList<>();

    public static void init(int[] progresses, int[] speeds) {
        int len = speeds.length;
        for (int i = 0; i < len; i++) {
            que.offer(new Feat(progresses[i], speeds[i]));
        }
    }// end of init

    public static int[] process() {

        List<Integer> res = new ArrayList<>();
        while (!que.isEmpty()) {
            int cnt = 0; // 하루 배포량
            // 하루 작업
            for (int i = 0; i < que.size(); i++) {
                Feat feat = que.poll();
                feat.prog += feat.speed;
                que.offer(feat);
            }

            while (!que.isEmpty() && que.peek().prog >= 100) {
                que.poll();
                cnt++;
            }

            if (cnt > 0)
                res.add(cnt);
        }

        int[] ans = new int[res.size()];
        int idx = 0;
        for (Integer cnt : res) {
            ans[idx++] = cnt;
        }

        return ans;
    }// end of process

    public static int[] solution(int[] progresses, int[] speeds) {
        init(progresses, speeds);
        int[] answer = process();
        return answer;
    }

    public static void main(String[] args) throws IOException {
        int[] progresses = new int[] { 93, 30, 55 };
        int[] speeds = new int[] { 1, 30, 5 };
        solution(progresses, speeds);
    }// end of main

}// end of class

class Feat {
    int prog;
    int speed;

    public Feat(int prog, int speed) {
        this.prog = prog;
        this.speed = speed;
    }
}// end of class