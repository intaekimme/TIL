package boj;

import java.io.*;
import java.util.*;

/**
 * n과m (9) 15663
 * 자연수, 길이 m인 수열
 * 중복된 원소 존재
 * 중복되는 수열은 여러번 출력 x
 * 수열은 사전 순으로 증가하는 순서
 * 
 * 풀이 1
 * 순열 코드
 * 사전 순 출력을 위해 정렬 이용
 * 현재 뽑는 원소가 이전에 사용한 원소가 아니라면 뽑는다
 * 1) 방문배열로 확인
 * 2) 이전에 사용한 후보는 처음부터 확인하기 때문에 먼저 뽑은 원소와 동일한 원소를 확인할 때는 후보가 달라서 뽑힌다.
 */
public class Main_15663 {

    static int n, m;
    static int[] numbers, record;
    static boolean[] used;

    static StringBuilder sb = new StringBuilder();

    public static void func(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                sb.append(record[i]).append(" ");
            sb.append("\n");
            return;
        }

        int last_cand = 0;
        for (int cand = 0; cand < n; cand++) {
            if (used[cand])
                continue;
            if (numbers[cand] == last_cand)
                continue;
            last_cand = numbers[cand];
            record[depth] = numbers[cand];
            used[cand] = true;
            func(depth + 1);
            used[cand] = false;
        }

    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        record = new int[n];
        used = new boolean[n];
        func(0);

        System.out.print(sb.toString());
    }// end of main

}// end of class