package when_the_subject_to_be_considered_is_clearly_determined;

import java.io.*;
import java.util.*;

public class Main_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int min_x1 = Math.min(x1, a1);
        int min_y1 = Math.min(y1, b1);
        int min_x2 = Math.max(x2, a2);
        int min_y2 = Math.max(y2, b2);

        int min_area = (min_x2 - min_x1) * (min_y2 - min_y1);

        System.out.println(min_area);

    }// end of main
}
