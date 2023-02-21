package Intermediate_mid.intermediate_data_structure.TreeMap;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * treemap 기본
 */
public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        String query;
        int[] param = new int[2];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            query = st.nextToken();

            int idx = 0;
            while (st.hasMoreTokens()) {
                param[idx++] = Integer.parseInt(st.nextToken());
            }

            if (query.equals("add"))
                map.put(param[0], param[1]);
            if (query.equals("find"))
                sb.append(map.containsKey(param[0]) ? map.get(param[0]) : "None").append("\n");
            if (query.equals("remove"))
                map.remove(param[0]);
            if (query.equals("print_list")) {
                if (map.isEmpty()) {
                    sb.append("None").append("\n");
                    continue;
                }

                Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();

                while (it.hasNext()) {
                    Entry<Integer, Integer> entry = it.next();
                    sb.append(entry.getValue()).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}