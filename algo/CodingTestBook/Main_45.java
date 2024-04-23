package CodingTestBook;

import java.io.*;
import java.util.*;

public class Main_45 {
    public static void main(String[] args) throws Exception {
        Solution ps = new Solution();
        System.out.println(ps.solution(80, new int[][] { { 80, 20 }, { 50, 40 }, { 30, 10 } }));
    }
}

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        answer = Math.max(answer, func(k, dungeons, new boolean[dungeons.length], 0, 0)); // 돌은 던전의 갯수
        return answer;
    }

    public int func(int k, int[][] dungeons, boolean[] visited, int pos, int cnt) {
        if (k <= 0)
            return cnt; // 기저 조건
        if (pos == dungeons.length)
            return cnt; // 기저 조건

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i])
                continue;
            if (k < dungeons[i][0])
                continue;
            visited[i] = true;
            k -= dungeons[i][1];
            cnt++;

            func(k, dungeons, visited, pos + 1, cnt);
            visited[i] = false;
            k += dungeons[i][1];
            cnt--;
        }

        return cnt;
    }// end of func
}
