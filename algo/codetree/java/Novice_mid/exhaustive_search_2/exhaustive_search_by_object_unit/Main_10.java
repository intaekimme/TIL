package Novice_mid.exhaustive_search_2.exhaustive_search_by_object_unit;

import java.io.*;
import java.util.*;

public class Main_10 {

    static int n, b;
    static Present[] presents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        presents = new Present[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            presents[i] = new Present(p, s);
        }

        Arrays.sort(presents);

        // for(int i = 0; i < n; i++){
        // System.out.println(presents[i].p + " " + presents[i].s);
        // }

        int ans = -1;

        for (int i = 0; i < n; i++) {
            int budget = b;
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    if (budget - ((presents[j].p / 2) + presents[j].s) >= 0) {
                        budget -= (presents[j].p / 2) + presents[j].s;
                        cnt++;
                    }
                } else {
                    if (budget - (presents[j].p + presents[j].s) >= 0) {
                        budget -= presents[j].p + presents[j].s;
                        cnt++;
                    }
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);

    }// end of main

}// end of class

class Present implements Comparable<Present> {
    int p;
    int s;

    public Present(int p, int s) {
        this.p = p;
        this.s = s;
    }

    @Override
    public int compareTo(Present p) {
        if (this.p == p.p)
            return this.s - p.s;
        return this.p - p.p;
    }
}
