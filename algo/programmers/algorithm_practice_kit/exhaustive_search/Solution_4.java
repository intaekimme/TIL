package programmers.algorithm_practice_kit.exhaustive_search;

/**
 * 카펫, lv2
 * 갈색과 노란색으로 직사각형이 만들어진다면
 * 노란색 직사각형의 가로 + 2, 세로 + 2가 정답
 * 
 * 노란색 직사각형 만드는 법 : 1 ~ yellow까지 증가시키면서 나머지 0인 경우
 * break point yello를 i로 나눈 몫이 i보다 커지면 break
 * 
 * 나머지가 0인 경우할 일
 * brown - (i * 2 + (yellow / i) * 2 + 4) == 0 인가
 */

class Solution_4 {

    public boolean isPossible(int brown, int a, int b) {
        return brown - (a * 2 + b * 2 + 4) == 0;
    }// end of isPossible

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int a = 1; a <= yellow; a++) {
            if (yellow % a != 0)
                continue;
            int b = yellow / a;
            if (a > b)
                break;
            if (!isPossible(brown, a, b))
                continue;
            answer[0] = b + 2;
            answer[1] = a + 2;
        }
        return answer;
    }// end of solution

}// end of class
