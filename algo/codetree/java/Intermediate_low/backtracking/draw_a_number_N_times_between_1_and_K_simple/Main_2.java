package Intermediate_low.backtracking.draw_a_number_N_times_between_1_and_K_simple;

import java.io.*;

/**
 * 아름다운 수
 * 1. 규칙에 맞는 수를 생성한다. 중복순열
 * 2. 해당 수가 아름다운 수인지 판별한다.
 * 
 * 결과
 * 1 맞음
 * 2 틀림, 현재 위치부터 뒤에만 보니, 앞에서 이미 만족했어도 뒤에서
 * 
 */
public class Main_2 {

    static final int MAX_N = 10;
    static final int[] digit = new int[MAX_N + 1];
    static int n;
    static int ans = 0;
    static int NONE = -1;

    public static boolean isBeautifulNumber() {
        // 연달아 같은 숫자가 나오는 시작 위치를 잡는다.
        for (int i = 0; i < n; i += digit[i]) {
            // 만약 연속하여 해당 숫자만큼 나올 수 없으면
            // 아름다운 수가 아니다.
            if (i + digit[i] - 1 >= n)
                return false;
            // 연속하여 해당 숫자만큼 같은 숫자가 있는지 확인
            // 하나라도 다른 숫자가 있다면
            // 아름다운 수가 아님
            for (int j = i; j < i + digit[i]; j++) {
                if (digit[j] != digit[i])
                    return false;
            }
        }
        return true;
    }

    public static boolean isBeautifulNumber_fail() {
        boolean[] visited = new boolean[MAX_N + 1];

        // 자리 수 선택
        for (int i = 0; i < n; i++) {
            int num = digit[i]; // 해당 자리에 놓인 수
            int cnt = 0;
            // 해당 자리의 수만큼 같은 수가 있는지 확인
            for (int j = 0; j < num; j++) {
                // 확인하려는 자리가 범위를 넘거나 이미 확인한 수라면 pass
                if (i + j < n && !visited[i + j]) {
                    // 일치하지 않으면 아름다운 수 아님
                    if (num != digit[i + j])
                        return false;
                    else {
                        visited[i + j] = true;
                        cnt++;
                    }
                }
            }
            if (!visited[i] && cnt != num)
                return false;
        }
        return true;
    }

    public static void func(int depth, int cnt) {
        if (depth == n) {
            if (isBeautifulNumber())
                ans++;
            return;
        }

        for (int i = 1; i <= 4; i++) {
            digit[cnt] = i;
            func(depth + 1, cnt + 1);
        }
    }

    /**
     * 바텀업 방식
     * 
     * @param idx     : 자리
     * @param prevNum : 이전 자리수 수
     * @param prevCnt : 이전 자리수 센 횟수
     */
    public static void func2(int idx, int prevNum, int prevCnt) {
        // n자리 수를 완성
        if (idx == n) {
            // 이전 수와 자리수가 같으면 아름다운 수
            if (prevNum == prevCnt) {
                ans++;
            }
        } else { // n자리 수 만들기
            // 1. 처음 호출이거나
            // 2. 이전 자리수가 1이거나
            // 3. 이전 자리수와 나온 횟수가 같으면 (1, 1), (2, 22), (3, 333)과 같은 경우
            if (prevNum == NONE || prevNum == 1 || prevNum == prevCnt) {
                for (int i = 1; i <= 4; i++) {
                    digit[idx] = i;
                    // 다음 자릿수를 선택하고 처음 세므로 갯수 1
                    func2(idx + 1, i, 1);
                }
            } else {
                // 1. 처음 호출이 아니거나
                // 이전 자리수가 1이 아니거나
                // 이전 자리수와 나온 횟수가 일치하지 않은 경우(아직 출현횟수가 모자람) (1, ), (2, 2), (3, 33)
                for (int i = 1; i <= 4; i++) {
                    if (prevNum != i)
                        continue;
                    digit[idx] = i;
                    func2(idx + 1, i, prevCnt + 1);
                }
            }
        }
    }

    public static void sol() {
        // func(0, 0);
        func2(0, NONE, 0);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
        System.out.println(ans);
    }// end of main
}// end of class
