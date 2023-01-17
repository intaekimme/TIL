package when_the_subject_to_be_considered_is_clearly_determined;

import java.io.*;
import java.util.*;

/**
 * A, B, C 찾기
 * A<=B<=C의 조건을 만족하는 3개의 정수 A, B, C 찾기
 * A, B, C, A + B, B + C, A + C, A + B + C가 랜덤으로 주어짐
 * 
 * 해결책
 * 확실한 것
 * 가장 큰 수 : A + B + C
 * 가장 작은 수 : A
 * 두번째로 작은 수 : B
 * 따라서 세번째로 작은 수 = 가장 큰 수 - (가장 작은 수 + 두번째로 작은 수)
 */
public class Main_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(arr[0] + " " + arr[1] + " " + (arr[6] - (arr[0] + arr[1])));
    }// end of main
}
