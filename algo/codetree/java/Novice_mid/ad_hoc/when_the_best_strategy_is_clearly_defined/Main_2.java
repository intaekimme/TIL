package when_the_best_strategy_is_clearly_defined;

import java.io.*;
import java.util.*;

/**
 * 최소 와이파이 수
 * 사람이 존재하는 곳부터 m만큼 떨어진 지점에 와이파이를 설치한다.
 */
public class Main_2 {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 사람이 살고 있는 곳이 나오면
        // 와이파이를 해당 위치로부터 오른쪽으로 m만큼 떨어진 곳에 설치(= 가능한 멀리 설치)
        // 설치한 곳부터 오른쪽으로 m만큼도 커버가되므로 2m 떨어진 곳에서 다시 탐색 시작
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                ans++;
                i += 2 * m;
            }
        }

        System.out.println(ans);

    }// end of main
}
