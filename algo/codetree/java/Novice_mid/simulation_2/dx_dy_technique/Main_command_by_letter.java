package dx_dy_technique;

import java.io.*;
import java.util.*;

public class Main_command_by_letter {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int x = 0;
    static int y = 0;
    static int dir = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String query = br.readLine();

        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == 'L') {
                dir = (dir - 1 + 4) % 4;
                continue;
            }
            if (query.charAt(i) == 'R') {
                dir = (dir + 1) % 4;
                continue;
            }
            if (query.charAt(i) == 'F') {
                x = x + dx[dir];
                y = y + dy[dir];
            }
        }

        System.out.println(x + " " + y);
    }
}
