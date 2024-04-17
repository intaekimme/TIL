package coding_test;

import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();

        int[][] arrs = { { 2, 5, 3, 8, 1 }, { 1, 1, 2, 2 }, { 1, 2, 3, 2 } };

        int[] krr = new int[] { 3, 2, 2 };
        int[] trr = new int[] { 11, 3, 2 };

        int[] res = new int[] { 6, 5, 0 };

        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("=======================");
            System.out.println("ps : " + i);
            if (res[i] == sol.solution(arrs[i], krr[i], trr[i]))
                cnt++;
        }

        if (cnt == 3)
            System.out.println("correct");

        System.out.println("fail");
    }

    public int comb(int[] rec, boolean[] visited, int depth, int start, int[] arr) {
        if (depth == rec.length) {
            int res = 0;
            for (int num : rec)
                res += num;
            return res;
        }

        for (int i = start; i < rec.length; i++) {
            rec[depth] += arr[i];
            comb(rec, visited, depth + 1, i + 1, arr);
        }

        return 0;
    }// end of comb

    public int solution(int[] arr, int k, int t) {
        // k개 이상 뽑는 조합 호출
        int res = 0;
        for (int depth = k; depth < arr.length; depth++) {
            System.out.println("depth: " + depth);

            int comb_res = comb(new int[depth], new boolean[depth], 0, 0, arr);
            System.out.println("comb_result : " + comb_res);

            if (comb_res <= t)
                res++;
        }

        return res;
    }

}// end of class