package Novice_high.Stack_Queue_Deque.stack;

import java.io.*;
import java.util.*;

/**
 * 정수 명령 처리
 */
public class Main_1 {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();

            int val = 0;
            if (st.hasMoreTokens())
                val = Integer.parseInt(st.nextToken());

            command(query, val);
        }

    }// end of main

    public static void command(String query, int val) {
        if (query.equals("push"))
            stack.push(val);
        if (query.equals("size"))
            System.out.println(stack.size());
        if (query.equals("pop"))
            System.out.println(stack.isEmpty() ? -1 : stack.pop());
        if (query.equals("empty"))
            System.out.println(stack.isEmpty() ? 1 : 0);
        if (query.equals("top"))
            System.out.println(stack.isEmpty() ? -1 : stack.peek());
    }// end of command
}// end of class
