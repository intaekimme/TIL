import java.io.*;
import java.util.*;

public class Main_fine {
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] students = new int[n + 1];
        int ans = -1;
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(br.readLine());
            if (++students[number] >= k) {
                ans = number;
                break;
            }
        }

        System.out.println(ans);

    }
}
