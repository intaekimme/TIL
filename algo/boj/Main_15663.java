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
 * 풀이 2
 * 순열 코드
 * 순열을 그대로 뽑는다
 * 중복 발생
 * set을 이용해 중복을 제거한다.
 * 603ms
 * 
 * 풀이 1 : 204ms
 */
public class Main_15663 {

    static int n, m;
    static int[] numbers, record;
    static Set<String> set = new LinkedHashSet<>();
    static boolean[] used;

    public static void func(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++)
                sb.append(record[i]).append(" ");
            set.add(sb.toString());
            return;
        }

        for (int cand = 0; cand < n; cand++) {
            if (used[cand])
                continue;
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

        set.forEach(System.out::println);
    }// end of main

}// end of class