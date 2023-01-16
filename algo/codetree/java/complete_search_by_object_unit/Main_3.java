package complete_search_by_object_unit;

import java.io.*;
import java.util.*;

/**
 * 삼각형 만들기
 * 먼저 한 면이 x축에 평행하려면, 적어도 두 점의 y 좌표가 동일해야 한다.
 * 한 면이 y축에 평행하려면, 적어도 두 점의 x 좌표가 동일해야 한다.
 * 
 * 따라서 조건을 만족시키기 위해서는 세 점 중 x 좌표가 일치하는 쌍이 하나 이상 있어야 하며, y 좌표가 일치하는 쌍 역시
 * 하나 이상 있어야 한다.
 * 
 */
public class Main_3 {
    static int n;
    static int[] x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        x = new int[n];
        y = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isValid(i, j, k))
                        ans = Math.max(ans, getArea(i, j, k));
                }
            }
        }
        System.out.println(ans);

    }// end of main

    // 한 면은 x축에 평행, 한 면은 y축에 평행하려면은
    // 세 점 중 x좌표와 y좌표 각 각 같은게 2개 존재해야 한다.
    public static boolean isValid(int a, int b, int c) {
        if ((y[a] == y[b] && (x[a] == x[c] || x[b] == x[c])) ||
                (y[b] == y[c] && (x[a] == x[c] || x[b] == x[c])) ||
                (y[a] == y[c] && (x[a] == x[b] || x[b] == x[c])))
            return true;
        return false;

        // if((x[i] == x[j] || x[i] == x[k] || x[j] == x[k]) &&
        // (y[i] == y[j] || y[i] == y[k] || y[j] == y[k]))
        // 로 대체 가능
    }
    // public static boolean isValid(int a, int b, int c) {
    // if(dist(a,b) == dist(b,c) + dist(c,a)||
    // dist(a,c) == dist(a, b) + dist(b, c) ||
    // dist(b,c) == dist(a,c) + dist(a, b))
    // return true;
    // return false;
    // }// end of isValid

    // public static int dist(int i, int j){
    // return (int) Math.pow(x[i] - x[j], 2) + (int) Math.pow(y[i] - y[j], 2);
    // }

    public static int getArea(int i, int j, int k) {
        int area = (x[i] * y[j] + x[j] * y[k] + x[k] * y[i]) - (y[i] * x[j] + y[j] * x[k] + y[k] * x[i]);
        return Math.abs(area);
    }// end of getArea

}// end of class
