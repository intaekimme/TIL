package Novice_high.Array_Linked_list.Iterator;

import java.io.*;
import java.util.*;

/**
 * 황금비율 토스트
 */
public class Main_1 {

    static int n, m;
    static LinkedList<Character> bread = new LinkedList<>();
    static ListIterator<Character> it;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String input = br.readLine();

        for (int i = 0; i < n; i++)
            bread.add(input.charAt(i));
        it = bread.listIterator(bread.size());

        String query;
        char new_bread = ' ';
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            query = st.nextToken();
            if (st.hasMoreTokens())
                new_bread = st.nextToken().charAt(0);

            command(query, new_bread);
        }

        it = bread.listIterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }

        System.out.println(sb.toString());
    }// end of main

    public static void command(String query, char new_bread) {
        if (query.equals("L"))
            if (it.hasPrevious())
                it.previous();
        if (query.equals("R"))
            if (it.hasNext())
                it.next();
        if (query.equals("P"))
            it.add(new_bread);
        if (query.equals("D"))
            if (it.hasNext()) {
                it.next();
                it.remove();
            }
    }// end of command

}// end of class
