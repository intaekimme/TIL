package boj;

import java.io.*;
import java.util.*;

public class Main_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < n; tc++) {
            String arr = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int i = arr.length() - 1; i >= 0; i--) {
                if (arr.charAt(i) == ')')
                    stack.push(')');
                else {
                    if (stack.isEmpty())
                        stack.push('(');
                    else if (stack.peek() == ')')
                        stack.pop();
                }
            }
            if (stack.size() > 0)
                System.out.println("No");
            else
                System.out.println("Yes");
        } // end of tc
    }// end of main

}// end of class
