package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;

/**
 * 캐리 피하기
 * 
 * 조합으로 모든 경우를 센다. -> 틀렸음
 * 이유
 * 나올 수 있는 숫자의 크기가 1 <= 숫자의 범위 <= 10_000 이었음
 * 그런데 자리수 구하는 것을 입력예제인 3자리 수만 보고 3자리만 검사함
 * 그래서 4자리의 경우 정확히 못 거름
 * 
 * 문제를 좀 더 정확히 보고 입력에 따라 오류가 발생할 수 있는 로직이 아닌 좀 더 정합성 있는 로직으로 짜야한다.
 */
public class Main_12 {
    static final int MAX_N = 20;

    static int n;
    static int carry_cnt = 0;
    static int max = Integer.MIN_VALUE;
    static int[] arr = new int[MAX_N];
    static int[] record = new int[3];

    static StringBuilder sb = new StringBuilder();
    static int[] index = new int[3];
    static int debug_cnt = 0;

    public static int hasCarry() {
        int num1 = record[0];
        int num2 = record[1];
        int num3 = record[2];

        for (int i = 0; i < 4; i++) {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            int digit3 = num3 % 10;

            if (digit1 + digit2 + digit3 >= 10)
                return 0;

            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }

        return record[0] + record[1] + record[2];
    }// end of hasCarry

    public static void func(int cnt, int start) {
        if (cnt == 3) {
            debug_cnt++;
            for (int n : index)
                sb.append(n).append(" ");

            int check_carry = hasCarry();
            if (check_carry == 0)
                carry_cnt++;
            else {
                if (check_carry > max) {
                    max = check_carry;
                    sb.append(" | ");
                    for (int n : record)
                        sb.append(n).append(" ");
                    sb.append(max);
                }
            }
            sb.append("\n");
            // max = Math.max(max, check_carry);
            return;
        }

        for (int i = start; i < n; i++) {
            index[cnt] = i;
            record[cnt] = arr[i];
            func(cnt + 1, i + 1);
        }

    }// end of func

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int comb = (n * (n - 1) * (n - 2)) / (3 * 2 * 1); // 모든 쌍 갯수

        func(0, 0);

        System.out.println(sb.toString());
        System.out.println(comb + " " + debug_cnt);
        if (carry_cnt == comb)
            System.out.println(-1);
        else
            System.out.println(max);

    }// end of main
}
