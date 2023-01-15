package fill_in_the_area;

import java.io.*;
import java.util.*;

public class Main_interesting_rectangle {

    static final int MAX_LEN = 200_000; // 2 * OFFSET
    static final int OFFSET = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Operation[] op = new Operation[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            op[i] = new Operation(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Tile2[] tiles = new Tile2[MAX_LEN];
        for (int i = 0; i < MAX_LEN; i++)
            tiles[i] = new Tile2();

        int start = 0 + OFFSET;
        for (int i = 0; i < n; i++) {
            if (op[i].dir.equals("R"))
                start = move(1, start, op[i].x, tiles);
            else
                start = move(-1, start, op[i].x, tiles);
        }

        int b = 0;
        int w = 0;
        for (int i = 0; i < MAX_LEN; i++) {
            if (tiles[i].color.equals("b"))
                b++;
            if (tiles[i].color.equals("w"))
                w++;
        }

        System.out.println(w + " " + b);

    }// end of main

    public static int move(int dir, int start, int len, Tile2[] tiles) {
        if (dir > 0) {
            for (int i = 1; i <= len; i++)
                tiles[start++].color = "b";
            return --start;
        }
        for (int i = 1; i <= len; i++)
            tiles[start--].color = "w";
        return ++start;
    }// end of move

}// end of class

class Operation {
    int x;
    String dir;

    public Operation(int x, String dir) {
        this.x = x;
        this.dir = dir;
    }
}

class Tile2 {
    String color = "g";
}
