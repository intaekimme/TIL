package dx_dy_technique;

import java.io.*;
import java.util.*;

public class Main_come_back_2 {

    static final int[] dx = { 0, -1, 0, 1 };
    static final int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String query = br.readLine();

        int time = 0;
        int ans = -1;
        int cnt = 0;

        int dirNum = 0; // 초기 북쪽 방향

        int x = 0;
        int y = 0;

        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == 'F') {
                int nx = x + dx[dirNum];
                int ny = y + dy[dirNum];
                time++;

                if (nx == 0 && ny == 0 && cnt == 0) {
                    ans = time;
                    cnt++;
                }
                x = x + dx[dirNum];
                y = y + dy[dirNum];
            } else if (query.charAt(i) == 'R') {
                dirNum = (dirNum + 1) % 4;
                time++;
            } else if (query.charAt(i) == 'L') {
                dirNum = (dirNum - 1 + 4) % 4;
                time++;
            }
        } // end of query loop

        System.out.println(ans);

    }// end of main
}
