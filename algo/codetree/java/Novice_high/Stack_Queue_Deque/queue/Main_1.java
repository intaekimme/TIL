package Novice_high.Stack_Queue_Deque.queue;

import java.io.*;
import java.util.*;

/**
 * 정수 명령 처리2
 */
public class Main_1 {

    static Queue<Integer> queue = new LinkedList<>();

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
            queue.offer(val);
        if (query.equals("front"))
            System.out.println(queue.peek());
        if (query.equals("size"))
            System.out.println(queue.size());
        if (query.equals("empty"))
            System.out.println(queue.isEmpty() ? 1 : 0);
        if (query.equals("pop"))
            System.out.println(queue.poll());
    }// end of command
}// end of class

// 12
// push 2
// push 1
// front
// size
// empty
// pop
// pop
// size
// empty
// push 3
// push 4
// front

// 2
// 2
// 0
// 2
// 1
// 0
// 1
// 3
