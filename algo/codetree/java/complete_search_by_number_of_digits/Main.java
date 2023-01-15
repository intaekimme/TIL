package complete_search_by_number_of_digits;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] rooms = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            rooms[i] = Integer.parseInt(br.readLine());
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += i != j ? rooms[j] * Math.abs(j - i) : 0;
            }
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
}
