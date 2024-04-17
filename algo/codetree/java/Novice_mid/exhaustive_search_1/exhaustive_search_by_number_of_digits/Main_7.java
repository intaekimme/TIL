package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Node[] arr = new Node[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int dist = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            ArrayList<Node> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                list.add(arr[j]);
            }

            int subDist = 0;
            for (int j = 0; j < list.size() - 1; j++) {
                subDist += dist(list.get(j), list.get(j + 1));
            }
            dist = subDist < dist ? subDist : dist;
        }

        System.out.println(dist);

    }// end of main

    public static int dist(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
