package softeer;

import java.util.*;
import java.io.*;

/**
 * 1이상 k이하의 정수
 * 
 * 비밀 메뉴 조작 : m개의 버튼을 특정한 '순서'대로 눌러야함
 */

public class Main_3 {
    static int n, m, k;
    static String secret;
    static String input;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(st.nextToken());
        }
        secret = sb.toString();

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(st.nextToken());
        }
        input = sb.toString();
    }// end of init

    public static void sol() {
        if (input.contains(secret))
            System.out.println("secret");
        else
            System.out.println("normal");
    }// end of sol

    public static void main(String args[]) throws IOException {
        init();
        sol();
    }
}
