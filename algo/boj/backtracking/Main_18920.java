package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * nm과 k (1),18920_sol, 436ms
 * 
 * 풀이
 * n * m의 격자를 길이 n*m의 1차원 배열로 생각하고 k개를 뽑는 조합의 수를 생각
 * 찾은 조합 중 한점이라도 인접하는 경우는 제외하며 최댓값 갱신
 */
public class Main_18920 {
    static final int MAX_N = 10;
    static final int[] dx = { 0, -1, 0, 1 };
    static final int[] dy = { 1, 0, -1, 0 };

    static int n, m, k;
    static int[][] map = new int[MAX_N][MAX_N];
    static int[] selected;

    static int ans = Integer.MIN_VALUE;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
    }// end of init

    /**
     * 두 점이 인접하는지 확인하는 함수, 인접하면 true, 아니면 false 리턴
     * 
     * @param p1
     * @param p2
     * @return
     */
    public static boolean isAdj(int p1, int p2) {
        // 1차원 -> 2차원
        int x1 = p1 / m;
        int y1 = p1 % m;

        int x2 = p2 / m;
        int y2 = p2 % m;

        // x, y 좌표 둘 중 하나는 거리차가 0 이고 나머지는 1이면 인접
        return (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 0) ||
                (Math.abs(x1 - x2) == 0 && Math.abs(y1 - y2) == 1);

    }// end of isAdj

    /**
     * 뽑은 조합이 규칙에 맞는지 확인하는 함수, 맞으면 true, 아니면 false
     * 뽑은 점들 중 나올 수 있는 두 점의 경우 모두 체크
     * 
     * @return
     */
    public static boolean isPossible() {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++)
                if (isAdj(selected[i], selected[j]))
                    return false;
        }
        return true;
    }// end of isPossible

    /**
     * 뽑은 점들의 합을 구해서 반환
     * 
     * @return
     */
    public static int getSum() {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            // 1차원 -> 2차원
            int x = selected[i] / m;
            int y = selected[i] % m;

            sum += map[x][y];
        }
        return sum;
    }// end of getSum

    /**
     * n개의 원소에서 k개를 뽑는 조합
     * 
     * @param depth
     * @param start
     */
    public static void func(int depth, int start) {
        if (depth == k) {
            // for (int i = 0; i < k; i++)
            // System.out.print(selected[i] + " ");
            // System.out.println();

            if (!isPossible())
                return;

            ans = Math.max(ans, getSum());
            return;
        }

        for (int i = start; i < n * m; i++) {
            selected[depth] = i;
            func(depth + 1, i + 1);
        }
    }// end of func

    public static void sol() {
        selected = new int[k];

        func(0, 0);
    }// end of sol;

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}// end of calss