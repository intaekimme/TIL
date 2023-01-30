package programmers.kakao_blind_recruitment_2023;

import java.io.*;
import java.util.*;

/**
 * 2023 kakao blind recruitment
 * 택배 배달과 수거하기_fail
 * 
 * 스택, 그리디
 */
public class Solution_2 {

    public static void main(String[] args) throws IOException {
        Solution_2 ps = new Solution_2();
        int cap = 4;
        int n = 5;
        int[] deliveries = new int[] { 1, 0, 3, 1, 2 };
        int[] pickups = new int[] { 0, 3, 0, 4, 0 };
        ps.solution(cap, n, deliveries, pickups);
    }

    public long solution(int cap, int n, int[] deliverie, int[] pickup) {
        Stack<House> deliveries = new Stack<>();
        Stack<House> pickups = new Stack<>();

        for (int i = 0; i < n; i++) {
            deliveries.push(new House(i + 1, deliverie[i]));
            pickups.push(new House(i + 1, pickup[i]));
        }

        long answer = -1;

        while (!deliveries.isEmpty() || !pickups.isEmpty()) {
            if (deliveries.peek().cnt > pickups.peek().cnt)
                answer += 2 * deliveries.peek().no;
            else
                answer += 2 * pickups.peek().no;

            int delivery_cap = cap;
            while (delivery_cap > 0 || !deliveries.isEmpty()) {
                if (delivery_cap > deliveries.peek().cnt) {
                    delivery_cap -= deliveries.peek().cnt;
                    deliveries.pop();
                } else {
                    House h = deliveries.pop();
                    h.cnt -= delivery_cap;
                    delivery_cap = 0;
                    deliveries.push(h);
                }
            }

            int pickup_cap = cap;
            while (pickup_cap > 0 || !pickups.isEmpty()) {
                if (pickup_cap > pickups.peek().cnt) {
                    pickup_cap -= pickups.peek().cnt;
                    pickups.pop();
                } else {
                    House h = pickups.pop();
                    h.cnt -= pickup_cap;
                    pickup_cap = 0;
                    pickups.push(h);
                }
            }

        } // end of while

        return answer;
    }
}

class House {
    int no;
    int cnt;

    public House(int no, int cnt) {
        this.no = no;
        this.cnt = cnt;
    }
}
