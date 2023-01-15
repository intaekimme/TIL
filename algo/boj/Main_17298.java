package boj;

import java.io.*;
import java.util.*;

/**
 * 17298 오큰수 answer
 * 스택 사용
 * 시간 복잡도 : O(N)
 * 스택에 넣고 뺄때 확인하므로 들어가는 원소 갯수 N개 이상 시간이 걸리지 않는다.
 * 
 */
public class Main_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>(); // 스택, 사용이유 : 스택의 선입선출이 ~효과가 있다. 그리고 시간복잡도는 O(N)이다.
        int[] res = new int[N]; // 정답 넣을 공간

        // 배열의 뒤에서부터 확인
        for (int i = arr.length - 1; i >= 0; i--) {
            // (1) 스택의 top이 현재 들어가려는 원소보다 작으면 스택에서 pop
            // (2) 스택에서 pop을 하면 stack이 비는 순간이 발생할 수 있음. 이 때 top 조사식이 isEmpty보다 먼저 있으면
            // EmptyStackException 발생. 따라서 isEmpty를 먼저 조사.
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            if (stack.isEmpty()) // 위에서 스택에서 pop을 계속해 isEmpty로 탈출한 경우 (2)
                res[i] = -1; // 스택이 비었이으므로 -1
            else // 스택의 top이 현재 들어가는 원소보다 커서 탈출한 경우 (1)
                res[i] = stack.peek(); // 스택의 top이 정답
            stack.push(arr[i]); // 스택에 원소를 넣어줌.
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(res[i]).append(" ");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
