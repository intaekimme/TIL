package boj.bfs;

import java.io.*;
import java.util.*;

/**
 * 촌수계산 2644
 */

public class Main_2644 {

    static int n, m;
    static int s, e;

    static ArrayList<Integer>[] list;

    static int[] visited;

    @SuppressWarnings("unchecked")
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        visited = new int[n + 1];
        Arrays.fill(visited, -1);

    }// end of init

    public static void sol() {

        Queue<Integer> que = new ArrayDeque<>();

        visited[s] = 0;
        que.offer(s);

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < list[cur].size(); i++) {
                int target = list[cur].get(i);
                if (visited[target] == -1) {
                    visited[target] = visited[cur] + 1;
                    que.offer(target);
                }
            }
        }

        // System.out.println(Arrays.toString(visited));
        System.out.println(visited[e]);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class
