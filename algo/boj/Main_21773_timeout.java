package boj;

import java.io.*;
import java.util.*;

/**
 * 21773 가희와 프로세스 1
 */
public class Main_21773_timeout {
    static int T;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // 스케쥴러 생성
        PriorityQueue<Process> pq = new PriorityQueue<>();

        // 스케쥴러에 프로세스 기록
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int runningTime = Integer.parseInt(st.nextToken());
            int priority = Integer.parseInt(st.nextToken());
            pq.add(new Process(id, runningTime, priority));
        }

        StringBuilder sb = new StringBuilder();
        // T초 동안 실행, 단위 1초
        for (int t = 1; t <= T; t++) {
            // 1. 실행시킬 프로세스를 기준에 따라 선택, 선택된 프로세스의 id를 ids라 함. ids를 실행시킴.
            Process ids = pq.poll();

            // 선택된 프로세스 실행
            ids.run();
            // 실행된 프로세스 기록
            sb.append(ids.id).append("\n");

            // 프로세스 id가 ids인 프로세스를 제외한 나머지 프로세스들의 우선 순위가 1 상승
            pq = increasePriority(pq);

            // 실행된 프로세스를 다시 스케쥴러에 넣음
            pq.add(ids);
        }

        System.out.println(sb.toString());

    }// end of main

    // 프로세스들의 우선 순위가 1 상승
    public static PriorityQueue<Process> increasePriority(PriorityQueue<Process> pq) {
        Queue<Process> q = new LinkedList<>();
        while (!pq.isEmpty()) {
            q.add(pq.poll());
        }
        while (!q.isEmpty()) {
            Process p = q.poll();
            p.addPr();
            pq.add(p);
        }
        return pq;
    }
}// end of class

class Process implements Comparable<Process> {
    int id;
    int runningTime;
    int priority;

    public Process(int id, int runningTime, int priority) {
        this.id = id;
        this.runningTime = runningTime;
        this.priority = priority;
    }

    // 실행, 필요시간 1 감소.
    public void run() {
        this.runningTime--;
    }

    // 우선순위 1증가
    public void addPr() {
        this.priority++;
    }

    @Override
    public int compareTo(Process p) {
        // 우선 순위 값이 제일 큰 프로세스가 여러 개라면, id가 가장 작은 프로세스
        if (p.priority == this.priority)
            return this.id - p.id;
        // 우선 순위 값이 제일 큰 프로세스
        return p.priority - this.priority;
    }

}
