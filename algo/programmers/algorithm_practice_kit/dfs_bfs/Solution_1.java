package programmers.algorithm_practice_kit.dfs_bfs;

/**
 * 타겟 넘버, lv2
 */

class Solution_1 {

    int len;
    int ans = 0;
    int[] selected;
    boolean[] visited;

    public int getResult(int len, int[] numbers) {
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (selected[i] == 1)
                res += numbers[i];
            else
                res -= numbers[i];
        }

        return res;
    }// end of getResult

    public void perm(int depth, int target, int[] numbers) {
        if (depth == len) {
            if (getResult(len, numbers) == target)
                ans++;
            return;
        }

        visited[depth] = true;
        selected[depth] = 1;
        perm(depth + 1, target, numbers);

        visited[depth] = false;
        selected[depth] = 0;
        perm(depth + 1, target, numbers);
    }// end of perm

    public int solution(int[] numbers, int target) {

        len = numbers.length;

        selected = new int[len];
        visited = new boolean[len];

        perm(0, target, numbers);

        int answer = ans;
        return answer;
    }
}
