package Intermediate_low.dfs;

import java.io.*;
import java.util.*;

/**
 * 인접행렬을 이용한 양방향 연결 그래프 구현 및 dfs
 * 
 */

public class Main_1_1 {
    static int n, m;
    static int[][] adj;
    static boolean[] visited;

    static int cnt = 0; // 1번 정점에서 시작해 도달할 수 있는 서로 다른 정점 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            adj[s][e] = 1;
            adj[e][s] = 1;
        }

        visited = new boolean[n];
        int start = 0; // 1번 정점
        visited[0] = true; // 1번 정점 방문 처리

        dfs(start);

        System.out.println(cnt);

    }// end of dfs

    public static void dfs(int currV) {
        // 1번 정점부터 n번 정점까지 확인
        for (int i = 0; i < n; i++) {
            // 현재방문 중인 정점과 후보지 정점간에 연결이 있고 && 후보지 정점을 아직 방문하지 않았다면
            if (adj[currV][i] == 1 && !visited[i]) {
                visited[i] = true;
                cnt++;
                dfs(i); // 후보지 정점과 연결되어 있는 또 다른 정점 확인
            }
        }
    }// end of dfs

}// end of class