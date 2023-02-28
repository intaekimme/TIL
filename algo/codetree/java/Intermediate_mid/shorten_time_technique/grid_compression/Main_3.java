package Intermediate_mid.shorten_time_technique.grid_compression;

import java.io.*;
import java.util.*;

/**
 * 점 개수 세기, fail
 * 메모리 초과
 */

public class Main_3 {

    static int n, q;

    static Pair[] arr;

    static TreeSet<Integer> inputSet = new TreeSet<>();
    static TreeSet<Integer> querySet = new TreeSet<>();
    static TreeSet<Integer> inputQueryUnionSet = new TreeSet<>();
    static TreeSet<Integer> inputQueryInterSet = new TreeSet<>();

    static HashMap<Integer, Integer> queryMapper = new HashMap<>();
    static HashMap<Integer, Integer> inputQueryUnionMapper = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        // input 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());

            inputSet.add(val);
            inputQueryUnionSet.add(val);
        }

        arr = new Pair[q];

        // query 입력
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(a, b);

            querySet.add(a);
            querySet.add(b);

            inputQueryUnionSet.add(a);
            inputQueryUnionSet.add(b);

            if (inputSet.contains(a))
                inputQueryInterSet.add(a);
            if (inputSet.contains(b))
                inputQueryInterSet.add(b);
        }

        int idx = 1;
        for (Integer num : inputQueryUnionSet)
            inputQueryUnionMapper.put(num, idx++);

        idx = 1;
        for (Integer num : querySet)
            queryMapper.put(num, idx++);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            Pair query = arr[i];

            int a = query.a;
            int b = query.b;

            int a_union_idx = inputQueryUnionMapper.get(a);
            int b_union_idx = inputQueryUnionMapper.get(b);

            int input_union_query_cnt = b_union_idx - a_union_idx;

            int a_query_idx = queryMapper.get(a);
            int b_query_idx = queryMapper.get(b);

            int query_cnt = b_query_idx - a_query_idx;

            int intersect_cnt = 0;
            for (int j = a; j <= b; j++)
                if (inputQueryInterSet.contains(j))
                    intersect_cnt++;

            int res = input_union_query_cnt - query_cnt + intersect_cnt;

            sb.append(res).append("\n");
        } // end of for

        System.out.println(sb.toString());

    }// end of main

}// end of class

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}