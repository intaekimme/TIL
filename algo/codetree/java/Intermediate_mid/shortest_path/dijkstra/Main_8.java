package Intermediate_mid.shortest_path.dijkstra;

import java.io.*;
import java.util.*;

/**
 * 가장 가까운 거리의 최댓값
 * 
 * 모든 점으로 부터 특정 점까지의 최단거리 활용
 * 
 * 주어진 그래프 양방향그래프
 * 세 정점 a, b, c를 시작으로 최단거리를 구하여 기록한다.
 * a, b, c를 제외한 나머지 정점에서의 최단거리 중 최댓값을 갱신한다.
 * 
 * 1 2 5열은 제외
 * [1000000000, 0, 1, 4, 2, 4, 5]
 * [1000000000, 1, 0, 4, 3, 3, 5]
 * [1000000000, 4, 3, 7, 6, 0, 2]
 * 
 * 열 별로 갱신
 * 4 3 2
 */
public class Main_8 {

    static final int MAX = (int) 1e9;

    static int n, m;
    static int[] abc = new int[3];
    static ArrayList<Node>[] graph;
    static int[][] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static int ans = 0;

    @SuppressWarnings("unchecked")
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        dist = new int[3][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++)
            abc[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, w));
            graph[to].add(new Node(from, w));
        }
    }// end of init

    public static void dijkstra(int s_idx) {
        Arrays.fill(dist[s_idx], MAX);

        int start = abc[s_idx];
        dist[s_idx][start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if (minDist != dist[s_idx][minIndex])
                continue;

            for (int j = 0; j < graph[minIndex].size(); j++) {
                int targetIndex = graph[minIndex].get(j).index;
                int targetDist = graph[minIndex].get(j).dist;

                int newDist = dist[s_idx][minIndex] + targetDist;
                if (dist[s_idx][targetIndex] > newDist) {
                    dist[s_idx][targetIndex] = newDist;
                    pq.offer(new Node(targetIndex, newDist));
                }
            }
        }
    }// end of dijkstra

    public static int getMinDist(int col) {
        int res = (int) 1e7;
        for (int row = 0; row < 3; row++) {
            res = Math.min(res, dist[row][col]);
        }
        return res;
    }// end of getMinDist

    public static void sol() {
        for (int i = 0; i < 3; i++) {
            dijkstra(i);
            // System.out.println(Arrays.toString(dist[i]));
        }

        for (int i = 1; i <= n; i++) {
            if (i == abc[0] || i == abc[1] || i == abc[2])
                continue;
            ans = Math.max(ans, getMinDist(i));
        }

        System.out.println(ans);
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

    public int compareTo(Node node) {
        return this.dist - node.dist;
    }
}