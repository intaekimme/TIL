package picking_out_a_good_strategy;

import java.io.*;
import java.util.*;

/**
 * 연속된 숫자 만들기 2
 * 3번의 경우면 해결됨
 */
public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (arr[1] - arr[0] == 1 && arr[2] - arr[1] == 1)
            System.out.println(0);
        else if (arr[1] - arr[0] == 2 || arr[2] - arr[1] == 2)
            System.out.println(1);
        else
            System.out.println(2);

    }// end of main

}// end of class
