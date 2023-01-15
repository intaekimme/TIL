import java.io.*;
import java.lang.Math;

/**
 * 2805. 농작물 수확하기
 */
public class Solution_2805 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");

            int n = Integer.parseInt(br.readLine()); // 배열 크기

            int ans = 0; // 수확한 농작물 합

            int r = (n - 1) / 2; // 농장에 내접한 원 반지름
            for (int i = 0; i < n; i++) {
                // 입력배열이 다 붙어있음.
                String input = br.readLine();
                for (int j = 0; j < n; j++) {
                    int manhattan_distance = Math.abs(i - r) + Math.abs(j - r); // 맨하튼 거리
                    if (manhattan_distance <= r) // 마름모는 원에 포함, 따라서 반지름 내의 영역이 대상
                        ans += input.charAt(j) - '0'; // (i,j)를 읽은 효과
                }
            }

            sb.append(ans).append("\n");
        } // end of tc

        System.out.println(sb.toString());
    }// end of main

}// end of class
