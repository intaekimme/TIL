package boj.simulation;

import java.io.*;
import java.util.*;

/**
 * 1593 문자해독, g5
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

public class Main_1593 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println((int) 'A' - 'A');
        System.out.println((int) 'Z' - 'A');
        System.out.println((int) 'a' - 'A');
        System.out.println((int) 'z' - 'A');

        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        String W = br.readLine();
        String S = br.readLine();

        int[] wCnt = new int[61];
        int[] sCnt = new int[61];
        for (int i = 0; i < g; i++) {
            wCnt[W.charAt(i) - 'A']++;
            sCnt[S.charAt(i) - 'A']++;
        }

        int ans = 0;

        // 하나 전을 체크하고 +1 슬라이딩 시킴
        for (int i = g; i < s; i++) {
            if (check(wCnt, sCnt))
                ans++;
            sCnt[S.charAt(i) - 'A']++;
            sCnt[S.charAt(i - g) - 'A']--;
        } // end of for

        // i = s - 1일 때 s - 2체크 후 +1 슬라이딩 시키고 i < s 조건 위배로 탈출
        // 따라서 s - 1일 때르 체크 못함
        // 그래서 마지막에 체크해줘야함
        if (check(wCnt, sCnt))
            ans++;

        System.out.println(ans);

        StringBuilder sb = new StringBuilder();

    }// end of main

    public static boolean check(int[] wCnt, int[] sCnt) {
        for (int i = 0; i < 61; i++) {
            if (wCnt[i] != sCnt[i])
                return false;
        }
        return true;
    }// end of check

}// end of class
