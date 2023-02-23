package Intermediate_mid.intermediate_data_structure.TreeSet;

import java.io.*;
import java.util.*;

/**
 * 정수 명령어
 * 문제대로라면 큐를 사용해서 풀어야함.
 * 큐에서 최댓값과 최솟값을 뽑는 과정에서 큐에 넣는 연산과 빼는 연산이 반드시 필요
 * TreeSet은 원소가 들어갈 때마다 중복을 제거한 상태로 오름차순 정렬이 O(logN)에 이루어짐
 * 그렇기 때문에 TreeSet을 이용하면 큐에 넣고 빼는 과정을 한 결과를 얻을 수 있음
 * 
 * 하지만 가장 효율적인 방법은 누적합을 구하듯이 푸는게 O(N)에 푸는 가장 효과적인 방법
 */

public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        String query;
        int val = 0;

        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            TreeSet<Integer> set = new TreeSet<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                query = st.nextToken();
                val = Integer.parseInt(st.nextToken());

                if (query.equals("I"))
                    set.add(val);
                if (query.equals("D")) {
                    if (set.isEmpty())
                        continue;
                    if (val == 1)
                        set.remove(set.last());
                    else
                        set.remove(set.first());
                }
            }

            if (set.isEmpty())
                sb.append("EMPTY").append("\n");
            else
                sb.append(set.last()).append(" ").append(set.first()).append("\n");
        }

        System.out.println(sb.toString());

    }// end of main

}// end of class
