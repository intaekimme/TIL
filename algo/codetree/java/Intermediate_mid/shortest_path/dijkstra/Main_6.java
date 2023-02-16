package Intermediate_mid.shortest_path.dijkstra;

import java.io.*;
import java.util.*;

public class Main_6 {

    static final int MAX_N = 1000;
    static final int MAX = (int) 1e9;

    static int n, m, a, b;

    @SuppressWarnings("unchecked")
    static ArrayList<Node>[] graph = new ArrayList[MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

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
                int targetIndex = graph[minIndex].get(j).index;
                int targetDist = graph[minIndex].get(j).dist;

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

        System.out.println(dist[b]);

    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of init

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
}// end of Node