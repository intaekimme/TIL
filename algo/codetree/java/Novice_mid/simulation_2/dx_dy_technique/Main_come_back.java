package dx_dy_technique;

import java.io.*;
import java.util.*;

public class Main_come_back {
    // N, E, S, W
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int x = 0;
        int y = 0;
        int time = 0;
        int ans = -1;
        int cnt = 0;

        // n개의 입력
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int dirNum = getDir(dir);

            int dis = Integer.parseInt(st.nextToken());

            for (int j = 0; j < dis; j++) {
                int nx = x + dx[dirNum];
                int ny = y + dy[dirNum];
                time++;

                if (nx == 0 && ny == 0 && cnt == 0) {
                    ans = time;
                    cnt++;
                }
                x = x + dx[dirNum];
                y = y + dy[dirNum];
            }
        } // end of for

        System.out.println(ans);
    }// end of main

    public static int getDir(String dir) {
        if (dir.equals("N"))
            return 0;
        if (dir.equals("E"))
            return 1;
        if (dir.equals("S"))
            return 2;
        return 3; // dir.equals("W")
    }
}// end of class
