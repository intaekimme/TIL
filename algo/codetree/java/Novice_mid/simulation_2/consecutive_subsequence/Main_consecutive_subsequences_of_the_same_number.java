package consecutive_subsequence;

import java.io.*;
import java.util.*;

public class Main_consecutive_subsequences_of_the_same_number {

    static final int MAX = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] check = new int[MAX + 1];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        check[arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            int cnt = 1;
            int idx = i;
            while (idx < n && arr[idx - 1] == arr[idx]) {
                cnt++;
                idx++;
            }
            if (check[arr[i]] < cnt)
                check[arr[i]] = cnt;
        }

        int ans = 0;
        for (int i = 0; i <= MAX; i++)
            ans = check[i] > ans ? check[i] : ans;

        System.out.println(ans);
    }
}
