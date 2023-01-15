package dx_dy_technique;

import java.io.*;
import java.util.*;

public class Main_movement_of_small_beads {
    // R, D, U, L
    static int[] dr = { 0, 1, -1, 0 };
    static int[] dc = { 1, 0, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String dir = st.nextToken();
        int d = getDir(dir);

        for (int i = 0; i < t; i++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (outOfRange(nr, nc, n)) {
                d = 3 - d;
            } else {
                r = nr;
                c = nc;
            }
        }

        System.out.println(r + " " + c);

    }// end of main

    public static int getDir(String dir) {
        if (dir.equals("U"))
            return 2;
        if (dir.equals("D"))
            return 1;
        if (dir.equals("R"))
            return 0;
        return 3;
    }// end of getDir

    public static boolean outOfRange(int x, int y, int n) {
        return (x < 1 || x > n || y < 1 || y > n);
    }

}
