package Intermediate_mid.shortest_path.dijkstra;

import java.io.*;
import java.util.*;

/**
 * 최단거리 경로
 * 특정 시작점에서 특정 도착점으로 최단거리로 이동하기 위한 경로
 */
public class Main_4 {

    static final int MAX = (int) 1e9;

    static int n, m, a, b;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int[] path;
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
        path = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, w));
            graph[to].add(new Node(from, w));
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

    }// end of init

    public static void dijkstra() {
        Arrays.fill(dist, MAX);

        dist[a] = 0;
        pq.offer(new Node(a, 0));

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
                    path[targetIndex] = minIndex;
                }
            }
        }
    }// end of dijkstra

    public static void sol() {
        dijkstra();

        int x = b;
        ArrayList<Integer> vertices = new ArrayList<>();
        vertices.add(x);

        while (x != a) {
            x = path[x];
            vertices.add(x);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[b]).append("\n");
        for (int i = vertices.size() - 1; i >= 0; i--)
            sb.append(vertices.get(i)).append(" ");

        System.out.println(sb.toString());
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class

class Node implements Comparable<Node> {
    int index;
    int dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node node) {
        return this.dist - node.dist;
    }
}
