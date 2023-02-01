package Novice_mid.exhaustive_search_3.exhaustive_exploration_by_assuming_the_situation_one_by_one;

import java.io.*;
import java.util.*;

/**
 * 팀으로 하는 틱택토 2
 * 
 * fail
 * 조합 코드와 우승 케이스 판단을 잘못해서 틀린것 같다.
 */
public class Main_6 {

    static boolean[] member_emerg = new boolean[10];
    static int[] member = new int[9];
    static boolean[] visit;
    static int member_length = 0;

    static String[] map = new String[3];
    static int[][] team;
    static int ans = 0;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            map[i] = br.readLine();
            for (int j = 0; j < 3; j++)
                member_emerg[map[i].charAt(j) - '0'] = true;
        }

        member_length = 0;
        for (int i = 1; i <= 9; i++) {
            if (member_emerg[i])
                member[member_length++] = i;
        }

        visit = new boolean[member_length];
    }// end of init

    public static boolean isOne(String line) {
        return line.charAt(0) == line.charAt(1) && line.charAt(1) == line.charAt(2) && line.charAt(0) == line.charAt(2);
    }// end of isOne

    public static int sum(int[] arr) {
        int sum = 0;
        for (int n : arr)
            sum += n;
        return sum;
    }

    public static int countWinning(int[] team) {
        int cnt = 0;
        // 행 확인
        for (int i = 0; i < 3; i++) {
            int same_team_cnt = 0;
            for (int j = 0; j < 3; j++) {
                int cur_num = map[i].charAt(j) - '0';
                if (team[0] == cur_num || team[1] == cur_num)
                    same_team_cnt++;
            }
            if (same_team_cnt == 3 && !isOne(map[i]))
                cnt++;
        }

        // 열 확인
        StringBuilder sb;
        for (int i = 0; i < 3; i++) {
            int same_team_cnt = 0;
            sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb.append(Character.toString(map[j].charAt(i)));
                int cur_num = map[j].charAt(i) - '0';
                if (team[0] == cur_num || team[1] == cur_num)
                    same_team_cnt++;
            }
            if (same_team_cnt == 3 && !isOne(sb.toString()))
                cnt++;
        }

        // 대각선 확인 , / 대각선
        int same_team_cnt = 0;
        sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(Character.toString(map[i].charAt(i)));
            int cur_num = map[i].charAt(i) - '0';
            if (team[0] == cur_num || team[1] == cur_num)
                same_team_cnt++;
        }
        if (same_team_cnt == 3 && !isOne(sb.toString()))
            cnt++;

        // 대각선 확인, \ 대각선
        same_team_cnt = 0;
        sb = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb.append(Character.toString(map[i].charAt(i)));
            int cur_num = map[i].charAt(i) - '0';
            if (team[0] == cur_num || team[1] == cur_num)
                same_team_cnt++;
        }
        if (same_team_cnt == 3 && !isOne(sb.toString()))
            cnt++;

        return cnt;
    }// end of countWinning

    public static void func(int depth, int team_num, int count, int start) {
        if (count == 2) {
            team_num++;
            count = 0;
        }

        if (depth == member_length) {
            // 팀 분할 완료, 틱택토 확인 시작

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < member_length / 2; i++) {
                sb.append(Arrays.toString(team[i])).append(" ");
            }
            System.out.println(sb.toString());

            int[] check_count = new int[member_length / 2];

            // 한 팀당 이긴 횟수 카운트
            for (int i = 0; i < member_length / 2; i++) {
                check_count[i] = countWinning(team[i]);
            }

            // 한 팀만 이기려면, 모든 팀에서 이긴 경우가 하나만 나와야함
            int cnt = 0;
            for (int i = 0; i < member_length / 2; i++) {
                // 팀 별 우승 횟수가 1회 이상인 경우 카운트
                if (check_count[i] >= 1)
                    cnt++;
            }

            // 모든 팀의 우승 횟수를 세봤는데 우승을 한 번이라도 한 팀이 단 하나인 경우
            if (sum(check_count) > 0 && cnt < 2)
                ans++;
            return;
        }

        for (int i = 0; i < member_length; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            team[team_num][count] = member[i];
            func(depth + 1, team_num, count + 1, i + 1);
            visit[i] = false;
        }

    }// end of func

    public static void sol() {
        // 팀 분할

        // 분할 경우 기록할 배열 생성, 기록된 팀원들을 2명씩 팀으로 묶으므로 2로 나눠줌
        team = new int[member_length / 2][2];

        // 팀 분할 시작
        func(0, 0, 0, 0);

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main

}// end of class
