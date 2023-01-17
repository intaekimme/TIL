package fill_in_the_area;

import java.io.*;
import java.util.*;

public class Main_back_and_forth {

    static final int MAX_LEN = 2000;
    static final int OFFSET = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Operation[] op = new Operation[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            op[i] = new Operation(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        int[] arr = new int[MAX_LEN];
        int idx = 0 + OFFSET;
        for (int i = 0; i < n; i++) {
            if (op[i].dir.equals("R"))
                idx = move(1, idx, op[i].x, arr);
            else
                idx = move(-1, idx, op[i].x, arr);
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 2)
                ans++;
        }

        System.out.println(ans);

    }// end of main

    public static int move(int dir, int start, int len, int[] arr) {
        if (dir > 0) {
            for (int i = 1; i <= len; i++) {
                arr[start++]++;
            }
            return start;
        }
        for (int i = 1; i <= len; i++) {
            arr[--start]++;
        }
        return start;
    }
}

class Operation {
    int x;
    String dir;

    public Operation(int x, String dir) {
        this.x = x;
        this.dir = dir;
    }
}