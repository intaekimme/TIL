package programmers.algorithm_practice_kit.stack_que;

import java.io.*;
import java.util.*;

/**
 * 다리를 지나는 트럭
 */
public class Solution_4 {

    Queue<Truck> wating_que = new LinkedList<>();
    Queue<Truck> bridge = new LinkedList<>();

    public void init(int[] truck_weights) {
        for (int i = 0; i < truck_weights.length; i++)
            wating_que.offer(new Truck(truck_weights[i]));
    }// end of init;

    public int process(int bridge_length, int weight) {
        int time = 1;
        int truck_on_bridge = 0;
        int tot_truck_w = 0;

        int tot_truck_num = wating_que.size();
        int across_bridge_num = 0;

        while (across_bridge_num < tot_truck_num) {

            if (!wating_que.isEmpty()) {
                Truck cur_truck = wating_que.peek();

                boolean isPossible = true;
                if (truck_on_bridge + 1 > bridge_length)
                    isPossible = false;
                if (tot_truck_w + cur_truck.w > weight)
                    isPossible = false;

                if (isPossible) {
                    cur_truck = wating_que.poll();
                    bridge.offer(cur_truck);

                    truck_on_bridge++;
                    tot_truck_w += cur_truck.w;
                }
            }

            Iterator<Truck> iter = bridge.iterator();
            while (iter.hasNext()) {
                Truck t = iter.next();
                t.pos++;

                if (t.pos >= bridge_length) {
                    truck_on_bridge--;
                    tot_truck_w -= t.w;
                    across_bridge_num++;
                    iter.remove();
                    // bridge.poll();
                }
            }

            time++;
        } // end of while

        return time;
    }// end of process

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        init(truck_weights);
        answer = process(bridge_length, weight);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution_4 ps = new Solution_4();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[] { 7, 4, 5, 6 };
        System.out.println(ps.solution(bridge_length, weight, truck_weights));
    }// end of main

}// end of class

class Truck {
    int pos = 0;
    int w;

    public Truck(int w) {
        this.w = w;
    }
}