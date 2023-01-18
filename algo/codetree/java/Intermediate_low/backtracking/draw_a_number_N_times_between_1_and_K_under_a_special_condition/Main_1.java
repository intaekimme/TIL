package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_under_a_special_condition;

import java.io.*;
import java.util.*;

/**
 * 특정 조건에 맞게 k개 중에 1개를 n번 뽑기
 */
public class Main_1 {

    static int n, k;
    static ArrayList<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        func(0);

        System.out.print(sb.toString());
    }// end of main

    // cnt개 원소를 뽑았을 때 다음에 어떤 수를 뽑을지 선택하는 함수
    public static void func(int cnt) {
        if (cnt == n) {
            for (int i = 0; i < arr.size(); i++)
                sb.append(arr.get(i)).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (arr.size() >= 2) {
                if (!isValid(i, cnt))
                    continue;
            }
            arr.add(i);
            func(cnt + 1);
            arr.remove(arr.size() - 1);
        }
    }// end of func

    // 현재 순번에서 2개전을 확인해서 하나라도 다르면 유효성 검증 통과
    // 모두 같으면 유효성 검증 실패
    public static boolean isValid(int val, int cnt) {
        for (int i = cnt - 2; i < cnt; i++) {
            if (arr.get(i) != val)
                return true;
        }
        return false;
    }// end of isValid

}// end of class
