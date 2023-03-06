package boj;

import java.io.*;
import java.util.*;

/**
 * N번째 큰 수
 * TreeSet과 Iterator 실패 : 메모리초과
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

        Iterator<Integer> it = set.iterator();
        for (int i = 0; i < n - 1; i++) {
            it.next();
        }

        System.out.println(it.next());
    }// end of main

}// end of class
