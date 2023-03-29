package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * 주사위 윷놀이 17825
 * 
 */

public class Main_17825 {

    static int[] dice = new int[10];

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
    }// end of init

    public static void main(String[] args) throws IOException {
        init();
    }// end of main
}
