package boj;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Stack toString 시
 * Stack의 top이 문자열 배열의 마지막(str.length-1)이 되고
 * bottom이 문자열 배열의 시작(str[0])가 됨
 * 
 * Deque toString 시
 * 들어간 그 모양 그대로 출력됨
 */
public class Stack_Deque_toString_Test {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();

        stack.push(5); // bottom
        stack.push(7);
        stack.push(7);
        stack.push(-1); // top

        Integer[] arr = new Integer[stack.size()];
        // [5,7,7,-1]
        System.out.println(stack.toString());
        // [5,7,7,-1]
        System.out.println(Arrays.toString(stack.toArray(arr)));

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(-1);
        deque.addFirst(7);
        deque.addFirst(7);
        deque.addFirst(5);
        // First 5 7 7 -1 Last

        // [5,7,7,-1]
        System.out.println(deque.toString());
        // 5 7 7 -1
        while (!deque.isEmpty()) {
            System.out.print(deque.pollFirst() + " ");
        }
    }
}
