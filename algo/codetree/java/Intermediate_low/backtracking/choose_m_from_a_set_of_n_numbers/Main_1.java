package Intermediate_low.backtracking.choose_m_from_a_set_of_n_numbers;

import java.io.*;
import java.util.*;

public class Main_1 {

    static int n, m;
    static ArrayList<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void print() {
        for (int i = 0; i < arr.size(); i++)
            sb.append(arr.get(i)).append(" ");
        sb.append("\n");
    }// end of print

    // 지금까지 cnt개의 숫자를 뽑았고
    // 마지막으로 뽑은 숫자가 start일 때,
    // start보다 큰 남은 숫자 중에서 어떤 숫자를 뽑을지 선택하는 함수
    public static void func(int cnt, int start) {
        if (cnt == m) {
            print();
            return;
        }

        for (int i = start; i <= n; i++) {
            arr.add(i);
            func(cnt + 1, i + 1);
            arr.remove(arr.size() - 1);
        }

    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        func(0, 1);

        System.out.println(sb.toString());

    }// end of main

}// end of class
