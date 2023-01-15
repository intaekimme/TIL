import java.io.*;
import java.util.StringTokenizer;
import java.lang.Math;

/**
 * 1284. 수도 요금 경쟁
 */
public class Solution_1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            int w = Integer.parseInt(st.nextToken());

            int a = w * p;
            int b = w > r ? q + (w - r) * s : q;

            sb.append("#").append(tc).append(" ").append(Math.min(a, b)).append("\n");
        } // end of tc

        System.out.println(sb.toString());
    }// end of main

}// end of class
