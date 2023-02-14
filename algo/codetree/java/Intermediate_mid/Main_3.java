package Intermediate_mid;

import java.io.*;
import java.util.*;

/**
 * 가장 오래 걸리는 학생2
 * 다른 모든 정점에서 어느 한 정점으로의 최단거리 구하기
 * 
 * naive : 다익스트라를 v번 더 돌림, 시간 복잡도 : O(|V||E|log|V|)
 * 최적화 : 모든 간선을 뒤집어서 목적지를 출발지라 생각하고 다익스트라 한 번 돌리기, 시간 복잡도 : O(|E|log|V|)
 */

public class Main_3 {

    static final int MAX = (int) 1e9;

    static int n, m;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    @SuppressWarnings("unchecked")
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        dist = new int[n + 1];

        // 그래프의 간선을 뒤집어 입력받음
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, w));
        }

    }// end of init

    public static void dijkstra() {
        Arrays.fill(dist, MAX);

        dist[n] = 0;
        pq.offer(new Node(n, 0));

        while (!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if (minDist != dist[minIndex])
                continue;

            for (int j = 0; j < graph[minIndex].size(); j++) {
                int targetDist = graph[minIndex].get(j).dist;
                int targetIndex = graph[minIndex].get(j).index;

                int newDist = dist[minIndex] + targetDist;
                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.offer(new Node(targetIndex, newDist));
                }
            }
        } // end of while

    }// end of dijkstra

    public static void sol() {
        dijkstra();

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != MAX)
                ans = Math.max(ans, dist[i]);
        }

        System.out.println(ans);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of sol

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