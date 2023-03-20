package boj.priority_queue;

import java.io.*;
import java.util.*;

/**
 * 구하는 것 : i초가 되었을 때 선택한 프로세스의 id
 * 
 * 프로세스 갯수 : 최대 10만개
 * T초 : 최대 100만
 * 실행을 마치는 데 필요한 시간 : 최대 100만
 * 
 * 단순 시뮬레이션으로는 최대 10^11까지 가능하기 때문에 시간초과 발생함
 * 
 * id가 변하지 않는거에서 착안
 * 실행된 프로세스의 우선순위를 감소시킨다. 그러면 나머지 모든 프로세스의 우선순위가 1 증가한 효과를 지님
 * 
 */

public class Main_21773 {

    static int T, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        PriorityQueue<Process> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int pr = Integer.parseInt(st.nextToken());

            pq.offer(new Process(id, t, pr));
        }

        StringBuilder sb = new StringBuilder();
        for (int time = 0; time < T; time++) {
            if (pq.isEmpty())
                break;
            Process cur = pq.poll();
            sb.append(cur.id).append("\n");
            cur.pr--;
            cur.t = cur.t > 0 ? cur.t - 1 : 0;

            if (cur.t != 0)
                pq.offer(cur);
        }

        System.out.print(sb.toString());
    }// end of main

}// end of class

class Process implements Comparable<Process> {
    int id; // id
    int t; // 수행에 필요한 시간
    int pr; // 우선순위

    public Process(int id, int t, int pr) {
        this.id = id;
        this.t = t;
        this.pr = pr;
    }

    @Override
    public int compareTo(Process p) {
        if (this.pr == p.pr)
            return this.id - p.id; // id 오름차순
        return p.pr - this.pr; // 우선순위 내림차순
    }
}// end of class