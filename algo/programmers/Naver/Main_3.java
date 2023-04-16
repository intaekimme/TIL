package programmers.Naver;

import java.io.*;
import java.util.*;

/**
 * 네이버 3번 복기
 * 
 * 싱글의 난
 * 
 * 성격 값 : 1 ~ 1000
 * 성격 유형 : 1, 친근함 / -1, 색다름
 * 
 * 호감도 계산법
 * 친근함 : 1000 - |자신 성격 - 상대 성격|
 * 색다름 : |자신 성격 - 상대 성격|
 * 
 * 호감도 같은 이성 존재시 번호가 더 작은 이성 선택
 * 커플을 이루지 못한 참가자 중 호감도가 가장 높은 상대로 이상형
 * 남녀 서로 이상형으로 생각시 커플 성립
 * 
 * 가능한 커플의 수는?
 */

public class Main_3 {

    public int[] getIdle(int[][] arr1, int[][] arr2, int[] res, boolean[] visited1, boolean[] visited2) {
        for (int i = 0; i < arr1.length; i++) {
            if (visited1[i])
                continue;
            PriorityQueue<Node> pq = new PriorityQueue<>();

            for (int j = 0; j < arr2.length; j++) {
                if (visited2[j])
                    continue;
                if (arr1[i][1] == 1)
                    pq.add(new Node(j, 1000 - Math.abs(arr1[i][0] - arr2[j][0])));
                if (arr1[i][1] == -1)
                    pq.add(new Node(j, Math.abs(arr1[i][0] - arr2[j][0])));
            }
            if (!pq.isEmpty())
                res[i] = pq.poll().id;
        }

        return res;
    }// end of getIdle

    public int countCouple(int[] men, int[] women, boolean[] m_done, boolean[] w_done) {
        int cnt = 0;

        // 남자 후보자
        for (int cand = 0; cand < men.length; cand++) {
            int woman = men[cand]; // 남자 후보자의 이상형 여자
            int man = women[woman]; // 이상형 여자의 남자 이상형

            // 후보자가 여성의 이상형과 일치하면
            if (cand == man) {
                cnt++; // 커플 수 증가

                m_done[cand] = true; // 커플 선언
                w_done[woman] = true; // 커플 선언
            }
        }

        return cnt;
    }// end of countCouple

    public int solution(int[][] man, int[][] woman) {

        boolean[] m_done = new boolean[man.length];
        boolean[] w_done = new boolean[woman.length];

        int ans = 0;

        while (true) {
            int cnt = 0;

            int[] m_sel = new int[man.length];
            int[] w_sel = new int[woman.length];

            m_sel = getIdle(man, woman, m_sel, m_done, w_done);
            w_sel = getIdle(woman, man, w_sel, m_done, w_done);

            cnt = countCouple(m_sel, w_sel, m_done, w_done);

            if (cnt == 0)
                break;
            ans += cnt;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        Main_3 sol = new Main_3();

        int[][] man = new int[][] {
                { 750, -1 },
                { 580, -1 },
                { 760, 1 },
                { 60, 1 },
                { 120, 1 }
        };

        int[][] woman = new int[][] {
                { 720, -1 },
                { 600, 1 },
                { 750, 1 },
                { 740, 1 }
        };

        int ans = sol.solution(man, woman);

        System.out.println(ans);
    }// end of main

}// end of class

class Node implements Comparable<Node> {
    int id;
    int like;

    public Node(int id, int like) {
        this.id = id;
        this.like = like;
    }

    @Override
    public int compareTo(Node node) {
        if (this.like == node.like)
            return this.id - node.id; // id 오름차순
        return node.like - this.like; // 호감도 내림차순
    }
}// end of Node
