package fill_in_the_area;

import java.io.*;
import java.util.*;

public class Main_white_black {

    static final int MAX_LEN = 200_000;
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

        Tile[] tiles = new Tile[MAX_LEN];
        for (int i = 0; i < MAX_LEN; i++)
            tiles[i] = new Tile();

        int start = 0 + OFFSET;
        for (int i = 0; i < n; i++) {
            if (op[i].dir.equals("R"))
                start = move(1, start, op[i].x, tiles);
            else
                start = move(-1, start, op[i].x, tiles);
        } // end of for

        int wAns = 0;
        int bAns = 0;
        int gAns = 0;
        for (int i = 0; i < MAX_LEN; i++) {
            if (tiles[i].cur.equals("W"))
                wAns++;
            if (tiles[i].cur.equals("B"))
                bAns++;
            if (tiles[i].cur.equals("G"))
                gAns++;
        }

        System.out.println(wAns + " " + bAns + " " + gAns);

    }// end of main

    // 타일 칠하는 사람이 움직이는 함수
    // len 만큼 반복하며 움직임.
    // 움직이면서 타일을 칠하고
    // 마지막에 서있는 위치를 반환
    public static int move(int dir, int start, int len, Tile[] tiles) {
        if (dir > 0) {
            for (int i = 1; i <= len; i++) {
                tiles[start++].painting(dir);
            }
            return --start;
        }
        for (int i = 1; i <= len; i++) {
            tiles[start--].painting(dir);
        }
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

class Tile {
    String cur = "";
    int wCnt = 0;
    int bCnt = 0;

    public void painting(int dir) {
        this.cur = dir > 0 ? "B" : "W";
        if (dir > 0)
            this.wCnt++;
        else
            this.bCnt++;
        if (wCnt >= 2 && bCnt >= 2)
            this.cur = "G";
    }
}
