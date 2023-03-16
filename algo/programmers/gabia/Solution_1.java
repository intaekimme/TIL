package programmers.gabia;

import java.util.*;

/**
 * 에지 케이스 뭐지;; 3개 틀림
 * 43.5 / 50
 */
class Solution_1 {

    public static void main(String[] args) {
        Solution_1 ps = new Solution_1();

        int[] k_arr = new int[] { 3, 3, 2 };

        String[][] arr = {
                { "alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110" },
                { "alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200" },
                { "cheries2 200", "alex111 100", "coco 150", "puyo 120" } };

        // for (int i = 0; i < 3; i++) {
        // System.out.println(ps.solution(k_arr[i], arr[i]));
        // }

        System.out.println(ps.solution(k_arr[1], arr[1]));
    }

    public int solution(int K, String[] user_scores) {
        int answer = 0; // 1페이지 변한 횟수

        // 1페이지 변화 기록
        HashSet<String> page = new HashSet<>();

        // 실시간 전체 랭킹
        ArrayList<Player> ranking = new ArrayList<>();

        // 실시간 전체 랭킹 인덱스 관리
        HashMap<String, Integer> index = new HashMap<>();

        StringBuilder sb;

        // 점수 하나가 들어오면
        for (int i = 0; i < user_scores.length; i++) {
            String[] input = user_scores[i].split(" ");

            int cur_score = Integer.parseInt(input[1]);

            // 현재까지 기록되지 않은 닉네임이면
            if (!index.containsKey(input[0])) {
                // 실시간 랭킹에 기록
                ranking.add(new Player(input[0], cur_score, i + 1));

                Collections.sort(ranking);

                for (int j = 0; j < ranking.size(); j++) {
                    // 실시간 전체 랭킹 인덱스 갱신
                    index.put(ranking.get(j).nickname, j);
                }
            } else {

                // 이미 기록된 닉네임이라면
                int idx = index.get(input[0]);

                Player player = ranking.get(idx);

                // 새로 기록된 점수가 더 높은 점수이면
                if (player.score < cur_score) {
                    player.score = cur_score; // 새로운 점수로 갱신
                    player.no = i + 1; // 순서 갱신
                }

                Collections.sort(ranking);

                for (int j = 0; j < ranking.size(); j++) {
                    // 실시간 전체 랭킹 인덱스 갱신
                    index.put(ranking.get(j).nickname, j);
                }

            } // end of else

            sb = new StringBuilder();

            if (ranking.size() >= K) {
                for (int j = 0; j < K; j++) {
                    sb.append(ranking.get(j).nickname).append(" ");
                }
            } else {
                for (int j = 0; j < ranking.size(); j++) {
                    sb.append(ranking.get(j).nickname).append(" ");
                }
            }

            if (!page.contains(sb.toString())) {
                answer++;
                page.add(sb.toString());
            }
        }
        return answer;
    }// end of solution
}// end of class

/**
 * 점수 클래스
 */
class Player implements Comparable<Player> {
    String nickname; // 닉네임
    int score; // 점수
    int no; // 점수 입력 순서

    public Player(String nickname, int score, int no) {
        this.nickname = nickname;
        this.score = score;
        this.no = no;
    }

    @Override
    public int compareTo(Player p) {
        if (this.score == p.score) // 점수가 같다면 해당 점수를 먼저 달성한 유저 랭킹이 높음
            return this.no - p.no; // 오름차순
        return p.score - this.score; // 점수가 높은 유저의 랭킹이 더 높음 (내림차순)
    }
}// end of class
