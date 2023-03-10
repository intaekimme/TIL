package programmers.algorithm_practice_kit.dfs_bfs;

import java.util.*;

/**
 * 단어 변환, bfs
 */

class Solution_4 {

    int[] dist;
    ArrayList<Integer>[] list;
    Queue<Integer> que;

    public boolean isPossible(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                cnt++;
        }

        if (cnt == 1)
            return true;
        return false;
    }// end of isPossible

    public void makeGraph(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j)
                    continue;
                if (isPossible(words[i], words[j]))
                    list[i].add(j);
            }
        }
    }// end of makeGraph

    public void init(String[] words) {
        list = new ArrayList[words.length];
        for (int i = 0; i < words.length; i++)
            list[i] = new ArrayList<>();

        dist = new int[words.length];

        makeGraph(words);

        que = new ArrayDeque<>();
    }// end of init

    public int solution(String begin, String target, String[] words) {

        init(words);

        for (int i = 0; i < words.length; i++) {
            if (isPossible(begin, words[i])) {
                que.offer(i);
                dist[i] = 1;
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                int word_num = list[cur].get(i);
                if (dist[word_num] == 0 && isPossible(words[cur], words[word_num])) {
                    dist[word_num] = dist[cur] + 1;
                    que.offer(word_num);
                }

            }
        }

        int target_num = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target))
                target_num = i;
        }

        System.out.println(Arrays.toString(dist));

        int answer = target_num == -1 ? 0 : dist[target_num];
        return answer;
    }
}
