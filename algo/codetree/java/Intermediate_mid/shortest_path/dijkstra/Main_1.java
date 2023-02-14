package Intermediate_mid.shortest_path.dijkstra;

import java.io.*;
import java.util.*;

/**
 * 각 정점까지의 최단 경로 3
 */
public class Main_1 {

    static final int MAX_N = 100;

    static int n, m;
    static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from][to] = weight;
        }
    }// end of init

    public static void dijkstra() {
        Arrays.fill(dist, (int) 1e9);
        dist[1] = 0;

        for (int i = 1; i <= n; i++) {
            // v개의 정점 중
            // 아직 방문하지 않은 정점 중
            // dist 값이 가장 작은 것 선택
            int minIdx = -1;
            for (int j = 1; j <= n; j++) {
                if (visited[j])
                    continue;
                if (minIdx == -1 || dist[j] < dist[minIdx])
                    minIdx = j;
            }

            // 최솟값에 해당하는 정점에 방문 처리
            visited[minIdx] = true;

            // 최솟값에 해당하는 정점에 연결된 간선을 보며
            // 시작점으로부터의 최솟값 갱신
            for (int j = 1; j <= n; j++) {
                if (graph[minIdx][j] == 0)
                    continue;
                dist[j] = Math.min(dist[j], dist[minIdx] + graph[minIdx][j]);
            }
        }

    }// end of dijkstra

    public static void sol() {
        dijkstra();
        StringBuilder sb = new StringBuilder();

        // 도달이 불가능하면 1e9이므로 -1 출려
        for (int i = 2; i <= n; i++)
            sb.append(dist[i] != (int) 1e9 ? dist[i] : -1).append("\n");

        System.out.println(sb.toString());
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class