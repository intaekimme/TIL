import java.io.*;
import java.util.*;

/**
 * 1204. 최빈수 구하기
 */
public class Solution_1204 {

    static final int MAX_LEN = 1000; // 학생 1000명

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine()); // TC 케이스 수
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수만큼 반복
        for (int tc = 1; tc <= TC; tc++) {
            int n = Integer.parseInt(br.readLine()); // 테스트 번호
            sb.append("#").append(n).append(" "); // 출력 형식 출력

            StringTokenizer st;
            Node[] arr = new Node[MAX_LEN + 1]; // (점수, 카운트)에 관한 배열
            for (int i = 0; i <= MAX_LEN; i++)
                arr[i] = new Node(0, 0); // 초기화

            String input = br.readLine(); // 1000명의 점수 입력
            st = new StringTokenizer(input); // 띄어쓰기로 분리

            while (st.hasMoreTokens()) { // 1000명의 점수 모두 기록할 때까지 반복
                int i = Integer.parseInt(st.nextToken()); // 점수
                arr[i].val = i; // 점수 기록
                arr[i].cnt++; // 횟수 기록
            }

            Arrays.sort(arr); // 정렬기준으로 내림차순 정렬

            sb.append(arr[0].val).append("\n"); // 내림차순으로 정렬했기에 0번째가 최빈값이다.

        } // end of tc

        System.out.println(sb.toString()); // 정답 출력

    }// end of main

}// end of class

// 점수, 횟수 관리
class Node implements Comparable<Node> {
    int val; // 점수
    int cnt; // 횟수

    public Node(int val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Node node) {
        if (this.cnt == node.cnt) // 횟수가 같으면
            return node.val - this.val; // 점수 내림차순으로 정렬
        return node.cnt - this.cnt; // 이 외에는 횟수 내림차순으로 정렬
    }
}
