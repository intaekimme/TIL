package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_simple;

import java.io.*;
import java.util.*;

/**
 * k개 중에 1개를 n번 뽑기
 */
public class Main_1 {

    static int n, k;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        func(0, 0);

    }// end of main

    public static void func(int start, int cnt) {
        if (cnt == n) {
            print();
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr.add(start, i);
            func(start + 1, cnt + 1);
            arr.remove(arr.size() - 1);
        }

    }// end of func

    public static void print() {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

}// end of class
