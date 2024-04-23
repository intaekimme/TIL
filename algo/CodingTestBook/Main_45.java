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

    private static int answer;
    private static int[][] Dungeons;
    private static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        answer = -1;
        Dungeons = dungeons;
        visited = new boolean[dungeons.length];

        backtrack(k, 0);
        return answer;
    }

    private static void backtrack(int k, int cnt) {
        for (int i = 0; i < Dungeons.length; i++) {
            if (visited[i] || k < Dungeons[i][0])
                continue;
            visited[i] = true;
            backtrack(k - Dungeons[i][1], cnt + 1);
            answer = Math.max(answer, cnt + 1);
            visited[i] = false;
        }
    }// end of backtrack
}