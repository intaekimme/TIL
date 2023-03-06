package boj;

import java.io.*;
import java.util.*;

/**
 * N번째 큰 수
 * TreeSet과 pollFirst 메소드 실패 : 메모리초과
 */
public class Main_2705 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            set.pollFirst();
        }

        System.out.println(set.pollFirst());
    }// end of main

}// end of class
