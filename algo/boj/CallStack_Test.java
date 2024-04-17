package boj;

import java.io.*;
import java.util.*;

/**
 * 재귀함수를 이용한 dfs 사용시
 * 인자로 들어가는 list나 배열이 복귀시 원복이 되는지 확인
 * 
 * 
 * 실험 결과 : 원복이 되지 않는다.
 * 직접 복원시켜야만 복원이 된다.
 * static영역에서 생성한 거든 local영역에서 생성한 거든 상관없이 복원이 되지 않는다.
 */

public class CallStack_Test {

    static int n = 5;

    static int call = 0;

    static int[] static_arr = new int[5];

    static Noode static_node = new Noode(0, 0);

    public static void dfs(int cnt, Noode static_node, Noode local_node, int[] static_arr, int[] local_arr) {
        call++;
        if (cnt == n) {
            return;
        }

        // System.out.println(call + " cnt : " + cnt);
        System.out.println(Arrays.toString(static_arr));

        for (int i = cnt; i < n; i++) {
            static_node.x++;
            static_node.y++;

            local_node.x++;
            local_node.y++;

            static_arr[i] = i;
            local_arr[i] = i;

            dfs(cnt + 1, static_node, local_node, static_arr, local_arr);

            static_node.x--;
            static_node.y--;

            local_node.x--;
            local_node.y--;

            static_arr[i] = 0;
            local_arr[i] = 0;

        }

    }// end of dfs

    public static void main(String[] args) throws IOException {

        int[] local_arr = new int[5];

        Noode local_node = new Noode(0, 0);

        dfs(0, static_node, local_node, static_arr, local_arr);

        System.out.println(call);

    }
}

class Noode {
    int x;
    int y;

    public Noode(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
