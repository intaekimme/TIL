package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 17298 오큰수 timeout
 */

/**
 * 정렬을 위해 값과 위치 정보 필요.
 */
class Node {
    int val;
    int pos;

    public Node(int val, int pos) {
        this.val = val;
        this.pos = pos;
    }
}

public class Main_17298_timeout {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] arr = new Node[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 arr 입력
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(Integer.parseInt(st.nextToken()), i);
        }

        int[] ans = new int[n]; // 정답 배열
        for (int i = 0; i < n; i++) {
            ans[i] = sol(i, arr);
        }

        StringBuilder sb = new StringBuilder();
        for (int val : ans)
            sb.append(val).append(" ");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }// end of main

    // 원소 Ai 마다 오큰수 NGE(i)를 구해 반환하는 함수
    // 오큰수가 존재하면 return NGE(i)
    // 존재하지 않으면 return -1
    public static int sol(int idx, Node[] arr) {
        int nge = 0; // 반환할 오큰수
        int Ai = arr[idx].val; // 원소 Ai 값

        // (i, arr.length] 까지 슬라이싱
        // 배열의 마지막 원소의 경우 예외발생 = 오큰수 존재하지 않음 = return -1
        Node[] slice;
        try {
            slice = Arrays.copyOfRange(arr, idx, arr.length);
        } catch (Exception e) {
            return -1;
        }

        // slice한 배열을 값으로 정렬, 오름차순
        Arrays.sort(slice, (a, b) -> a.val - b.val);

        int posMinNge = 0; // 오큰수 중 가장 작은 값의 위치

        // 정렬한 배열에서 원소 Ai 다음으로 큰 원소 찾기, 이 이후 원소는 모두 Ai보다 큼.
        // 따라서 위치 조사 대상
        for (int i = 0; i < slice.length; i++) {
            if (slice[i].val > Ai) {
                posMinNge = i;
                break; // 최초로 찾았으므로 검색 중단.
            }
            posMinNge = -1;// Ai보다 큰 원소가 존재하지 않음 = 오큰수 존재하지 않음 -> slice에서 예외발생
        }

        // 목표값 이후부터 범위 재설정
        try {
            slice = Arrays.copyOfRange(slice, posMinNge, slice.length);
        } catch (Exception e) {
            return -1;
        }

        // 위치로 정렬, 오름차순
        Arrays.sort(slice, (a, b) -> a.pos - b.pos);

        //
        nge = slice[0].val;
        return nge; // 오큰수 반환
    }// end of sol

}// end of class