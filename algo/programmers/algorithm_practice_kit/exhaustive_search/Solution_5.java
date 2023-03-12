package programmers.algorithm_practice_kit.exhaustive_search;

import java.util.*;

/**
 * vlfheh, lv2
 * 
 * 순열 생성, 정답 (최댓값)
 * 각 순열에 대해 수행 가능한 던전의 갯수 확인
 * 모든 순열에 대해 정답 갱신
 * 던전 최대 길이 : 8이기에 MAX 약 40_000, 완전탐색 가능
 *
 *
 * 순열 생성 함수 -> 순열 완성 시 확인 함수 호출
 *
 */

class Solution_5 {

    int[] selected; // 순열 순서 선택
    boolean[] visited; // 순열 생성 방문 배열

    int N; // 던전 갯수
    int ans = 0; // 정답, 최댓값 갱신

    // 수행 가능한 던전의 갯수 반환
    public int getPossibleDungeons(int k, int[][] dungeons) {
        int cnt = 0;

        int health = k;
        for (int i = 0; i < N; i++) {
            int cur = selected[i];

            int[] dungeon = dungeons[cur];

            if (health >= dungeon[0]) {
                cnt++;
                health -= dungeon[1];
            }
        }

        return cnt;
    }// end of getPossibleDungeons

    // 순열 생성
    public void perm(int k, int[][] dungeons, int depth) {
        if (depth == N) {
            // System.out.println(Arrays.toString(selected));

            ans = Math.max(ans, getPossibleDungeons(k, dungeons));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            selected[depth] = i;

            perm(k, dungeons, depth + 1);

            visited[i] = false;
        }
    }

    public int solution(int k, int[][] dungeons) {

        // 초기화
        N = dungeons.length;
        selected = new int[N];
        visited = new boolean[N];

        perm(k, dungeons, 0);

        return ans;
    }
}
