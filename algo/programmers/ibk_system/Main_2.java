package programmers.ibk_system;

import java.io.*;
import java.util.*;

/**
 * 2번 전광판 복기
 * 전광판 글자는 오른쪽에서 왼쪽으로 이동
 * 빈 공간은 _로 표시
 * 
 * 풀이
 * 전광판 크기 n 만큼 원래 텍스트 뒤에 _를 추가
 * 총 길이 2 * n의 텍스트를 만들음
 * 
 * 전광판 출력 인덱스는 2 * n에서 시작
 * 1초가 지날 때마다 인덱스 + 1
 * 그리고 주어진 초가 지난다음의 출력은 해당 인덱스부터 6개를 출력
 * 이 때 모듈러 연산이용
 */

public class Main_2 {

    public String solution(int n, String text, int second) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                sb.append("_");
            else
                sb.append(text.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            sb.append("_");
        }

        String str = sb.toString();

        sb = new StringBuilder();

        int idx = n;
        int time = second;

        while (second-- > 0) {
            if (second > 0)
                idx++;
            else
                for (int i = 0; i < n; i++)
                    sb.append(str.charAt((++idx) % str.length()));
        }

        System.out.println(time + "    " + sb.toString());

        return sb.toString();
    }// end of solution

    public static void main(String[] args) throws IOException {
        Main_2 m = new Main_2();

        for (int t = 0; t <= 13; t++) {
            m.solution(6, "hi bye", t);
        }
    }// end of main
}
