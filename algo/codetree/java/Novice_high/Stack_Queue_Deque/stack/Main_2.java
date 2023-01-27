package Novice_high.Stack_Queue_Deque.stack;

import java.io.*;
import java.util.*;

/**
 * 괄호 문자열의 적합성 판단
 */
public class Main_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        String query = br.readLine();

        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == '(')
                stack.push('(');
            else {
                if (stack.isEmpty()) {
                    System.out.println("No");
                    System.exit(0);
                }
                stack.pop();
            }
        }

        System.out.println(stack.isEmpty() ? "Yes" : "No");

    }// end of main
}// end of class
