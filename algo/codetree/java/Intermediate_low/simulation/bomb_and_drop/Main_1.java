package Intermediate_low.simulation.bomb_and_drop;

import java.io.*;
import java.util.*;

/**
 * 1차원 젠가
 */
public class Main_1 {
    static int n;
    static int[] arr, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        start = new int[2];
        end = new int[2];
        StringTokenizer st;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        int[] tmpArr;
        for (int i = 0; i < 2; i++) {
            int s = start[i];
            int e = end[i];

            tmpArr = new int[n];
            int tmpArrIdx = 0;
            for (int j = 0; j < n; j++) {
                if (s - 1 <= j && j <= e - 1)
                    continue;
                tmpArr[tmpArrIdx++] = arr[j];
            }

            Arrays.fill(arr, 0);
            System.arraycopy(tmpArr, 0, arr, 0, tmpArr.length);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                cnt++;
        }

        sb.append(cnt).append("\n");
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());

    }// end of main

}// end of class
