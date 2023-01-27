package Novice_high.Stack_Queue_Deque.deque;

import java.io.*;
import java.util.*;

/**
 * 정수 명령 처리 3
 */
public class Main_1 {

    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String query = st.nextToken();
            int val = 0;
            if (st.hasMoreElements())
                val = Integer.parseInt(st.nextToken());

            command(query, val);
        }
    }// end of main

    public static void command(String query, int val) {
        if (query.equals("push_front"))
            deque.addFirst(val);
        if (query.equals("push_back"))
            deque.addLast(val);
        if (query.equals("pop_front"))
            System.out.println(deque.pollFirst());
        if (query.equals("pop_back"))
            System.out.println(deque.pollLast());
        if (query.equals("size"))
            System.out.println(deque.size());
        if (query.equals("empty"))
            System.out.println(deque.isEmpty() ? 1 : 0);
        if (query.equals("front"))
            System.out.println(deque.peekFirst());
        if (query.equals("back"))
            System.out.println(deque.peekLast());
    }// end of command

}// end of class