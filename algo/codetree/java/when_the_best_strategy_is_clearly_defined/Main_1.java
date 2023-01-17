package when_the_best_strategy_is_clearly_defined;

import java.io.*;

/**
 * 움직이는 블록
 * 그리디
 * 전체 블록의 갯수를 세고 평균을 낸다.
 * 평균에 맞춰야하기 때문에 평균보다 큰 곳의 블록들은 모두 옮겨줘야 하고 이것이 곧 옮기는 횟수이다.
 */
public class Main_1 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int avg = sum / n;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > avg)
                cnt += arr[i] - avg;
        }

        System.out.println(cnt);

    }// end of main
}
