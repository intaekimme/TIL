package Intermediate_mid.intermediate_data_structure.Priority_Queue;

import java.io.*;
import java.util.*;

/**
 * 가장 가까운 점
 * 
 */

public class Main_4 {

    static int n, m;

    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.offer(new Pair(x, y));
        }

        for (int i = 0; i < m; i++) {
            Pair p = pq.poll();

            p.x += 2;
            p.y += 2;

            pq.offer(p);
        }

        System.out.println(pq.peek().x + " " + pq.peek().y);
    }// end of main

}// end of class

class Pair implements Comparable<Pair> {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if (getDist(this) == getDist(p)) {
            if (this.x == p.x)
                return this.y - p.y;
            return this.x - p.x;
        }
        return (getDist(this)) - (getDist(p));
    }

    public int getDist(Pair p) {
        return Math.abs(p.x) + Math.abs(p.y);
    }
}
