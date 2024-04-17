package Intermediate_low.simulation.bomb_and_drop;

import java.io.*;
import java.util.*;

public class Main_3 {

    static int N, M;

    static int[] arr;
    static int[] nrr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        here: while (M <= N) {
            if (M == N) {
                boolean flag = true;
                for (int i = 0; i < arr.length - 1; i++) {
                    if (arr[i] == arr[i + 1])
                        flag = false;
                }
                if (flag)
                    break here;
            }

            // 방문 배열 생성
            nrr = new int[N];

            int ldx = 0;
            int rdx = 0;
            int sCnt = 0;

            while (rdx < N) {
                // 같다
                if (arr[ldx] == arr[rdx]) {
                    sCnt++;
                    rdx++;
                    continue;
                }
                // 다르다
                // 연속적인 같은 숫자가 M 보다 작다
                if (sCnt < M) {
                    for (int i = ldx; i < rdx; i++) {
                        nrr[i] = arr[i];
                    }
                    ldx = rdx;
                    sCnt = 0;
                    continue;
                }
                // 연속적인 같은 숫자가 M 보다 크거나 같다
                for (int i = ldx; i < rdx; i++) {
                    nrr[i] = -1;
                }
                ldx = rdx;
                sCnt = 0;
            }

            // rdx == N
            if (sCnt < M) {
                for (int i = ldx; i < rdx; i++) {
                    nrr[i] = arr[i];
                }
            } else {
                for (int i = ldx; i < rdx; i++) {
                    nrr[i] = -1;
                }
            }

            // 폭발해야될 수 계산
            int bombCnt = 0;
            for (int i = 0; i < arr.length; i++)
                bombCnt += nrr[i] == -1 ? 1 : 0;

            arr = new int[arr.length - bombCnt];
            int tmpRow = 0;

            // 폭발 및 폭발 결과 기록
            for (int i = 0; i < nrr.length; i++) {
                if (nrr[i] == -1)
                    continue;
                arr[tmpRow++] = nrr[i];
            }

            N = arr.length;
        } // end of while

        StringBuilder sb = new StringBuilder();
        sb.append(arr.length).append("\n");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());

    }// end of main

}// end of class
