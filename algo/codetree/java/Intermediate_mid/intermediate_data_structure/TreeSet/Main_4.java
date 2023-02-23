package Intermediate_mid.intermediate_data_structure.TreeSet;

import java.io.*;
import java.util.*;

/**
 * 친한 점
 */

public class Main_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        TreeSet<Pair> set = new TreeSet<>();

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            set.add(new Pair(x, y));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            Pair p = new Pair(x, y);
            if (set.ceiling(p) == null)
                sb.append("-1 -1").append("\n");
            else
                sb.append(set.ceiling(p).toString()).append("\n");
        }

        System.out.println(sb.toString());

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
        if (this.x == p.x)
            return this.y - p.y; // 오른차순 정렬
        return this.x - p.x; // 오름차순 정렬
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

}// end of class