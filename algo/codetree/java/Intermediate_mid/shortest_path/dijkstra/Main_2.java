package Intermediate_mid.shortest_path.dijkstra;

import java.io.*;
import java.util.*;

/**
 * 각 정점까지의 최단경로
 * 다익스트라, 인접리스트 풀이
 * 시간복잡도 : O(|E|log|V|)
 */

class Node implements Comparable<Node> {
    int dist;
    int index;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node node) {
        return this.dist - node.dist;
    }

}

public class Main_2 {

    static final int MAX = (int) 1e9;

    static int n, m, k;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] dist;

    @SuppressWarnings("unchecked")
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        // 그래프를 인접리스트로 표현
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        dist = new int[n + 1];

        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, dist));
            graph[to].add(new Node(from, dist));
        }

    }// end of init

    public static void dijkstra() {
        // 거리 배열 초기화
        Arrays.fill(dist, MAX);

        // 시작 지점 우선순위 큐에 넣어줌, 거리가 가장 가까운 곳의 정보로 넣어줌 (거리, 인덱스)
        dist[k] = 0;
        pq.offer(new Node(k, 0));

        // 우선순위 큐가 비어있지 않으면 계속 진행
        while (!pq.isEmpty()) {
            // 가장 거리가 가까운 곳 정보 받은 뒤, 해당 정점 제거
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            // 가장 가까운 곳의 거리가 지금까지의 기록과 다르면 중복되서 들어온 것이므로 제외
            if (minDist != dist[minIndex])
                continue;

            // 현재까지 이동 거리가 최소인 정점에서 갈 수 있는 모든 정점의 거리 갱신
            for (int j = 0; j < graph[minIndex].size(); j++) {

                // 갈 수 있는 곳의 정점 번호와, 현재 정점에서 목적지로 가는 거리 정보
                int targetIndex = graph[minIndex].get(j).index;
                int targetDist = graph[minIndex].get(j).dist;

                // 현재 정점에서 목적지까지의 거리 = 출발지에서 현재 정점까지 오는데 걸린 거리 + 현재 정점에서 목적지까지 거리
                int newDist = dist[minIndex] + targetDist;

                // 지금까지 찾은 출발지에서 목적지까지의 거리보다 새로 찾은 거리가 짧으면 갱신후, 큐에 넣어줌
                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.offer(new Node(targetIndex, newDist));
                }
            }
        }
    }// end of dijkstra

    public static void sol() {
        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i] != MAX ? dist[i] : -1).append("\n");
        }

        System.out.println(sb.toString());
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class