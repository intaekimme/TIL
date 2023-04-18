package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 1539 문자해독, g5
 * 단어 하나를 아무렇게나 배열
 * 그 아무렇게나 배열된게 하나라도 있으면 그 단어가 있는것
 * 
 * 단어 W의 길이가 1 <= g <= 3000이다
 * 단어의 순열을 구해서 구하는 것은 시간초과로 불가능하다
 * 
 * 단어의 순서는 상관없다가 핵심 -> g로 주어진 길이에 주어진 단어의 갯수만 존재하면 된다
 * 
 * 인덱스 하나 이동할 때마다 g길이 만큼 확인하면 90억으로 시초
 */

public class Main_1539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        String W = br.readLine();
        String S = br.readLine();

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < g; i++) {
            set.add(W.charAt(i));
        }

        Iterator<Character> it = set.iterator();

        int[] pos = new int[set.size()];

        for (int i = 0; i < pos.length; i++) {
            char c = it.next();
            System.out.println(c + " " + (int) c);
            pos[i] = c - 'A';
        }

        int[] origin = new int[61];
        for (int i = 0; i < g; i++) {
            origin[W.charAt(i) - 'A']++;
        }

        // System.out.println(Arrays.toString(origin));

        // for (int i = 0; i < pos.length; i++) {
        // System.out.print(origin[pos[i]] + " ");
        // }

        for (int i = 0; i <= s - g; i++) {
            for (int j = 0; j < g; j++) {

            }
        }
    }// end of main
}// end of class
