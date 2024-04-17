package Novice_mid.exhaustive_search_1.exhaustive_search_by_number_of_digits;

import java.io.*;

public class Main_11_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        int len = input.length();

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (j < len && k < len && input.charAt(i) == 'C' && input.charAt(j) == 'O'
                            && input.charAt(k) == 'W')
                        cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

}
