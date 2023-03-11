package programmers.algorithm_practice_kit.dfs_bfs;

import java.util.*;

/**
 * 여행 경로, lv3
 * bfs fail
 */

class Solution_6 {

    int n;

    Map<String, Integer> map;
    ArrayList<String>[] list;
    ArrayList<boolean[]> visited;

    ArrayList<String> ans;

    public void init(String[][] tickets) {
        int val = 0;

        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                String key = tickets[i][j];
                if (!map.containsKey(key))
                    map.put(key, val++);
            }
        }

        list = new ArrayList[map.size()];
        visited = new ArrayList<>();

        for (int i = 0; i < map.size(); i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];

            int from_idx = map.get(from);
            int to_idx = map.get(to);

            list[from_idx].add(to);
        }

        for (int i = 0; i < map.size(); i++) {
            Collections.sort(list[i]);
            visited.add(new boolean[list[i].size()]);
        }

        ans = new ArrayList<>();
    }// end of init

    public void bfs() {
        Queue<String> que = new ArrayDeque<>();

        String start = "ICN";
        int start_idx = map.get(start);
        que.offer(start);

        while (!que.isEmpty()) {
            String cur = que.poll();
            ans.add(cur);

            int cur_idx = map.get(cur);

            for (int i = 0; i < list[cur_idx].size(); i++) {
                String to = list[cur_idx].get(i);

                if (visited.get(cur_idx)[i])
                    continue;
                visited.get(cur_idx)[i] = true;
                que.offer(to);
                break;
            }
        }

    }// end of bfs

    public String[] solution(String[][] tickets) {

        n = tickets.length;

        init(tickets);

        bfs();

        System.out.println(ans.toString());
        String[] answer = ans.toArray(new String[ans.size()]);
        return answer;
    }
}
