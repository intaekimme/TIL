package Novice_high.Stack_Queue_Deque.deque;

import java.io.*;
import java.util.*;

/**
 * 수열 조작
 */
public class Main_2 {

    static int n;
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++)
            deque.addLast(i);

        while (deque.size() != 1) {
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }

        System.out.println(deque.peekFirst());

    }// end of main

}// end of class
