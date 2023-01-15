import java.io.*;
import java.util.*;

/**
 * 1208 [S/W 문제해결 기본] 1일차 - Flatten
 */
public class Solution_1208 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");

            int dump = Integer.parseInt(br.readLine());

            Integer[] arr = new Integer[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Comparator.reverseOrder());
            for (int i = dump; i > 0; i--) {
                arr[0]--;
                arr[arr.length - 1]++;
                Arrays.sort(arr, Comparator.reverseOrder());
            }

            int diff = arr[0] - arr[arr.length - 1];
            sb.append(diff).append("\n");

        }

        System.out.println(sb.toString());
    }
}