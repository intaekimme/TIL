package Intermediate_mid.shorten_time_technique.lr_technique;

import java.io.*;
import java.util.*;

/**
 * 마라톤 중간에 택시타기
 * 
 */

public class Main_1 {

    static int n;
    static Node[] arr;
    static int[] l, r;
    static int ans = (int) 1e9;

    public static int getDist(int i, int j) {
        int x1 = arr[i].x;
        int y1 = arr[i].y;

        int x2 = arr[j].x;
        int y2 = arr[j].y;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }// end of getDist

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new Node[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new Node(x, y);
        }

        l = new int[n];
        r = new int[n];

        // l 배열
        for (int i = 1; i < n; i++) {
            l[i] = getDist(i, i - 1) + l[i - 1];
        }

        // r 배열
        for (int i = n - 2; i >= 0; i--) {
            r[i] = getDist(i, i + 1) + r[i + 1];
        }

        // System.out.println(Arrays.toString(l));
        // System.out.println(Arrays.toString(r));

        // index = 1 ~ n - 2
        for (int i = 1; i <= n - 2; i++) {
            // ans = Math.min(ans, l[i - 1] + r[i + 1] + Math.abs(arr[i - 1] + arr[i + 1]));
            ans = Math.min(ans, l[i - 1] + r[i + 1] + getDist(i - 1, i + 1));
        }

        System.out.println(ans);

    }// end of main

}// end of class

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
