package boj;

import java.io.*;
import java.util.*;

/**
 * 입실 관리, b4
 */

public class Main_5524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(br.readLine().toLowerCase());
        }

        System.out.println(sb.toString());
    }
}
