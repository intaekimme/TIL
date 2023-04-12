package programmers.algorithm_practice_kit.dfs_bfs;

import java.util.*;

/**
 * 프로그래머스 DFS/BFS
 * 여행경로
 * 
 * tc 1
 * [[ICN, JFK, HND, IAD]]
 * 
 * tc 2
 * [[ICN, SFO, ATL, ICN, ATL, SFO]]
 * [[ICN], [ICN, ATL, ICN, SFO, ATL, SFO]]
 * [[ICN], [ICN, ATL, SFO, ATL, ICN, SFO], [ICN, ATL, SFO, ATL, ICN, SFO]]
 * 
 * tc 3
 * [[ICN, B, ICN, A]]
 * 
 * 와 같이 ICN이 하나만 남고 들어가는 현상 발생
 * call by reference 문제
 * 
 * 재귀 함수의 기저 조건문에서 재귀 시작 시 넘긴 인자를 그대로 정답 리스트에 넣은게 실패 원인
 * 백트랙킹을 사용했기 때문에 이 과정에서 이전 결과가 변경된 것 (44 ~ 50 line)
 * 따라서 이 문제를 해결하려면 새로운 list를 생성해서 값을 새로 생성하는 형식으로 넣어줘야 한다.
 */

class Solution_6_1 {

    boolean[] visited;
    ArrayList<ArrayList<String>> ans;

    public int getRemainTicket() {
        int cnt = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                cnt++;
        }
        return cnt;
    }// end of getRemainTicket

    public void search(String from, ArrayList<String> record, String[][] tickets) {
        // 기저 조건
        if (getRemainTicket() == 0) {
            // System.out.println(record.toString());
            if (record.size() > 1)
                ans.add(record);
            System.out.println(ans.toString());
            return;
        }

        // 티켓은 남아 있는데
        // from에서 더 이상 갈 수 있는 곳이 없는 경우 탐색 중단
        boolean exit = true;
        for (int i = 0; i < visited.length; i++) {
            // from에서 갈 수 있는 곳이 있다면 종료 여부 확인 중단
            if (tickets[i][0].equals(from) && !visited[i]) {
                exit = visited[i];
                break;
            }
        }
        if (exit) {
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (tickets[i][0].equals(from) && !visited[i]) {
                visited[i] = true;
                String to = tickets[i][1];
                record.add(to);

                search(to, record, tickets);
                visited[i] = false;
                record.remove(record.size() - 1);
            }
        }
    }// end of search

    public String[] solution(String[][] tickets) {
        ans = new ArrayList<>();
        visited = new boolean[tickets.length];

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0] == "ICN") {
                visited[i] = true;
                ArrayList<String> record = new ArrayList<>();

                record.add("ICN");
                record.add(tickets[i][1]);

                search(tickets[i][1], record, tickets);
                visited[i] = false;
                record.remove(record.size() - 1);
            } // end of if
        } // end of for

        // for (ArrayList<String> list : ans) {
        // for (String str : list)
        // System.out.print(str + " ");
        // System.out.println();
        // }

        return new String[] { "" };
    }// end of solution

    public static void main(String[] args) {
        String[][][] tc = {
                { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } },
                { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } },
                { { "ICN", "A" }, { "ICN", "B" }, { "B", "ICN" } }
        };

        Solution_6_1 sol = new Solution_6_1();

        for (int i = 0; i < 3; i++) {
            sol.solution(tc[i]);
        }
    }

}// end of class