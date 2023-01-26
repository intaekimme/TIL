package boj.backtracking;

import java.io.*;
import java.util.*;

/**
 * 암호 만들기, 1759
 * 암호 구성
 * 1. '서로 다른' L개의 알파벳 소문자로 구성
 * 2. 최소 한 개의 모음(a, e, i, o, u)
 * 3. 최소 2개의 자음
 * 4. 사전식
 * 
 * C개의 문자가 주어짐
 * C개의 문자로 규칙을 만족하는 크기 L의 암호를 만들고
 * 이 암호들을 모두 출력하라
 * 
 * 풀이
 * 1. C개에서 L개를 뽑는 조합 생각
 * 2. 뽑은 조합이 3개의 규칙을 모두 만족하는지 확인
 * 2-1. 모음이 1개라도 확인이 되는가
 * 2-2. 자음이 2개 이상인가
 * 2-3. 사전식인가 -> 정렬을 먼저 함으로써 해결가능
 */

public class Main_1759 {

    static int L, C;
    static char[] arr;
    static char[] selected;

    static StringBuilder sb = new StringBuilder();

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        selected = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++)
            arr[i] = st.nextToken().charAt(0);

        Arrays.sort(arr);
    }// end of init

    /*
     * 2-2, 2-3
     * 뽑은 L개에서 자음, 모음 갯수를 세서 반환
     */
    public static int[] countAlph() {
        char[] vowel = new char[] { 'a', 'e', 'i', 'o', 'u' };

        int vowelCnt = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < 5; j++)
                if (selected[i] == vowel[j])
                    vowelCnt++;
        }
        int consonantCnt = L - vowelCnt;

        return new int[] { vowelCnt, consonantCnt };
    }// end of countVowel

    /*
     * 2. 뽑은 조합이 3개의 규칙을 모두 만족하는지 확인
     * 모두 만족하면 true 리턴
     * 하나라도 만족 못하면 false 리턴
     */
    public static boolean isValid() {
        int[] countRes = countAlph(); // 0 : 모음 갯수, 1 : 자음 갯수, size : 2
        if (countRes[0] < 1) // 2-1. 모음이 1개라도 확인이 되는가
            return false;
        if (countRes[1] < 2) // 2-2. 자음이 2개 이상인가
            return false;
        return true;
    }// end of isValid

    /*
     * 1. C개에서 L개를 뽑는 조합 생각
     */
    public static void func(int depth, int start) {
        if (depth == L) {
            if (!isValid())
                return;
            for (int i = 0; i < L; i++)
                sb.append(selected[i]);
            sb.append("\n");
            return;
        }

        for (int i = start; i < C; i++) {
            selected[depth] = arr[i];
            func(depth + 1, i + 1);
        }
    }// end of func

    public static void sol() {
        func(0, 0);
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.print(sb.toString());
    }// end of main
}// end of class
