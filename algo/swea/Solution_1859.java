import java.io.*;

/**
 * 1859.백만 장자 프로젝트
 */
public class Solution_1859 {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 갯수
        int tc = Integer.parseInt(br.readLine());

        // 테스트 케이스 갯수만큼 반복
        for (int i = 1; i <= tc; i++) {
            // 매매가 n개
            int n = Integer.parseInt(br.readLine());

            // 매매가 배열, length : n
            int[] arr = new int[n];

            // 매매가 한 줄 입력받기, 구분자 " "(공백)
            String[] input = br.readLine().split(" ");

            // 매매가 배열에 입력 넣기
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }

            // 최대 이익, 함수 : 매매가 배열을 전달 받아 최대 이익을 반환
            long answer = sol(arr);

            // 출력 저장
            sb.append("#")
                    .append(i)
                    .append(" ")
                    .append(answer)
                    .append("\n");

        } // end of tc

        System.out.println(sb.toString());

    }// end of main

    // 매매가 배열을 전달 받아 최대 이익 반환
    public static long sol(int[] arr) {
        // 매입량 누적합
        long purchase = 0;
        // 매입 갯수
        int cnt = 0;
        // 매도 누적합
        long sell = 0;
        // 순이익
        long netProfit = 0;

        int idx = 0;
        while (idx < arr.length) {
            // 매매가 배열의 최댓값 인덱스, 범위 : 시작(idx)부터 끝까지
            int to = getMaxValueIndex(arr, idx);
            // 시작부터 최댓값 이전까지 모두 매입
            for (int i = idx; i < to; i++) {
                // 매입가 누적
                purchase += arr[i];
                // 매입 갯수 증가
                cnt++;
            }
            // 모두 매도
            if (cnt > 0) {
                // 매도가 = 현재 매도가 * 현재까지 매입한 물건 갯수, 매도가는 누적
                sell += arr[to] * cnt;
                // 모두 매도했으므로 물건 갯수 초기화
                cnt = 0;
            }
            // 최대 매매가 다음 인덱스부터 조사 준비
            idx = to + 1;
        }

        // 최종 순이익 = 누적 매도가 - 누적 매입가
        netProfit = sell - purchase;
        return netProfit;
    } // end of sol

    // 배열에서 최댓값의 인덱스를 반환, 범위 : start ~ 배열 끝
    public static int getMaxValueIndex(int[] arr, int start) {
        // 배열 최댓값, 초기값 int 최솟값
        int max = Integer.MIN_VALUE;
        // 최댓값 인덱스
        int idx = 0;
        // start부터 끝까지 조사
        for (int i = start; i < arr.length; i++) {
            // 현재 값이 지금까지 조사한 최댓값 보다 크면 최댓값과 인덱스 갱신
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        // 최댓값 인덱스 반환
        return idx;
    }// end of getMaxValueIndex

} // end of class

/**
 * 틀린 로직
 * // 매매가 배열을 전달 받아 최대 이익 반환
 * public static long sol(int[] arr) {
 * // 매입량 누적합
 * long purchase = 0;
 * // 매입 갯수
 * int cnt = 0;
 * // 매도 누적합
 * long sell = 0;
 * // 순이익
 * long netProfit = 0;
 * 
 * // 매매가 배열의 처음부터 끝까지 순회
 * for (int i = 0; i < arr.length; i++) {
 * // 현재 인덱스가 마지막 인덱스가 아니라면
 * if (i < arr.length - 1) {
 * // 현재 원소가 다음 원소보다 작거나 같으면 매입
 * if (arr[i] <= arr[i + 1]) {
 * purchase += arr[i];
 * cnt++;
 * } else {
 * // 아니다 크다
 * // 그런데 매입 갯수가 0 이상이면 현재 매도가로 모두 매도
 * if (cnt > 0) {
 * sell += cnt * arr[i];
 * cnt = 0;
 * }
 * }
 * } else {
 * // 현재 인덱스가 마지막 인덱스라면
 * // 그런데 매입 갯수가 0 이상이라면 현재 매도가로 모두 매도
 * if (cnt > 0) {
 * sell += cnt * arr[i];
 * }
 * }
 * } // end of for
 * 
 * netProfit = sell - purchase;
 * return netProfit;
 * } // end of sol
 */