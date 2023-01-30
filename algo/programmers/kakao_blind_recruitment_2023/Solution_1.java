package programmers.kakao_blind_recruitment_2023;

import java.io.*;
import java.util.*;

/**
 * 2023 kakao blind recruitment
 * 개인정보 수집 유효기간
 * 
 * 날짜 함수와 해시 테이블 풀이
 */
class Solution_1 {

    public static void main(String[] args) throws IOException {
        Solution_1 ps = new Solution_1();

        String today = "2022.05.19";
        String[] terms = new String[] { "A 6", "B 12", "C 3" };
        String[] privacies = new String[] { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };

        int[] answer = ps.solution(today, terms, privacies);
        System.out.println(Arrays.toString(answer));
    }// end of main

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();

        int date = getDate(today);

        // 약관은 확인만하므로 향상된 for문 사용
        for (String s : terms) {
            String[] term = s.split(" ");
            termMap.put(term[0], Integer.parseInt(term[1]));
        }

        // 모든 개인정보 확인
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            // 개인 정보 입력 날짜와 약관을 더한 만료날짜가 오늘 날짜보다 이전이면 파기해야할 자료이므로 추가
            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date)
                answer.add(i + 1);
        }

        return answer.stream().mapToInt(integer -> integer).toArray();
    }// end of sol

    // 날짜 반환 함수, 0년 0월 0일 기준
    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }

}// end of class