package programmers.practice;

/**
 * 행렬의 곱셈, lv2
 * 행 열
 * l * n, n * m -> l * m
 */

class Solution_1 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int l = arr1.length;
        int n = arr2.length;
        int m = arr2[0].length;

        int[][] answer = new int[l][m];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
