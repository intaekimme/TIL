import java.io.*;
import java.util.StringTokenizer;

/**
 * 1940. 가랏! RC카!
 */
public class Solution_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine()); // TC 케이스 수
        StringTokenizer st;
        StringBuilder sb = new StringBuilder(); // 출력 버퍼

        // TC 케이스 수만큼 반복
        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            int n = Integer.parseInt(br.readLine()); // 명령어 수

            int res = 0; // 최종 이동 거리
            int curSpeed = 0; // 현재 이동 속도
            // 입력 명령어 횟수만큼 반복
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine()); // 명령어 입력
                int command = Integer.parseInt(st.nextToken()); // 가속(1) or 감속(2) 명령어

                int acc = 0;
                if (command != 0) // 명령이 0이 아닐 때만 가속도 존재
                    acc = Integer.parseInt(st.nextToken()); // 가속도

                // 명령을 통한 현재 속도 갱신
                curSpeed = command(command, acc, curSpeed);
                // 1초 단위로 움직이므로 현재 속도가 곧 이동거리
                res += curSpeed;
            }

            sb.append(res).append("\n");

        } // end of tc

        System.out.println(sb.toString());
    }// end of main

    // 명령에 따른 이동속도 반환 함수(1초 단위)
    // 명령어, 가속도, 현재속도
    public static int command(int command, int acc, int speed) {
        // 감속 명령 : 현재 속도보다 감속할 속도가 더 클 경우, 속도는 0m/s가 된다.
        if (command == 2) {
            return speed < acc ? 0 : speed - acc;
        }
        // 현재 속도 유지 명령 or 가속 명령
        return speed + acc;
    }// end of move

}// end of class