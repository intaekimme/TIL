package Intermediate_low.dfs;

import java.io.*;
import java.util.*;

/**
 * 그래프 탐색
 * 1 <= n <= 1000
 * 0 <= m <= min(10_000, (n * (n - 1)) / 2)
 * 이므로 인접리스트가 효율적
 * 양방향 그래프
 */
public class Main {

    static final int VERTICES_NUM = 1_000;

    static int n, m;
    @SuppressWarnings("unchecked")
    static ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[VERTICES_NUM + 1];
    static boolean[] visited = new boolean[VERTICES_NUM + 1];
    static int cnt = 0;

    public static void dfs(int vertex) {
        for (int i = 0; i < graph[vertex].size(); i++) {
            int currV = graph[vertex].get(i);
            if (!visited[currV]) {
                visited[currV] = true;
                cnt++;
                dfs(currV);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);

        }

        int rootVertext = 1;
        visited[rootVertext] = true;

        dfs(rootVertext);

        System.out.println(cnt);

    }// end of main

}// end of class
