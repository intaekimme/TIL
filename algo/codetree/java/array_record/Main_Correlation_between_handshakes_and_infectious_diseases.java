package array_record;

import java.io.*;
import java.util.*;

public class Main_Correlation_between_handshakes_and_infectious_diseases {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Developer[] developers = new Developer[N + 1];
        // N명의 개발자 생성
        for (int i = 1; i <= N; i++) {
            developers[i] = new Developer(0);
        }
        developers[P].K = K;
        developers[P].infect();

        // T개의 정보 입력 받음, t초에 x개발자와 y개발자가 악수를 했다는 정보
        Info[] infos = new Info[T];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            infos[i] = new Info(t, x, y);
        }

        Arrays.sort(infos, (a, b) -> a.time - b.time); // 입력 정보들을 시간 순으로 정렬

        for (int i = 0; i < T; i++) {
            Info info = infos[i];
            Developer x = developers[info.x];
            Developer y = developers[info.y];

            x.handshake(y, K);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(developers[i].isInfected);
        }

        System.out.println(sb.toString());
    }
}// end of class

class Developer {

    int isInfected = 0; // 0; 비감염, 1; 감염
    int K; // 전염시킬 수 있는 횟수

    public Developer(int K) {
        this.K = K;
    }

    public void infect() {
        this.isInfected = 1;
    }

    public void handshake(Developer y, int K) {
        if (this.isInfected == 1 && y.isInfected == 1) { // x 감염, y 감염
            this.K--;
            y.K--;
            return;
        }
        if (this.isInfected == 1 && y.isInfected == 0) { // x 감염, y 비감염
            if (this.K > 0) {
                y.isInfected = 1;
                y.K = K;
            }
            this.K--;
            return;
        }
        if (this.isInfected == 0 && y.isInfected == 1) { // x비감염, y감염
            if (y.K > 0) {
                this.isInfected = 1;
                this.K = K;
            }
            y.K--;
            return;
        }
        if (this.isInfected == 0 && y.isInfected == 0) { // x비감염, y비감염
            return;
        }
    }

}

class Info {
    int time; // 시간 t초
    int x; // x개발자
    int y; // y개발자

    public Info(int time, int x, int y) {
        this.time = time;
        this.x = x;
        this.y = y;
    }

}
