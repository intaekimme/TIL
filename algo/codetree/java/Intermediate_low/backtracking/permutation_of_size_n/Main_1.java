package Intermediate_low.backtracking.permutation_of_size_n;

import java.io.*;
import java.util.*;

/**
 * 크기가 n인 순열
 */
public class Main_1 {
    static final int MAX_N = 8;

    static int n;
    static ArrayList<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited = new boolean[MAX_N + 1];

    public static void print() {
        for (int i = 0; i < arr.size(); i++)
            sb.append(arr.get(i)).append(" ");
        sb.append("\n");
    }// end of print

    public static void func(int cnt) {
        if (cnt == n) {
            print();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            arr.add(i);

            func(cnt + 1);

            visited[i] = false;
            arr.remove(arr.size() - 1);
        }

    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        func(0);

        System.out.print(sb.toString());

    }// end of main
}
