package Intermediate_low.simulation.shift;

import java.io.*;
import java.util.*;

/**
 * 삼각형 컨베이어 벨트
 */

public class Main_2 {

    static int n, t;

    static int[] arr1, arr2, arr3;

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr1 = new int[n];
        arr2 = new int[n];
        arr3 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr1[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr3[i] = Integer.parseInt(st.nextToken());

    }// end of init

    public static void rotate() {
        int temp1 = arr1[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr1[i] = arr1[i - 1];
        }

        arr1[0] = arr3[n - 1];

        int temp2 = arr2[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr2[i] = arr2[i - 1];
        }
        arr2[0] = temp1;

        for (int i = n - 1; i > 0; i--) {
            arr3[i] = arr3[i - 1];
        }
        arr3[0] = temp2;

    }// end of rotate

    public static void printTriangle() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++)
            sb.append(arr1[i]).append(" ");
        sb.append("\n");

        for (int i = 0; i < n; i++)
            sb.append(arr2[i]).append(" ");
        sb.append("\n");

        for (int i = 0; i < n; i++)
            sb.append(arr3[i]).append(" ");
        sb.append("\n");

        System.out.println(sb.toString());
    }// end of printTriangle

    public static void sol() {
        while (t > 0) {
            rotate();
            t--;
        }
        printTriangle();
    }// end of sol

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }// end of main

}// end of class