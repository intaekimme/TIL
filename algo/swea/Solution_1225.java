
import java.io.*;
import java.util.*;

/**
 * 1225. [S/W 문제해결 기본] 7일차 - 암호생성기
 */
public class Solution_1225 {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(n).append(" ");

            // 암호문 만들기 시작
            st = new StringTokenizer(br.readLine());

            // 앞에서 꺼내고 뒤로 넣으면서 마지막이 0이면 중단해야함
            // Queue 사용
            Queue<Integer> que = new LinkedList<>();
            for (int i = 0; i < 8; i++)
                que.add(Integer.parseInt(st.nextToken())); // 8개 숫자 입력

            int m = 1; // 감소한 양
            // 암호 생성
            while (true) {
                int val = que.poll(); // 암호문의 앞에서 꺼냄
                // 암호문에서 일정양 감소시킴 -> 마지막 원소 예정 -> 마지막이 0이면 중단
                if (val - m <= 0) {
                    que.add(0);
                    break;
                }
                que.offer(val - m); // 아니면 마지막에 넣음
                m = m < 5 ? m + 1 : 1; // 감소양이 5미만이면 감소량 1증가, 5이상이면 1로 초기화
            }

            // que 출력
            Iterator<Integer> it = que.iterator();
            while (it.hasNext())
                sb.append(it.next()).append(" ");
            sb.append("\n");

        } // end of TC

        System.out.println(sb.toString());
    }// end of main

}// end of class
