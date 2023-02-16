package boj;

import java.io.*;
import java.util.*;

/**
 * 균형잡힌 세상, 스택
 */
public class Main_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            String query = br.readLine();
            if (query.equals("."))
                break;

            int len = query.length();
            Stack<Character> stack = new Stack<>();

            for (int i = len - 1; i >= 0; i--) {
                char cur = query.charAt(i);
                if (cur == ')' || cur == ']')
                    stack.push(cur);
                else {
                    if (cur != '(' && cur != '[')
                        continue;
                    if (stack.isEmpty()) {
                        stack.push(cur);
                        break;
                    } else {
                        if (stack.peek() == ')' && cur == '(')
                            stack.pop();
                        else if (stack.peek() == ']' && cur == '[')
                            stack.pop();
                        else
                            stack.push(cur);
                    }
                }
            }
            if (stack.size() > 0)
                sb.append("no\n");
            else
                sb.append("yes\n");

        } // end of while

        System.out.println(sb.toString());
    }// end of main

}// end of class
